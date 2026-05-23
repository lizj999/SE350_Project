import java.util.HashMap;

// Observer Pattern - Concrete Observer
// UserPortfolio watches the Market and updates its holdings value when prices change
public class UserPortfolio implements IObserver {
    private String userName;
    private HashMap<String, Integer> holdings = new HashMap<>();

    public UserPortfolio(String userName) {
        this.userName = userName;
    }

    public void addHolding(String ticker, int shares) {
        holdings.put(ticker, holdings.getOrDefault(ticker, 0) + shares);
    }

    @Override
    public void update(String ticker, double newPrice) {
        if (holdings.containsKey(ticker)) {
            int shares = holdings.get(ticker);
            double value = shares * newPrice;
            System.out.println("[Portfolio - " + userName + "] " + ticker
                    + " is now $" + newPrice + " | You own " + shares
                    + " shares = $" + String.format("%.2f", value));
        }
    }

    public String getUserName() {
        return userName;
    }
}
