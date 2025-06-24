// LeetCode Solutions Website Script
class LeetCodeSolutions {
    constructor() {
        this.problems = [];
        this.topics = new Map();
        this.filteredProblems = [];
        this.currentTopic = '';
        this.currentDifficulty = '';
        this.searchQuery = '';
        
        this.init();
    }

    async init() {
        this.showLoading();
        await this.fetchProblems();
        await this.fetchLeetCodeProfile();
        this.setupEventListeners();
        this.renderTopics();
        this.renderProblems();
        this.updateStats();
    }

    async fetchLeetCodeProfile() {
        try {
            // Calculate dynamic stats based on repository data
            const totalSolved = this.problems.length;
            const easySolved = this.problems.filter(p => p.difficulty === 'Easy').length;
            const mediumSolved = this.problems.filter(p => p.difficulty === 'Medium').length;
            const hardSolved = this.problems.filter(p => p.difficulty === 'Hard').length;

            const profileData = {
                totalSolved: totalSolved,
                easySolved: easySolved,
                mediumSolved: mediumSolved,
                hardSolved: hardSolved,
                ranking: 'N/A',
                contestsAttended: 0
            };

            this.updateLeetCodeStats(profileData);
            
            // Update the header stats to show repository count
            document.getElementById('totalProblems').textContent = this.problems.length;
            document.getElementById('totalTopics').textContent = this.topics.size;
            
        } catch (error) {
            console.error('Error fetching LeetCode profile:', error);
            // Use repository data as fallback
            const totalSolved = this.problems.length;
            const easySolved = this.problems.filter(p => p.difficulty === 'Easy').length;
            const mediumSolved = this.problems.filter(p => p.difficulty === 'Medium').length;
            const hardSolved = this.problems.filter(p => p.difficulty === 'Hard').length;

            const profileData = {
                totalSolved: totalSolved,
                easySolved: easySolved,
                mediumSolved: mediumSolved,
                hardSolved: hardSolved,
                ranking: 'N/A',
                contestsAttended: 0
            };
            this.updateLeetCodeStats(profileData);
        }
    }

    updateLeetCodeStats(data) {
        document.getElementById('leetcodeTotal').textContent = data.totalSolved;
        document.getElementById('leetcodeEasy').textContent = data.easySolved;
        document.getElementById('leetcodeMedium').textContent = data.mediumSolved;
        document.getElementById('leetcodeHard').textContent = data.hardSolved;
        document.getElementById('leetcodeRank').textContent = data.ranking;
        document.getElementById('leetcodeContests').textContent = data.contestsAttended;
    }

    showLoading() {
        const problemsList = document.getElementById('problemsList');
        problemsList.innerHTML = `
            <div class="loading">
                <div class="spinner"></div>
                <span>Loading problems...</span>
            </div>
        `;
    }

    async fetchProblems() {
        try {
            // This would typically fetch from GitHub API
            // For now, we'll parse the existing data structure
            this.problems = await this.parseProblemsFromGitHub();
        } catch (error) {
            console.error('Error fetching problems:', error);
            this.showError();
        }
    }

    async parseProblemsFromGitHub() {
        try {
            // Fetch repository contents from GitHub API
            const githubAPI = new GitHubAPI('namann2', 'Leetcode');
            const contents = await githubAPI.fetchRepositoryContents();
            
            console.log('GitHub API Response:', contents);
            
            // Filter directories that match LeetCode problem pattern (4-digit number prefix)
            const problemFolders = contents.filter(item => 
                item.type === 'dir' && 
                /^\d{4}-/.test(item.name)
            );

            console.log(`Found ${problemFolders.length} problem folders`);

            const problems = [];
            
            for (const folder of problemFolders) {
                const problemInfo = this.parseProblemFolder(folder.name);
                if (problemInfo) {
                    problems.push(problemInfo);
                }
            }

            // Sort problems by number
            problems.sort((a, b) => a.number - b.number);

            // Process topics
            problems.forEach(problem => {
                problem.topics.forEach(topic => {
                    if (!this.topics.has(topic)) {
                        this.topics.set(topic, 0);
                    }
                    this.topics.set(topic, this.topics.get(topic) + 1);
                });
            });

            this.filteredProblems = [...problems];
            return problems;

        } catch (error) {
            console.error('Error fetching from GitHub API:', error);
            console.log('Falling back to sample data...');
            // Fallback to sample data for testing
            const sampleProblems = this.getSampleProblems();
            console.log('Sample problems loaded:', sampleProblems.length);
            return sampleProblems;
        }
    }

