package org.example.AlphabetFrequencyReader;

import java.util.Map;

/**
 * This class represents the main entry point of the Alphabet Frequency Reader application.
 * It coordinates reading input files, analyzing character frequencies, and generating a bar chart.
 */
public class App {

    public static void main(String[] args){
        String filePath = "src/main/resources/MobyDick.pdf";
        DocumentReader reader = new DocumentReader();
        CharacterFrequencyAnalyzer analyzer = new CharacterFrequencyAnalyzer();
        ChartGenerator chartGenerator = new ChartGenerator();

        // read text from file
        String text = reader.read(filePath);

        // analyze character frequencies
        Map<Character, Integer> frequencies = analyzer.analyzeFrequency(text);

        // Generate and display the bar chart
        chartGenerator.generateChart(frequencies, "Character Frequencies");

    }

}
