package ua.kosheleva.hw16;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Vocabulary {
    final private LinkedHashMap<String, Integer> vocabulary;

    public Vocabulary(String input) {
        vocabulary = new LinkedHashMap<>();
        fillVocabulary(input);
    }

    private void fillVocabulary(String input) {
        input = input.toLowerCase();
        input = input.replaceAll("\\p{Punct}", "");
        String[] splitString = input.split(" ");
        for (String word : splitString) {
            Integer count = vocabulary.get(word);
            if (count == null) {
                count = 0;
            }
            vocabulary.put(word, ++count);
        }
    }

    public void showVocabulary() {
        ArrayList<Map.Entry<String, Integer>> vocabularyEntries = new ArrayList<>(vocabulary.entrySet());
        vocabularyEntries.sort((o1, o2) -> {
            if (o1.getValue().compareTo(o2.getValue()) == 0) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entries : vocabularyEntries) {
            System.out.println(entries.getKey() + " " + entries.getValue());
        }
    }
}
