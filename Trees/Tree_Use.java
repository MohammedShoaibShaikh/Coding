package Trees;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class Tree_Use {
    static Scanner sc = new Scanner(System.in);

    // ------------------------------------------------------- Practice Assignment ---------------------------------------------------------------------------- //
    // Question-1 Contain x
    public static boolean Q_1(TreeNode<Integer> root, Object x){
        if(root == null) return false;
        if(root.data == x){
            return true;
        }
        for(TreeNode<Integer> Ch : root.Child){
            if(Q_1(Ch, x)) return true;
        }
        return false;
    }
    // Question-2 Count Nodes
    public static int Q_2(TreeNode<Integer> root, int x){
        if(root == null) return 0;
        int temp = 0;
        for(int i = 0; i < root.Child.size() ; i++){
            temp += Q_2(root.Child.get(i), x);
        }
        if(root.data > x) return temp + 1;
        else return temp;
    }

    // ----------------------------------------------------- End of Practice Assignment --------------------------------------------------------------------- //
    public static int numLeaf(TreeNode<Integer> root){
        if(root == null) return 0;
        if(root.Child.size() == 0){
            return 1;
        }
        int ans = 0;
        for(int i = 0; i < root.Child.size(); i++){
            int temp = numLeaf(root.Child.get(i));
            ans += temp;
        }
        return ans;
    }

    public static void printAtLevelK(TreeNode<Integer> root, int k){
        if(root == null) return;
        if(k == 0){
            System.out.print(root.data + " ");
            return;
        }
        for(int i = 0; i < root.Child.size(); i++){
            printAtLevelK(root.Child.get(i), k-1);
        }
    }

    public static int height(TreeNode<Integer> root){
        if(root == null) return 0;
        int ans = 0;
        for(int i = 0; i < root.Child.size(); i++){
            int temp = height(root.Child.get(i));
            if(ans < temp) ans = temp;
        }
        return ans + 1;
    }

    public static int maxData(TreeNode<Integer> root){
        if(root == null) return 0;
        int ans = root.data;
        for(int i = 0; i < root.Child.size(); i++){
            int temp = maxData(root.Child.get(i));
            if(temp > ans) ans = temp;
        }
        return ans;
    }

    public static int sum_of_Nodes(TreeNode<Integer> root){
        if(root == null) return 0;
        int ans = root.data;
        for(int i = 0; i < root.Child.size(); i++){
            ans += sum_of_Nodes(root.Child.get(i));
        }
        return ans;
    }

    public static int numNodes(TreeNode<Integer> root){
        if(root == null) return 0;
        int ans = 1;
        for(int i = 0; i < root.Child.size(); i++){
            ans += numNodes(root.Child.elementAt(i));
        }
        return ans;
    }

    public static TreeNode<Integer> takeInputLevelWise(){
        System.out.print("Enter Root Data: ");
        int rootData = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        Queue<TreeNode> pendingNode = new LinkedList<TreeNode>();
        pendingNode.add(root);
        while(pendingNode.size() != 0){
            TreeNode<Integer> front = pendingNode.peek();
            pendingNode.poll();
            System.out.print("Enter Num of Children of " + front.data + ": ");
            int numChild = sc.nextInt();
            for(int i = 0; i < numChild; i++){
                System.out.print("Enter " + i + "th childData of " + front.data + ": ");
                int childData = sc.nextInt();
                TreeNode<Integer> ChildNode = new TreeNode<Integer>(childData);
                front.Child.addElement(ChildNode);
                pendingNode.add(ChildNode);
            }
        }
        return root;
    }

    public static TreeNode<Integer> takeInput(){
        System.out.print("Enter data: ");
        int rootData = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        System.out.print("Enter Number of Children of " + rootData + ":");
        int num = sc.nextInt();
        for(int i = 0; i < num; i++){
            TreeNode<Integer> ch = takeInput();
            root.Child.addElement(ch);
        }
        return root;
    }

    // Three Types of 
    public static void printTreeLevelWise(TreeNode<Integer> root){
        if(root == null) return;
        Queue<TreeNode> pendingNode = new LinkedList<TreeNode>();
        pendingNode.add(root);
        while(pendingNode.size() != 0){
            TreeNode<Integer> front = pendingNode.peek();
            pendingNode.poll();
            System.out.print(front.data + ": ");
            for(int i = 0; i < front.Child.size(); i++){
                System.out.print(front.Child.get(i).data + " ");
                pendingNode.add(front.Child.get(i));
            }
            System.out.println();
        }
    }

    public static void printTree(TreeNode<Integer> root){
        if(root == null) return;
        System.out.print(root.data + ":");
        for(int i = 0; i < root.Child.size(); i++){
            System.out.print(root.Child.get(i).data + " ");
        }
        System.out.println();
        for(int i = 0; i < root.Child.size(); i++){
            printTree(root.Child.get(i));
        }
    }

    public static void preOrder(TreeNode<Integer> root){
        if(root == null) return;
        System.out.print(root.data + " ");
        for(int i = 0; i < root.Child.size(); i++){
            preOrder(root.Child.get(i));
        }
    }

    public static void postOrder(TreeNode<Integer> root){
        if(root == null) return;
        for(int i = 0; i < root.Child.size(); i++){
            postOrder(root.Child.get(i));
        }
        System.out.print(root.data + " ");
    }

    // input Data for tree : 10 3 20 30 40 2 50 60 0 2 70 80 0 1 90 0 0 0
    public static void main(String[] args) {
//        TreeNode<Integer> root = new TreeNode<Integer>(1);
//        TreeNode<Integer> c1 = new TreeNode<Integer>(2);
//        TreeNode<Integer> c2 = new TreeNode<Integer>(3);
//        root.Child.add(c1);
//        root.Child.add(c2);
        // TreeNode<Integer> root = takeInput();
        // printTree(root);
        TreeNode<Integer> root = takeInputLevelWise();
        System.out.println();
        printTreeLevelWise(root);
        int numNode = numNodes(root);
        System.out.println("Number of Nodes in Tree: " + numNode);
        int sumofNodes = sum_of_Nodes(root);
        System.out.println("Sum of Nodes in Tree: " + sumofNodes);
        int maxData = maxData(root);
        System.out.println("MaxData Node in Tree: " + maxData);
        int height = height(root);
        System.out.println("Height of Tree: " + height);
        System.out.print("Nodes at Level/Depth K: ");
        printAtLevelK(root, 2);
        System.out.println();
        int numleaf = numLeaf(root);
        System.out.println("Number of Leaf in Tree: " + numleaf);
        System.out.print("PreOrder Traversal Tree: ");
        preOrder(root);
        System.out.println();
        System.out.print("PostOrder Traversal Tree: ");
        postOrder(root);
        System.out.println();

        // ------------------------------------ Question-1 ------------------------------------------------------- //
        System.out.println("Element X Present in Tree: " + Q_1(root, 50));
        // ------------------------------------ Question-2 ------------------------------------------------------- //
        System.out.println("Number of Nodes larger than x: " + Q_2(root, 80));
    }
}
