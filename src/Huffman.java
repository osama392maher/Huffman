import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class Huffman {
    Node root;
    String text;
    Map<Character, Integer> freq;
    Map<Character, String> huffmanCode;

    FileOutputStream out;

    public Huffman(String t) {
        text = t;
        fillFreq();
        huffmanCode = new HashMap<>();
    }

    public void fillFreq() {
        freq = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
    }

    String encode() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        freq.forEach((c, f) ->
                queue.add(new Leaf(c, f))
        );
        while (queue.size() > 1) {
            queue.add(new Node(queue.poll(), queue.poll()));
        }

        generateHuffmanCode(root = queue.poll(), "");
        return getencodedText();
    }

    void generateHuffmanCode(Node node, String code) {
        if (node instanceof Leaf) {
            huffmanCode.put(((Leaf) node).character, code);
            return;
        }
        generateHuffmanCode(((Node) node).left, code + '0');
        generateHuffmanCode(((Node) node).right, code + '1');
    }

    String getencodedText() {
        String encodedText = "";
        for (int i = 0; i < text.length(); i++) {
            encodedText += huffmanCode.get(text.charAt(i));
        }
        return encodedText;
    }

    String decode(String encodedText) {
        String decodedText = "";
        Node current = root;
        for (char c : encodedText.toCharArray()) {
            current = c == '0' ? ((Node) current).left : ((Node) current).right;

            if (current instanceof Leaf) {
                decodedText += ((Leaf) current).character;
                current = root;
            }
        }

        return decodedText;
    }

    void printCodes() {
        huffmanCode.forEach((c, f) ->
                System.out.println(c + " " + f)
        );
    }
}



