// Problem Page Script
class ProblemPage {
    constructor() {
        this.problem = null;
        this.githubAPI = new GitHubAPI('namann2', 'Leetcode');
        this.init();
    }

    async init() {
        this.loadProblemData();
        await this.fetchProblemDetails();
        this.setupEventListeners();
    }

    loadProblemData() {
        // Get problem data from localStorage or URL parameters
        const storedProblem = localStorage.getItem('currentProblem');
        if (storedProblem) {
            this.problem = JSON.parse(storedProblem);
        } else {
            // Fallback: parse from URL parameters
            const urlParams = new URLSearchParams(window.location.search);
            const slug = urlParams.get('slug');
            if (slug) {
                // Create basic problem object from slug
                this.problem = this.parseProblemFromSlug(slug);
            }
        }

        if (!this.problem) {
            this.showError('Problem not found');
            return;
        }

        this.updateBasicInfo();
    }

    parseProblemFromSlug(slug) {
        const match = slug.match(/^(\d{4})-(.+)$/);
        if (!match) return null;

        const [, numberStr, titleSlug] = match;
        const number = parseInt(numberStr);
        const title = titleSlug.split('-')
            .map(word => word.charAt(0).toUpperCase() + word.slice(1))
            .join(' ');

        return {
            number,
            title,
            slug,
            githubUrl: `https://github.com/namann2/Leetcode/tree/master/${slug}`,
            difficulty: 'Medium', // Default
            topics: ['Array'] // Default
        };
    }

    updateBasicInfo() {
        // Update page title and header
        document.title = `${this.problem.title} - LeetCode Solutions`;
        document.getElementById('problemTitle').textContent = this.problem.title;
        document.getElementById('problemDetailTitle').textContent = this.problem.title;
        document.getElementById('problemNumberBadge').textContent = `#${this.problem.number}`;
        
        // Update difficulty badge
        const difficultyBadge = document.getElementById('problemDifficultyBadge');
        difficultyBadge.textContent = this.problem.difficulty;
        difficultyBadge.className = `difficulty-badge difficulty-${this.problem.difficulty.toLowerCase()}`;

        // Update action links
        document.getElementById('githubLink').href = this.problem.githubUrl;
        document.getElementById('leetcodeLink').href = `https://leetcode.com/problems/${this.problem.slug.replace(/^\d{4}-/, '')}/`;

        // Update topics
        const topicsContainer = document.getElementById('problemTopics');
        topicsContainer.innerHTML = this.problem.topics.map(topic => `
            <span class="topic-tag">${topic}</span>
        `).join('');
    }

    async fetchProblemDetails() {
        try {
            // Fetch folder contents from GitHub
            const folderContents = await this.githubAPI.fetchRepositoryContents(this.problem.slug);
            
            // Look for different types of files
            const javaFile = folderContents.find(file => file.name.endsWith('.java'));
            const readmeFile = folderContents.find(file => file.name.toLowerCase() === 'readme.md');
            const notesFile = folderContents.find(file => file.name.toLowerCase().includes('notes'));
            const imageFiles = folderContents.filter(file => 
                file.name.match(/\.(png|jpg|jpeg|gif|svg)$/i)
            );

            // Fetch and display solution code
            if (javaFile) {
                await this.loadSolutionCode(javaFile);
            }

            // Fetch and display README/description
            if (readmeFile) {
                await this.loadProblemDescription(readmeFile);
            }

            // Load notes if available
            if (notesFile) {
                await this.loadNotes(notesFile);
            }

            // Load images if available
            if (imageFiles.length > 0) {
                this.loadImages(imageFiles);
            }

        } catch (error) {
            console.error('Error fetching problem details:', error);
            this.showError('Failed to load problem details');
        }
    }

    async loadSolutionCode(javaFile) {
        try {
            const content = await this.githubAPI.fetchFileContent(`${this.problem.slug}/${javaFile.name}`);
            if (content) {
                document.getElementById('solutionCode').innerHTML = `<code class="language-java">${this.escapeHtml(content)}</code>`;
                // Trigger syntax highlighting
                if (typeof Prism !== 'undefined') {
                    Prism.highlightAll();
                }
            }
        } catch (error) {
            console.error('Error loading solution code:', error);
        }
    }