    getSampleProblems() {
        // Sample problems for testing when GitHub API fails
        const sampleProblems = [
            {
                number: 1,
                title: "Two Sum",
                difficulty: "Easy",
                topics: ["Array", "Hash Table"],
                githubUrl: "https://github.com/namann2/Leetcode/tree/master/0001-two-sum",
                slug: "0001-two-sum"
            },
            {
                number: 2,
                title: "Add Two Numbers",
                difficulty: "Medium",
                topics: ["Linked List", "Math", "Recursion"],
                githubUrl: "https://github.com/namann2/Leetcode/tree/master/0002-add-two-numbers",
                slug: "0002-add-two-numbers"
            },
            {
                number: 3,
                title: "Longest Substring Without Repeating Characters",
                difficulty: "Medium",
                topics: ["Hash Table", "String", "Sliding Window"],
                githubUrl: "https://github.com/namann2/Leetcode/tree/master/0003-longest-substring-without-repeating-characters",
                slug: "0003-longest-substring-without-repeating-characters"
            },
            {
                number: 4,
                title: "Median of Two Sorted Arrays",
                difficulty: "Hard",
                topics: ["Array", "Binary Search", "Divide and Conquer"],
                githubUrl: "https://github.com/namann2/Leetcode/tree/master/0004-median-of-two-sorted-arrays",
                slug: "0004-median-of-two-sorted-arrays"
            },
            {
                number: 5,
                title: "Longest Palindromic Substring",
                difficulty: "Medium",
                topics: ["String", "Dynamic Programming"],
                githubUrl: "https://github.com/namann2/Leetcode/tree/master/0005-longest-palindromic-substring",
                slug: "0005-longest-palindromic-substring"
            }
        ];

        // Process topics for sample data
        sampleProblems.forEach(problem => {
            problem.topics.forEach(topic => {
                if (!this.topics.has(topic)) {
                    this.topics.set(topic, 0);
                }
                this.topics.set(topic, this.topics.get(topic) + 1);
            });
        });

        this.filteredProblems = [...sampleProblems];
        return sampleProblems;
    }

    parseProblemFolder(folderName) {
        const match = folderName.match(/^(\d{4})-(.+)$/);
        if (!match) return null;

        const [, numberStr, slug] = match;
        const number = parseInt(numberStr);
        
        // Convert slug to title
        const title = slug.split('-')
            .map(word => word.charAt(0).toUpperCase() + word.slice(1))
            .join(' ');

        // Determine difficulty based on problem number
        const difficulty = this.getDifficulty(number);
        
        // Extract topics from slug and title
        const topics = this.extractTopics(slug, title);

        return {
            number,
            title,
            difficulty,
            topics,
            githubUrl: `https://github.com/namann2/Leetcode/tree/master/${folderName}`,
            slug: folderName
        };
    }

