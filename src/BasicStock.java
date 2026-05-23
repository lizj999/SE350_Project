// Decorator Pattern - Concrete Component
// A plain stock with a ticker and price
public class BasicStock implements IStock {
    private String ticker;
    private double price;

    public BasicStock(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
    }

    @Override
    public String getTicker() { return ticker; }

    @Override
    public double getPrice() { return price; }

    @Override
    public String getDescription() {
        return ticker + " @ $" + String.format("%.2f", price);
    }
}
