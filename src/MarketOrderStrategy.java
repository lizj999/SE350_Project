public class MarketOrderStrategy implements IOrderStrategy {
    public void execute(User user, Stock stock, int quantity) {
        double totalCost = stock.getPrice() * quantity;
        System.out.println("Market Order: executing at current price $" + stock.getPrice());
        if (user.getAccount().withdraw(totalCost)) {
            System.out.println("Bought " + quantity + " share(s) of " + stock.getTicker() + " for $" + totalCost);
        }
    }
}
