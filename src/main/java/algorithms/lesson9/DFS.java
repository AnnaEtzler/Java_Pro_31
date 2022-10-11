package algorithms.lesson9;

public class DFS { //  поиск в глубину
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.setLeft(left);
        root.setRight(right);
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(5);
        left.setLeft(l1);
        left.setRight(r1);
        TreeNode l2 = new TreeNode(6);
        TreeNode r2 = new TreeNode(7);
        right.setLeft(l2);
        right.setRight(r2);

        TreeApp ta = new TreeApp();
        ta.traverseTreeReverse(root);

        int target = 8;

        DFS dfs = new DFS();
        boolean exisis = dfs.parthExists(root,target);
        System.out.println("Path exists : " + exisis);


    }

    private boolean parthExists(TreeNode node, int sum){
        if(node == null){
            return false;
        }

        if(node.getRight() == null && node.getLeft() == null){
            return sum == node.getValue();
        }

        sum -= node.getValue();


        return parthExists(node.getLeft(), sum) || parthExists(node.getRight(), sum);

    }
}
