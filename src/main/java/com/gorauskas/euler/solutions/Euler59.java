package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Euler59 implements Euler {

    private final String SAMPLE = " the ";

    @Override
    public double Solve() {
        int sum = 0;

        try {
            var uri = getClass().getResource("/p059_cipher.txt").toURI();
            var data = Util.getDataFromFile(uri).strip();

            List<Integer> ciphertext = Stream.of(data.split(","))
                    .mapToInt(Integer::valueOf)
                    .boxed()
                    .collect(Collectors.toList());

            for (var key : getKeys()) {
                List<Integer> k = key.chars().boxed().collect(Collectors.toList());

                String plaintext = decrypt(ciphertext, k);

                if (plaintext.contains(SAMPLE)) {
                    sum = plaintext.chars().sum();
                    break;
                }
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return sum;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 59\n")
                .append("\n")
                .append("    Each character on a computer is assigned a unique code and the preferred\n")
                .append("    standard is ASCII (American Standard Code for Information Interchange). For\n")
                .append("    example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.\n")
                .append("\n")
                .append("    A modern encryption method is to take a text file, convert the bytes to\n")
                .append("    ASCII, then XOR each byte with a given value, taken from a secret key. The\n")
                .append("    advantage with the XOR function is that using the same encryption key on\n")
                .append("    the cipher text, restores the plain text; for example, 65 XOR 42 = 107,\n")
                .append("    then 107 XOR 42 = 65.\n")
                .append("\n")
                .append("    For unbreakable encryption, the key is the same length as the plain text\n")
                .append("    message, and the key is made up of random bytes. The user would keep the\n")
                .append("    encrypted message and the encryption key in different locations, and\n")
                .append("    without both \"halves\", it is impossible to decrypt the message.\n")
                .append("\n")
                .append("    Unfortunately, this method is impractical for most users, so the modified\n")
                .append("    method is to use a password as a key. If the password is shorter than the\n")
                .append("    message, which is likely, the key is repeated cyclically throughout the\n")
                .append("    message.The balance for this method is using a sufficiently long password\n")
                .append("    key for security, but short enough to be memorable.\n")
                .append("\n")
                .append("    Your task has been made easy, as the encryption key consists of three lower\n")
                .append("    case characters. Using cipher.txt (right click and 'Save Link/Target\n")
                .append("    As...'), a file containing the encrypted ASCII codes, and the knowledge\n")
                .append("    that the plain text must contain common English words, decrypt the message\n")
                .append("    and find the sum of the ASCII values in the original text.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of the ASCII values in the original text is %s", (long)this.Solve());
    }

    private List<String> getKeys() {
        var l = new ArrayList<String>();

        for (char x = 'a'; x < 'z'; x++) {
            for (char y = 'a'; y < 'z'; y++) {
                for (char z = 'a'; z < 'z'; z++) {
                    l.add(String.valueOf(x) + y + z);
                }
            }
        }

        return l;
    }

    private String decrypt(List<Integer> ciphertext, List<Integer> key) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ciphertext.size(); i += 3) {
            sb.append((char)(ciphertext.get(i) ^ key.get(0)));
            sb.append((char)(ciphertext.get(i + 1) ^ key.get(1)));
            sb.append((char)(ciphertext.get(i + 2) ^ key.get(2)));
        }

        return sb.toString();
    }
}
