class AVLTree {
    int data;
    AVLTree left;
    AVLTree right;
    AVLTree previous;

    AVLTree(int data) {
        this.data = data;
        left = null;
        right = null;
        previous = null;
    }
}

class AVL {
    public static void main(String[] args) {

        AVLTree root = null;
        for(int nodeData : tree.nodes) {
            System.out.println("Insertion : " + nodeData);
            root = insertNode(root, nodeData);
            //LOT(root);
            root = checkWeight(root);
            System.out.println("Root data : " + root.data);
        }
        System.out.println("\nLevel order : ");
        LOT(root);
        // inorder(root);
    }

    public static void inorder(AVLTree root) {
        if(root.left != null) {
            inorder(root.left);
        }
        System.out.print(root.data + " ");
        if(root.right != null) {
            inorder(root.right);
        }
    }

    public static AVLTree insertNode(AVLTree root,int data) {
        AVLTree newNode = null;
        if(root == null) { //Predecessor of first root is itself
            newNode = new AVLTree(data);
            return newNode;
        }
        if(data < root.data) {
            if(root.left != null) {
                insertNode(root.left,data);
            }
            else {
                newNode = new AVLTree(data);
                root.left = newNode;
                newNode.previous = root;
            }
        }
        else if(data > root.data) {
            if(root.right != null) {
                insertNode(root.right,data);
            }
            else {
                newNode = new AVLTree(data);
                root.right = newNode;
                newNode.previous = root;
            }
        }
        return root;
    }

    public static AVLTree checkWeight(AVLTree root) {
        if(root == null) {
            return root;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int weight = lh - rh;
            if(weight > 1 && lh == 2) {
                if(root.left.left != null) {
                    System.out.println("RR");
                    root = RR(root);
                }
                else {
                    System.out.println("LR");
                    root = LR(root);
                }
            }
            else if(weight < -1 && rh == 2) {
                if(root.right.right != null) {
                    System.out.println("LL");
                    root = LL(root);
                }
                else {
                    System.out.println("RL");
                    root = RL(root);
                }
            }
            else {
                if(weight >= 0) {
                    root = checkWeight(root.left);
                }
                else {
                    root = checkWeight(root.right);
                }
            }
        return root;
    }

    public static int height(AVLTree root) {
        if(root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        if(left >= right) {
            return (left + 1);
        }
        else {
            return (right + 1);
        }
    }

    public static AVLTree RR(AVLTree root) {
        AVLTree subRoot = root.left;
        subRoot.right = root;
        subRoot.previous = root.previous;
        root.left = null;
        //root.right = null;
        root.previous = subRoot;
        return subRoot;
    }

    public static AVLTree LR(AVLTree root) {
        AVLTree subRoot = root.left;
        AVLTree leaf = root.left.right;
        leaf.left = subRoot;
        leaf.right = root;
        leaf.previous = root.previous;
        //subRoot.left = null;
        subRoot.right = null;
        subRoot.previous = leaf;
        root.left = null;
        //root.right = null;
        root.previous = leaf;
        return leaf;
    }

    public static AVLTree LL(AVLTree root) {
        AVLTree subRoot = root.right;
        subRoot.left = root;
        subRoot.previous = root.previous;
        //root.left = null;
        root.right = null;
        root.previous = subRoot;
        return subRoot;
    }

    public static AVLTree RL(AVLTree root) {
        AVLTree subRoot = root.right;
        AVLTree leaf = root.right.left;
        leaf.right = subRoot;
        leaf.left = root;
        leaf.previous = root.previous;
        subRoot.left = null;
        //subRoot.right = null;
        subRoot.previous = leaf;
        //root.left = null;
        root.right = null;
        root.previous = leaf;
        return leaf;
    }

    public static void LOT(AVLTree root) {
        
        if(root == null) {
            System.out.println("No nodes in tree!");
        }

        for(int i = 1; i <= height(root); i++) {
            level(root,i);
        }
        System.out.println();
    }

    public static void level(AVLTree root,int level) {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.print(root.data + " ");
        }
        else {
            level(root.left,level - 1);
            level(root.right,level - 1);
        }
    }
}