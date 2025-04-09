enum NODE_STATE {
    MONITORED, NOT_MONITORED, HAS_CAMERA;
}

class NodePair {
    int camera;
    NODE_STATE state;

    public NodePair() {
        this.camera = 0;
        this.state = NODE_STATE.MONITORED;
    }

    public NodePair(int camera, NODE_STATE state) {
        this.camera = camera;
        this.state = state;
    }
}

class Solution {
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        NodePair rootPair = minCamera(root);
        return rootPair.state == NODE_STATE.NOT_MONITORED ? rootPair.camera + 1 : rootPair.camera;
    }

    private NodePair minCamera(TreeNode root) {
        if(root == null) return new NodePair();

        NodePair left = minCamera(root.left);
        NodePair right = minCamera(root.right);

        int subtreeCamera = left.camera + right.camera;

        NodePair currRoot = new NodePair(subtreeCamera, NODE_STATE.NOT_MONITORED);

        // option 1 : can place camera on current node ?
        if(left.state == NODE_STATE.NOT_MONITORED || right.state == NODE_STATE.NOT_MONITORED) {
            currRoot.state = NODE_STATE.HAS_CAMERA;
            currRoot.camera ++;
        } 
        // option 2 : can not place a camera on current node
        else if(left.state == NODE_STATE.HAS_CAMERA || right.state == NODE_STATE.HAS_CAMERA) {
            currRoot.state = NODE_STATE.MONITORED;
        }
        return currRoot;
    }
}