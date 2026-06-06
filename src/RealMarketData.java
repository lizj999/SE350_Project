import java.util.HashMap;

// Proxy Pattern - Real Object
// The actual market data source, expensive to access
public class RealMarketData implements IMarketData {
    private HashMap<String, Double> prices = new HashMap<>();

    public RealMarketData() {
        System.out.println("[RealMarketData] Loading market data...");
        prices.put("AAPL", 180.00);
        prices.put("TSLA", 250.00);
        prices.put("GOOGL", 140.00);
        prices.put("AMZN", 185.00);
    }

    @Override
    public double getPrice(String ticker) {
        return prices.getOrDefault(ticker, -1.0);
    }

    @Override
    public void printInfo(String ticker) {
        System.out.println("[RealMarketData] " + ticker
                + " price: $" + String.format("%.2f", getPrice(ticker)));
    }
}
