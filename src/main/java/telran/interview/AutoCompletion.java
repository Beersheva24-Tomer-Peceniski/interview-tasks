package telran.interview;

import java.util.TreeSet;

public class AutoCompletion {
    private TreeSet<String> tree = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public boolean addWord(String word) {
        return tree.add(word);
    }

    public String[] getVariants(String prefix) {
        return tree.tailSet(prefix, true)
        .stream()
        .filter(s -> s.toLowerCase().startsWith(prefix.toLowerCase()))
        .toArray(String[]::new);
    }
}