package Chapter20_21.Lab_Assignment_2;

import java.util.*;

public class FeatureExtractor {

    public Map<String, Double> extract(String message) {

        Map<String, Double> extractFeatures = new TreeMap<>();

        message = message.toLowerCase().replaceAll("[^a-z0-9\\s]", "");

        String[] words = message.split("\\s+");


        for (String word : words) {
            if (!word.isEmpty()) {
                extractFeatures.put(word, extractFeatures.getOrDefault(word, 0.0) + 1);
            }
        }
        return extractFeatures;
    }
}
