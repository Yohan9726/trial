import java.util.Scanner;

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


class binaryTreeFreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree root = new Tree(3);
        
        System.out.println("Enter 5 values");
        
        for(int i = 0; i < 5; i++) {
            System.out.println("Enter a value : ");
            insertNode(sc.nextInt(),root);
        }

        System.out.println("The values are : ");
        inorder(root);
    }

    public static Tree insertNode(int data,Tree root) {
        Tree newNode = new Tree(data);
        
        if(data < root.data) {
            if(root.left == null) {
                root.left = newNode;
            }
            else {
                root.left = insertNode(data, root.left);
            }
        }

        else if(data > root.data) {
            if(root.right == null) {
                root.right = newNode;
            }
            else {
                root.right = insertNode(data, root.right);
            }
        }
        return root;
    }

    public static void inorder(Tree root) {
        if(root.left != null) {
            inorder(root.left);
        }

        System.out.print(root.data + " ");
        
        if(root.right != null) {
            inorder(root.right);
        }
    }
}