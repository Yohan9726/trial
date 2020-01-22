class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class tree {
    public static void main(String[] args) {

        Tree root = new Tree(50);

        int[] nodes = {41,42,45,40,35,59,62,57,51,100};
        for(int i = 0; i < nodes.length; i++) {
            insertNode(root,nodes[i]);
        }

        System.out.println("The nodes are : ");
        inorder(root);

        System.out.println("The height is : ");
        System.out.println(height(root));
    }

    public static void insertNode(Tree root,int data) {
        
        if(data < root.data) {
            if(root.left != null) {
                insertNode(root.left,data);
            }
            else {
                root.left = new Tree(data);
            }
        }

        else if(data > root.data) {
            if(root.right != null) {
                insertNode(root.right,data);
            }
            else {
                root.right = new Tree(data);
            }
        }
    }

    public static void inorder(Tree root) {
        if(root.left != null) {
            inorder(root.left);
        }

        System.out.println(root.data + " ");

        if(root.right != null) {
            inorder(root.right);
        }
    }

    public static int height(Tree root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        if(left >= right) {
            return(left + 1);
        }
        else {
            return(right + 1);
        }
    }
}