    async loadProblemDescription(readmeFile) {
        try {
            const content = await this.githubAPI.fetchFileContent(`${this.problem.slug}/${readmeFile.name}`);
            if (content) {
                // Parse markdown content
                const parsedContent = this.parseMarkdown(content);
                document.getElementById('problemDescription').innerHTML = parsedContent;
                
                // Show description section
                document.getElementById('problemDescription').parentElement.style.display = 'block';
            }
        } catch (error) {
            console.error('Error loading problem description:', error);
        }
    }

    async loadNotes(notesFile) {
        try {
            const content = await this.githubAPI.fetchFileContent(`${this.problem.slug}/${notesFile.name}`);
            if (content) {
                const parsedContent = this.parseMarkdown(content);
                document.getElementById('problemNotes').innerHTML = parsedContent;
                document.getElementById('notesSection').style.display = 'block';
            }
        } catch (error) {
            console.error('Error loading notes:', error);
        }
    }

    loadImages(imageFiles) {
        const imagesContainer = document.getElementById('problemImages');
        imagesContainer.innerHTML = imageFiles.map(image => `
            <img src="${image.download_url}" alt="${image.name}" class="problem-image" loading="lazy">
        `).join('');
        document.getElementById('imagesSection').style.display = 'block';
    }

    parseMarkdown(markdown) {
        // Simple markdown parser for basic formatting
        let html = markdown
            // Headers
            .replace(/^### (.*$)/gim, '<h3>$1</h3>')
            .replace(/^## (.*$)/gim, '<h2>$1</h2>')
            .replace(/^# (.*$)/gim, '<h1>$1</h1>')
            // Bold
            .replace(/\*\*(.*)\*\*/gim, '<strong>$1</strong>')
            // Italic
            .replace(/\*(.*)\*/gim, '<em>$1</em>')
            // Code blocks
            .replace(/```([\s\S]*?)```/gim, '<pre><code>$1</code></pre>')
            // Inline code
            .replace(/`([^`]*)`/gim, '<code>$1</code>')
            // Links
            .replace(/\[([^\]]*)\]\(([^\)]*)\)/gim, '<a href="$2" target="_blank">$1</a>')
            // Line breaks
            .replace(/\n/gim, '<br>');

        return html;
    }

    escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }

    setupEventListeners() {
        // Tab switching for solution languages
        document.querySelectorAll('.tab-btn').forEach(btn => {
            btn.addEventListener('click', (e) => {
                // Remove active class from all tabs
                document.querySelectorAll('.tab-btn').forEach(tab => tab.classList.remove('active'));
                // Add active class to clicked tab
                e.target.classList.add('active');
                
                // Here you could load different language solutions
                const lang = e.target.dataset.lang;
                this.switchLanguage(lang);
            });
        });
    }

    switchLanguage(language) {
        // This would switch between different language solutions
        // For now, we'll just update the code block class
        const codeBlock = document.querySelector('#solutionCode code');
        if (codeBlock) {
            codeBlock.className = `language-${language}`;
            if (typeof Prism !== 'undefined') {
                Prism.highlightAll();
            }
        }
    }

    showError(message) {
        document.getElementById('problemDescription').innerHTML = `
            <div class="empty-state">
                <h3>Error</h3>
                <p>${message}</p>
                <a href="index.html">← Back to Problems</a>
            </div>
        `;
    }
}

// GitHub API class (reused from main script)
class GitHubAPI {
    constructor(username, repo) {
        this.username = username;
        this.repo = repo;
        this.baseUrl = `https://api.github.com/repos/${username}/${repo}`;
    }

    async fetchRepositoryContents(path = '') {
        try {
            const response = await fetch(`${this.baseUrl}/contents/${path}`);
            if (!response.ok) throw new Error('Failed to fetch repository contents');
            return await response.json();
        } catch (error) {
            console.error('Error fetching repository contents:', error);
            return [];
        }
    }

    async fetchFileContent(path) {
        try {
            const response = await fetch(`${this.baseUrl}/contents/${path}`);
            if (!response.ok) throw new Error('Failed to fetch file content');
            const data = await response.json();
            return atob(data.content); // Decode base64 content
        } catch (error) {
            console.error('Error fetching file content:', error);
            return null;
        }
    }
}

// Initialize the problem page when DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    new ProblemPage();
});
