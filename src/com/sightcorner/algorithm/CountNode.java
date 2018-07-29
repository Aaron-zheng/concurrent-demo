package com.sightcorner.algorithm;

/**
 * Created by Aaron Zheng<br>
 * Created at 30/7/2018<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 30/7/2018
 */
public class CountNode {

    public static void main(String[] args) {

        Node testnode = new Node(new Node(null, new Node(null, new Node(null, null))), new Node(new Node(null, null), null));
        System.out.printf("count: " + countNode(testnode));
    }
    


    /**
     * 递归写法
     *
     * @param node
     * @return
     */
    public static int countNode(Node node) {
        if(null == node) {
            return 0;
        }

        if(null == node.getLeft() && null == node.getRight()) {
            return 1;
        }

        if(null == node.getLeft() && null != node.getRight()) {
            return 1 + countNode(node.getRight());
        }

        if(null != node.getLeft() && null == node.getRight()) {
            return 1 + countNode(node.getLeft());
        }

        if(null != node.getLeft() && null != node.getRight()) {
            int leftCount = countNode(node.getLeft());
            int rightCount = countNode(node.getRight());
            return 1 + (leftCount >= rightCount ? leftCount : rightCount);
        }

        return 0;
    }
}

class Node {

    private Node left;

    private Node right;

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
