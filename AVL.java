class AVL {
    public static void main(String[] args) {

        Tree root = null;
        for(int node : tree.nodes) {
            System.out.println(node);
            root = tree.insertNode(root,node);
        }

        tree.levelOrderTraversal(root);
    }
}