    getDifficulty(number) {
        // Common difficulty patterns based on problem numbers
        const easyProblems = [1, 7, 9, 13, 14, 20, 21, 26, 27, 28, 35, 38, 53, 58, 66, 67, 69, 70, 83, 88, 94, 100, 101, 104, 107, 108, 110, 111, 112, 118, 119, 121, 122, 125, 136, 141, 155, 160, 167, 168, 169, 171, 172, 175, 176, 183, 189, 190, 191, 193, 195, 196, 197, 202, 203, 204, 205, 206, 217, 219, 225, 226, 231, 232, 234, 235, 237, 242, 243, 246, 252, 257, 258, 263, 266, 268, 270, 276, 278, 283, 290, 292, 293, 299, 303, 326, 342, 344, 345, 349, 350, 359, 367, 371, 374, 383, 387, 389, 392, 401, 404, 405, 408, 409, 412, 414, 415, 422, 427, 434, 437, 438, 441, 443, 447, 448, 453, 455, 459, 461, 463, 475, 476, 482, 485, 492, 496, 500, 501, 504, 506, 507, 509, 520, 521, 530, 532, 541, 543, 551, 557, 559, 561, 563, 566, 572, 575, 581, 589, 590, 594, 598, 599, 604, 605, 606, 617, 628, 633, 637, 643, 645, 653, 657, 661, 665, 669, 671, 674, 680, 682, 686, 687, 690, 693, 696, 697, 700, 703, 704, 705, 706, 709, 716, 717, 720, 724, 728, 733, 734, 744, 746, 747, 748, 758, 760, 762, 766, 771, 783, 784, 788, 796, 800, 804, 806, 812, 819, 821, 824, 830, 832, 836, 840, 844, 849, 852, 859, 860, 867, 868, 872, 874, 876, 883, 884, 888, 892, 893, 896, 897, 905, 908, 914, 917, 922, 925, 929, 933, 937, 938, 941, 942, 944, 949, 953, 961, 965, 970, 976, 977, 985, 989, 993, 997, 999];
        
        const hardProblems = [4, 10, 23, 25, 30, 32, 37, 41, 42, 44, 45, 51, 52, 57, 60, 65, 68, 72, 76, 84, 85, 87, 99, 115, 123, 124, 126, 127, 128, 132, 135, 140, 145, 146, 149, 154, 158, 159, 164, 174, 188, 212, 214, 218, 224, 233, 239, 248, 269, 272, 273, 282, 295, 297, 301, 302, 305, 308, 312, 315, 316, 317, 321, 322, 327, 329, 330, 335, 336, 340, 352, 354, 355, 356, 357, 358, 363, 381, 391, 403, 407, 410, 411, 420, 425, 428, 431, 432, 440, 446, 458, 460, 466, 472, 479, 480, 483, 488, 489, 493, 502, 514, 517, 527, 546, 552, 564, 568, 587, 591, 600, 629, 630, 632, 639, 642, 644, 656, 660, 664, 668, 675, 679, 683, 685, 689, 691, 699, 711, 715, 718, 719, 721, 726, 730, 732, 736, 741, 745, 749, 751, 753, 757, 761, 765, 768, 770, 772, 773, 774, 778, 780, 782, 786, 787, 793, 798, 803, 805, 808, 810, 815, 818, 827, 829, 834, 839, 843, 847, 850, 854, 857, 862, 864, 865, 871, 878, 879, 882, 887, 895, 898, 899, 902, 903, 906, 913, 920, 924, 927, 928, 930, 932, 936, 940, 943, 948, 951, 952, 956, 958, 959, 960, 964, 968, 972, 975, 978, 980, 982, 987, 992, 995, 996];

        if (easyProblems.includes(number)) {
            return 'Easy';
        } else if (hardProblems.includes(number)) {
            return 'Hard';
        } else {
            return 'Medium'; // Default to medium if not found
        }
    }

