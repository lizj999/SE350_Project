import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Demo ArrayList - will be used to store stocks
        ArrayList<String> stocks = new ArrayList<>();
        stocks.add("AAPL");
        stocks.add("GOOGL");
        stocks.add("TSLA");
        System.out.println("Stocks list: " + stocks);

        // Demo HashMap - will be used to map tickers to prices
        HashMap<String, Double> prices = new HashMap<>();
        prices.put("AAPL", 189.50);
        prices.put("GOOGL", 141.75);
        prices.put("TSLA", 245.30);
        System.out.println("Stock prices: " + prices);

        // Demo Scanner - will be used for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a stock ticker: ");
        String input = scanner.next();
        System.out.println("You entered: " + input + " | Price: $" + prices.get(input));
        scanner.close();
    }
}
