import java.util.*;

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
        Tree root = new Tree(30);
        
        System.out.println("The root is 30\nEnter 5 values");
        
        for(int i = 0; i < 5; i++) {
            insertNode(sc.nextInt(),root);
        }

        System.out.println("The values are : ");
        inorder(root);
        
        System.out.println();
        
        System.out.print("Maximum frequency : " + freq(root,0,root.data,1));
        System.out.println();
        
        sc.close();
    }

    public static Tree insertNode(int data,Tree root) {
        Tree newNode = new Tree(data);
        
        if(data <= root.data) {
            if(root.left == null) {
                root.left = newNode;
            }
            else {
                insertNode(data, root.left);
            }
        }

        else if(data > root.data) {
            if(root.right == null) {
                root.right = newNode;
            }
            else {
                insertNode(data, root.right);
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

    public static int freq(Tree root,int currentF,int currentVal,int maxF) {
        if(currentVal != root.data) {
            currentVal = root.data; currentF = 1;
        }
        else {
            currentF++;
            if(currentF > maxF) {
                maxF = currentF;
            }
        }
        
        if(root.left != null) {
            maxF = freq(root.left,currentF,currentVal,maxF);
        }

        //System.out.println(root.data + " " + maxF + "\t");
        
        if(root.right != null) {
            maxF = freq(root.right,currentF,currentVal,maxF);
        }
        
        return maxF;
    }
}