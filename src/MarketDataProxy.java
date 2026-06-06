import java.util.HashMap;

// Proxy Pattern - Proxy Object
// Controls access to RealMarketData, caches prices to avoid repeated lookups
public class MarketDataProxy implements IMarketData {
    private RealMarketData realMarketData;
    private HashMap<String, Double> cache = new HashMap<>();

    @Override
    public double getPrice(String ticker) {
        if (cache.containsKey(ticker)) {
            System.out.println("[Proxy] Returning cached price for " + ticker);
            return cache.get(ticker);
        }
        if (realMarketData == null) {
            realMarketData = new RealMarketData();
        }
        double price = realMarketData.getPrice(ticker);
        cache.put(ticker, price);
        return price;
    }

    @Override
    public void printInfo(String ticker) {
        double price = getPrice(ticker);
        System.out.println("[Proxy] " + ticker
                + " price: $" + String.format("%.2f", price));
    }
}
