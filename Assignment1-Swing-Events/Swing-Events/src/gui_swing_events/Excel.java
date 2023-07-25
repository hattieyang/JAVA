package gui_swing_events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel {
    private ArrayList<Double> numbers;

    public Excel(ArrayList<Double> numbers) {
        this.numbers = numbers;
    }

    public Excel(String input) {
        String[] strNumArray = input.split(",");
        List<String> strNumList = Arrays.asList(strNumArray);
        ArrayList<Double> strNumArrayList = new ArrayList<>();
        strNumList.forEach(str -> strNumArrayList.add(Double.parseDouble(str.trim())));

        this.numbers = strNumArrayList;
    }

    public double findTotal() {
        double total = 0;
        for (double number : numbers) {
            total += number;
        }
        return total;
    }

    public double findAvg() {
        double total = findTotal();
        return total / numbers.size();
    }

    public double findMax() {
        double maximum = Double.MIN_VALUE;
        for (double number : numbers) {
            if (number > maximum) {
                maximum = number;
            }
        }
        return maximum;
    }

    public double findMin() {
        double minimum = Double.MAX_VALUE;
        for (double number : numbers) {
            if (number < minimum) {
                minimum = number;
            }
        }
        return minimum;
    }
}
