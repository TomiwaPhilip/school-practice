import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockAnalyzer {

    public static float calculateAveragePrice(float[] stockPrices) {
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
        }
        return sum / stockPrices.length;
    }

    public static float findMaximumPrice(float[] stockPrices) {
        float maxPrice = stockPrices[0]; // Initialize with the first element
        for (int i = 1; i < stockPrices.length; i++) {
            if (stockPrices[i] > maxPrice) {
                maxPrice = stockPrices[i];
            }
        }
        return maxPrice;
    }

    public static int countOccurrences(float[] stockPrices, float targetPrice) {
        int count = 0;
        for (float price : stockPrices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> stockPrices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    public static void main(String[] args) {
        float[] stockPricesArray = {150.50f, 152.75f, 151.20f, 153.80f, 154.10f, 153.50f, 155.00f, 154.25f, 156.00f, 155.75f};
        ArrayList<Float> stockPricesArrayList = new ArrayList<>(Arrays.asList(150.50f, 152.75f, 151.20f, 153.80f, 154.10f, 153.50f, 155.00f, 154.25f, 156.00f, 155.75f));


        float averagePrice = calculateAveragePrice(stockPricesArray);
        float maxPrice = findMaximumPrice(stockPricesArray);
        int occurrences = countOccurrences(stockPricesArray, 153.50f);
        ArrayList<Float> cumulativeSum = computeCumulativeSum(stockPricesArrayList);

        System.out.println("Average Price: " + averagePrice);
        System.out.println("Maximum Price: " + maxPrice);
        System.out.println("Occurrences of 153.50: " + occurrences);
        System.out.println("Cumulative Sum: " + cumulativeSum);

    }
}