import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Stock> stocks;

    public Market() {
        stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", "Apple Inc.", 189.50));
        stocks.add(new Stock("GOOGL", "Alphabet Inc.", 141.75));
        stocks.add(new Stock("TSLA", "Tesla Inc.", 245.30));
        stocks.add(new Stock("AMZN", "Amazon.com Inc.", 185.20));
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public Stock findStock(String ticker) {
        for (Stock s : stocks) {
            if (s.getTicker().equalsIgnoreCase(ticker)) {
                return s;
            }
        }
        return null;
    }

    public void printAllStocks() {
        System.out.println("\n--- Available Stocks ---");
        for (Stock s : stocks) {
            s.printInfo();
        }
    }
}
