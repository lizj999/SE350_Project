public class BuyCommand implements ICommand {
    private User user;
    private Stock stock;
    private int quantity;
    private IOrderStrategy strategy;

    public BuyCommand(User user, Stock stock, int quantity, IOrderStrategy strategy) {
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
        this.strategy = strategy;
    }

    public void execute() {
        System.out.println("\nExecuting Buy Command for " + stock.getTicker());
        strategy.execute(user, stock, quantity);
    }
}
