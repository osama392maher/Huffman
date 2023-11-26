public class Node implements Comparable<Node> {
    int frequency;
    Node left, right;

    public Node(Node left, Node right) {
        this.frequency = left.frequency + right.frequency;
        this.left = left;
        this.right = right;
    }

    public Node(int frequency) {
        this.frequency = frequency;
    }


    @Override
    public int compareTo(Node o) {
        return this.frequency - o.frequency;
    }
}