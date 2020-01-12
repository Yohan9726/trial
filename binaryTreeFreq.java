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

class f_and_d { //A class whose objects can store frequency and data in one place
    int frequency;
    int data;

    public f_and_d(int f,int d) {
        this.frequency = f;
        this.data = d;
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

        f_and_d currrentVals = new f_and_d(0, root.data);
        f_and_d maxVals = new f_and_d(1, root.data);
        
        System.out.print("The MODE of the binary tree is : " + freq(root,currrentVals,maxVals).data);
        System.out.println();
        
        sc.close();
    }

    public static Tree insertNode(int data,Tree root) {
        Tree newNode = new Tree(data);
        
        if(data < root.data) {
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
        else {
            if(root.left == null) {
                root.left = newNode;
            }
            else {
                Tree leftRoot = root.left;
                root.left = newNode;
                newNode.left = leftRoot;
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

    public static f_and_d freq(Tree root,f_and_d currentVals,f_and_d maxVals) {
        if(currentVals.data != root.data) {
            currentVals.data = root.data; currentVals.frequency = 1;
        }
        else {
            currentVals.frequency++;
            if(currentVals.frequency > maxVals.frequency) {
                maxVals.frequency = currentVals.frequency;
                maxVals.data = currentVals.data;
            }
        }
        
        if(root.left != null) {
            maxVals = freq(root.left,currentVals,maxVals);
        }

        //System.out.println(root.data + " " + maxVals.frequency + " currentVals.frequency : " + currentVals.frequency);
        
        if(root.right != null) {
            maxVals = freq(root.right,currentVals,maxVals);
        }
        
        return maxVals;
    }
}