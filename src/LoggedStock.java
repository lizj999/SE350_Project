// Decorator Pattern - Concrete Decorator #1
// Logs every time the stock price is accessed
public class LoggedStock extends StockDecorator {

    public LoggedStock(IStock stock) {
        super(stock);
    }

    @Override
    public double getPrice() {
        System.out.println("[LOG] Accessing price for " + innerStock.getTicker());
        return innerStock.getPrice();
    }

    @Override
    public String getDescription() {
        return innerStock.getDescription() + " [LOGGED]";
    }
}
