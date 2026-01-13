package main5;

public class BTree {
    public static void main(String[] args) {
        Node node1 = new Node(null, null, 5);
        Node node2 = new Node(null, null, 10);
        Node root = new Node(node1, node2, 1);
        System.out.println("value = " + root.getAmount());
    }
}
