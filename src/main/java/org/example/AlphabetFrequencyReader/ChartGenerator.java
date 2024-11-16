package org.example.AlphabetFrequencyReader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;

/**
 * A utility class for generating and displaying bar charts.
 * Uses the JFreeChart library to visualize character frequencies.
 */
public class ChartGenerator {
    /**
     * Generates and displays a bar chart from the given character frequency data.
     *
     * @param frequencies a map where keys are characters and values are their frequencies
     * @param chartTitle  the title of the chart
     */
    public void generateChart(Map<Character, Integer> frequencies, String chartTitle) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Populate the dataset with frequency data
        frequencies.forEach((character, frequency) -> {
            dataset.addValue(frequency, "Frequency", character.toString());
        });

        // Create the bar chart
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Character",
                "Frequency",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true, true, false);

        // Display the chart in a JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(barChart));
        frame.pack();
        frame.setVisible(true);
    }
}
