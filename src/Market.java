import java.util.ArrayList;
import java.util.HashMap;

// Observer Pattern - Concrete Subject
// The Market holds stock prices and notifies observers when prices change
public class Market implements ISubject {
    private HashMap<String, Double> stockPrices = new HashMap<>();
    private ArrayList<IObserver> observers = new ArrayList<>();

    public void setStockPrice(String ticker, double price) {
        stockPrices.put(ticker, price);
        System.out.println("[Market] " + ticker + " price updated to $" + price);
        notifyObservers();
    }

    public double getStockPrice(String ticker) {
        return stockPrices.getOrDefault(ticker, 0.0);
    }

    public HashMap<String, Double> getAllPrices() {
        return stockPrices;
    }

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            for (String ticker : stockPrices.keySet()) {
                observer.update(ticker, stockPrices.get(ticker));
            }
        }
    }
}
