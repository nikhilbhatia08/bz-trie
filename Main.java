```java
import java.util.*;

class TrieNode {
    TrieNode[] c = new TrieNode[26];
    boolean e;
    boolean k(char ch) { return c[ch - 'a'] != null; }
    TrieNode g(char ch) { return c[ch - 'a']; }
    void p(char ch, TrieNode n) { c[ch - 'a'] = n; }
    void z() { e = true; }
}

class Trie {
    TrieNode r = new TrieNode();
    void i(String w) {
        TrieNode n = r;
        for (char ch : w.toCharArray()) {
            if (!n.k(ch)) n.p(ch, new TrieNode());
            n = n.g(ch);
        }
        n.z();
    }
    boolean s(String w) {
        TrieNode n = r;
        for (char ch : w.toCharArray()) {
            if (!n.k(ch)) return false;
            n = n.g(ch);
        }
        return n.e;
    }
    List<String> a() {
        List<String> l = new ArrayList<>();
        d(r, "", l);
        return l;
    }
    List<String> pfx(String pr) {
        List<String> l = new ArrayList<>();
        TrieNode n = r;
        for (char ch : pr.toCharArray()) {
            if (!n.k(ch)) return l;
            n = n.g(ch);
        }
        d(n, pr, l);
        return l;
    }
    void d(TrieNode n, String s, List<String> l) {
        if (n.e) l.add(s);
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (n.k(ch)) d(n.g(ch), s + ch, l);
        }
    }
}

public class Main {
    public static void main(String[] A) {
        Scanner s = new Scanner(System.in);
        Trie t = new Trie();
        while (true) {
            System.out.println("0-Exit");
            System.out.println("1-Add");
            System.out.println("2-Search");
            System.out.println("3-All");
            System.out.println("4-Prefix");
            int c = s.nextInt();
            s.nextLine();
            if (c == 0) break;
            switch (c) {
                case 1:
                    String w = s.nextLine().toLowerCase();
                    t.i(w);
                    break;
                case 2:
                    String w2 = s.nextLine().toLowerCase();
                    System.out.println(t.s(w2));
                    break;
                case 3:
                    for (String x : t.a()) System.out.println(x);
                    break;
                case 4:
                    String pr = s.nextLine().toLowerCase();
                    for (String x : t.pfx(pr)) System.out.println(x);
                    break;
            }
        }
    }
}
```