// Template Method Pattern - Concrete Class
// Generates a report specifically for sell trades
public class SellReport extends TradeReport {
    private String ticker;
    private int quantity;
    private double price;

    public SellReport(String ticker, int quantity, double price) {
        this.ticker = ticker;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    protected void gatherData() {
        System.out.println("[SellReport] Gathering sell trade data for " + ticker);
    }

    @Override
    protected void formatReport() {
        System.out.println("[SellReport] Formatting report...");
        System.out.println("  Trade Type  : SELL");
        System.out.println("  Ticker      : " + ticker);
        System.out.println("  Quantity    : " + quantity);
        System.out.println("  Price       : $" + String.format("%.2f", price));
        System.out.println("  Total Value : $" + String.format("%.2f", quantity * price));
    }

    @Override
    protected void printReport() {
        System.out.println("[SellReport] Report printed successfully.");
    }
}
