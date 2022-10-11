package algorithms.lesson9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeApp {
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


    }

    public void traverseTree(TreeNode root){
        if(root == null){
            return;
        }
        // создали очередь
        Queue<TreeNode> queue = new LinkedList<>();
        // добавить в очередь
        queue.offer(root);
        //
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode treeNode = queue.poll();
                System.out.print(treeNode.getValue() + " ");
                if(treeNode.getLeft() != null){
                    queue.offer(treeNode.getLeft());
                }
                if(treeNode.getRight() != null){
                    queue.offer(treeNode.getRight());
                }
            }  System.out.println();
        }


    }

    public void traverseTreeReverse(TreeNode root){
        if(root == null){
            return;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                levelList.add(treeNode.getValue());
                if (treeNode.getLeft() != null) {
                    queue.offer(treeNode.getLeft());
                }
                if (treeNode.getRight() != null) {
                    queue.offer(treeNode.getRight());
                }
            }
            result.add(0, levelList);
        }
            for(List<Integer> list: result){
                for (Integer integer: list){
                    System.out.print(integer + " ");

                }
                System.out.println();
            }
        }

}