    extractTopics(slug, title) {
        const topics = new Set();
        const text = (slug + ' ' + title).toLowerCase();

        // Topic mapping based on common patterns
        const topicMapping = {
            'array': ['Array'],
            'string': ['String'],
            'tree': ['Tree'],
            'binary-tree': ['Binary Tree', 'Tree'],
            'graph': ['Graph'],
            'dynamic-programming': ['Dynamic Programming'],
            'dp': ['Dynamic Programming'],
            'backtrack': ['Backtracking'],
            'greedy': ['Greedy'],
            'sort': ['Sorting'],
            'search': ['Binary Search'],
            'binary-search': ['Binary Search'],
            'stack': ['Stack'],
            'queue': ['Queue'],
            'heap': ['Heap (Priority Queue)'],
            'priority-queue': ['Heap (Priority Queue)'],
            'hash': ['Hash Table'],
            'hashtable': ['Hash Table'],
            'linked-list': ['Linked List'],
            'two-pointer': ['Two Pointers'],
            'sliding-window': ['Sliding Window'],
            'dfs': ['Depth-First Search'],
            'bfs': ['Breadth-First Search'],
            'union-find': ['Union Find'],
            'trie': ['Trie'],
            'bit': ['Bit Manipulation'],
            'math': ['Math'],
            'geometry': ['Geometry'],
            'design': ['Design'],
            'simulation': ['Simulation'],
            'matrix': ['Matrix'],
            'topological': ['Topological Sort'],
            'shortest-path': ['Shortest Path'],
            'memoization': ['Memoization'],
            'recursion': ['Recursion'],
            'divide-and-conquer': ['Divide and Conquer']
        };

        // Check for topic keywords
        for (const [keyword, topicList] of Object.entries(topicMapping)) {
            if (text.includes(keyword)) {
                topicList.forEach(topic => topics.add(topic));
            }
        }

        // Add specific topic mappings based on common patterns
        if (text.includes('binary') && text.includes('tree')) {
            topics.add('Binary Tree');
            topics.add('Tree');
        }
        
        if (text.includes('linked') && text.includes('list')) {
            topics.add('Linked List');
        }
        
        if (text.includes('palindrome')) {
            topics.add('String');
            topics.add('Two Pointers');
        }
        
        if (text.includes('parentheses')) {
            topics.add('String');
            topics.add('Stack');
        }
        
        if (text.includes('stock')) {
            topics.add('Array');
            topics.add('Dynamic Programming');
        }
        
        if (text.includes('island')) {
            topics.add('Array');
            topics.add('Depth-First Search');
            topics.add('Breadth-First Search');
            topics.add('Matrix');
        }

        if (text.includes('course') && text.includes('schedule')) {
            topics.add('Graph');
            topics.add('Topological Sort');
            topics.add('Depth-First Search');
            topics.add('Breadth-First Search');
        }

        // Default topics if none found
        if (topics.size === 0) {
            topics.add('Array'); // Most common default
        }

        return Array.from(topics);
    }

    setupEventListeners() {
        // Search functionality
        const searchInput = document.getElementById('searchInput');
        searchInput.addEventListener('input', (e) => {
            this.searchQuery = e.target.value.toLowerCase();
            this.filterProblems();
        });

        // Topic filter
        const topicFilter = document.getElementById('topicFilter');
        topicFilter.addEventListener('change', (e) => {
            this.currentTopic = e.target.value;
            this.filterProblems();
            this.updateActiveTopicInSidebar();
        });

        // Difficulty filter
        const difficultyFilter = document.getElementById('difficultyFilter');
        difficultyFilter.addEventListener('change', (e) => {
            this.currentDifficulty = e.target.value;
            this.filterProblems();
        });
    }

    renderTopics() {
        const topicsList = document.getElementById('topicsList');
        const topicFilter = document.getElementById('topicFilter');
        
        // Sort topics by count (descending)
        const sortedTopics = Array.from(this.topics.entries())
            .sort((a, b) => b[1] - a[1]);

        // Render sidebar topics
        topicsList.innerHTML = sortedTopics.map(([topic, count]) => `
            <div class="topic-item" data-topic="${topic}">
                <span>${topic}</span>
                <span class="topic-count">${count}</span>
            </div>
        `).join('');

        // Render filter dropdown
        topicFilter.innerHTML = `
            <option value="">All Topics</option>
            ${sortedTopics.map(([topic]) => `
                <option value="${topic}">${topic}</option>
            `).join('')}
        `;

        // Add click listeners to sidebar topics
        topicsList.addEventListener('click', (e) => {
            const topicItem = e.target.closest('.topic-item');
            if (topicItem) {
                const topic = topicItem.dataset.topic;
                this.currentTopic = this.currentTopic === topic ? '' : topic;
                document.getElementById('topicFilter').value = this.currentTopic;
                this.filterProblems();
                this.updateActiveTopicInSidebar();
            }
        });
    }

    updateActiveTopicInSidebar() {
        const topicItems = document.querySelectorAll('.topic-item');
        topicItems.forEach(item => {
            if (item.dataset.topic === this.currentTopic) {
                item.classList.add('active');
            } else {
                item.classList.remove('active');
            }
        });
    }

