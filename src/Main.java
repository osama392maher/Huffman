import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        String text = "aaaaaaaabbbbbbbccccdd";
        Huffman huffman = new Huffman(text);
        String encodedText = huffman.encode();
        System.out.println("Encoded text: " + encodedText);
        huffman.printCodes();
        System.out.println("Decoded text: " + huffman.decode(encodedText));

    }
}