package main5;

class Node {
    public Node left;
    public Node right;
    public Integer value;

    public Node(Node left, Node right, Integer value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Integer getAmount() {
        // Базовый случай: узел не существует
        if (this.value == null) {
            return 0;
        }

        int sum = this.value;

        // Сумма левого поддерева
        if (this.left != null) {
            sum += this.left.getAmount();
        }

        // Сумма правого поддерева
        if (this.right != null) {
            sum += this.right.getAmount();
        }

        return sum;
    }
}
