// Template Method Pattern - Concrete Class
// Generates a report specifically for buy trades
public class BuyReport extends TradeReport {
    private String ticker;
    private int quantity;
    private double price;

    public BuyReport(String ticker, int quantity, double price) {
        this.ticker = ticker;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    protected void gatherData() {
        System.out.println("[BuyReport] Gathering buy trade data for " + ticker);
    }

    @Override
    protected void formatReport() {
        System.out.println("[BuyReport] Formatting report...");
        System.out.println("  Trade Type : BUY");
        System.out.println("  Ticker     : " + ticker);
        System.out.println("  Quantity   : " + quantity);
        System.out.println("  Price      : $" + String.format("%.2f", price));
        System.out.println("  Total Cost : $" + String.format("%.2f", quantity * price));
    }

    @Override
    protected void printReport() {
        System.out.println("[BuyReport] Report printed successfully.");
    }
}