    filterProblems() {
        this.filteredProblems = this.problems.filter(problem => {
            const matchesSearch = !this.searchQuery || 
                problem.title.toLowerCase().includes(this.searchQuery) ||
                problem.number.toString().includes(this.searchQuery);
            
            const matchesTopic = !this.currentTopic || 
                problem.topics.includes(this.currentTopic);
            
            const matchesDifficulty = !this.currentDifficulty || 
                problem.difficulty === this.currentDifficulty;

            return matchesSearch && matchesTopic && matchesDifficulty;
        });

        this.renderProblems();
        this.updateProblemCount();
    }

    renderProblems() {
        const problemsList = document.getElementById('problemsList');
        
        if (this.filteredProblems.length === 0) {
            problemsList.innerHTML = `
                <div class="empty-state">
                    <h3>No problems found</h3>
                    <p>Try adjusting your search or filter criteria.</p>
                </div>
            `;
            return;
        }

        problemsList.innerHTML = this.filteredProblems.map((problem, index) => `
            <div class="problem-card" data-index="${index}">
                <div class="problem-header">
                    <span class="problem-title">
                        ${problem.title}
                    </span>
                    <div class="problem-number">#${problem.number}</div>
                </div>
                <div class="difficulty-badge difficulty-${problem.difficulty.toLowerCase()}">
                    ${problem.difficulty}
                </div>
                <div class="problem-topics">
                    ${problem.topics.map(topic => `
                        <span class="topic-tag">${topic}</span>
                    `).join('')}
                </div>
                <div class="problem-meta">
                    <span>Java Solution</span>
                    <a href="${problem.githubUrl}" target="_blank" class="github-link" onclick="event.stopPropagation()">
                        View on GitHub →
                    </a>
                </div>
            </div>
        `).join('');

        // Add click listeners to problem cards
        document.querySelectorAll('.problem-card').forEach((card, index) => {
            card.addEventListener('click', (e) => {
                if (e.target.classList.contains('github-link')) return;
                const problem = this.filteredProblems[index];
                this.openProblem(problem);
            });
        });
    }

    openProblem(problem) {
        // Store problem data in localStorage for the problem page
        localStorage.setItem('currentProblem', JSON.stringify(problem));
        // Navigate to problem page
        window.location.href = `problem.html?slug=${problem.slug}`;
    }

    updateStats() {
        document.getElementById('totalProblems').textContent = this.problems.length;
        document.getElementById('totalTopics').textContent = this.topics.size;
    }

    updateProblemCount() {
        const count = this.filteredProblems.length;
        const problemCount = document.getElementById('problemCount');
        problemCount.textContent = `${count} problem${count !== 1 ? 's' : ''}`;
    }

    showError() {
        const problemsList = document.getElementById('problemsList');
        problemsList.innerHTML = `
            <div class="empty-state">
                <h3>Error loading problems</h3>
                <p>Please try refreshing the page.</p>
            </div>
        `;
    }
}

// Initialize the application when DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    new LeetCodeSolutions();
});

// GitHub API integration (for future use)
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

    extractProblemInfo(folderName) {
        // Extract problem number and title from folder name
        const match = folderName.match(/^(\d+)-(.+)$/);
        if (!match) return null;

        const [, number, slug] = match;
        const title = slug.split('-')
            .map(word => word.charAt(0).toUpperCase() + word.slice(1))
            .join(' ');

        return {
            number: parseInt(number),
            title,
            slug: folderName
        };
    }
}

// Utility functions
const utils = {
    debounce(func, wait) {
        let timeout;
        return function executedFunction(...args) {
            const later = () => {
                clearTimeout(timeout);
                func(...args);
            };
            clearTimeout(timeout);
            timeout = setTimeout(later, wait);
        };
    },

    formatNumber(num) {
        return num.toLocaleString();
    },

    getDifficultyColor(difficulty) {
        const colors = {
            'Easy': '#10b981',
            'Medium': '#f59e0b',
            'Hard': '#ef4444'
        };
        return colors[difficulty] || '#64748b';
    }
};
