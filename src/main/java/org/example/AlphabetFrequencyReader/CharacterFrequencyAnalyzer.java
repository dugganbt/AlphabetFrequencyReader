package org.example.AlphabetFrequencyReader;

import java.util.HashMap;
import java.util.Map;

/**
 * A utility class for analyzing character frequencies in a given string.
 * Counts the occurrences of each alphabetic character, ignoring case.
 */
public class CharacterFrequencyAnalyzer {

    /**
     * Analyzes the frequency of each alphabetic character in the given text.
     *
     * @param text the text to analyze
     * @return a map where keys are characters (a-z) and values are their frequencies
     */
    public Map<Character, Integer> analyzeFrequency(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();
        text = text.toLowerCase(); // Normalize to lowercase
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
            }
        }
        return frequencies;
    }


}
