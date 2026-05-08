public class SellCommand implements ICommand {
    private User user;
    private Stock stock;
    private int quantity;

    public SellCommand(User user, Stock stock, int quantity) {
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
    }

    public void execute() {
        double totalValue = stock.getPrice() * quantity;
        System.out.println("\nExecuting Sell Command for " + stock.getTicker());
        user.getAccount().deposit(totalValue);
        System.out.println("Sold " + quantity + " share(s) of " + stock.getTicker() + " for $" + totalValue);
    }
}
