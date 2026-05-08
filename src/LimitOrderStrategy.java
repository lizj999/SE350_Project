public class LimitOrderStrategy implements IOrderStrategy {
    private double limitPrice;

    public LimitOrderStrategy(double limitPrice) {
        this.limitPrice = limitPrice;
    }

    public void execute(User user, Stock stock, int quantity) {
        System.out.println("Limit Order: limit price set at $" + limitPrice);
        if (stock.getPrice() <= limitPrice) {
            double totalCost = stock.getPrice() * quantity;
            if (user.getAccount().withdraw(totalCost)) {
                System.out.println("Bought " + quantity + " share(s) of " + stock.getTicker() + " for $" + totalCost);
            }
        } else {
            System.out.println("Limit Order not executed. Current price $" + stock.getPrice() + " exceeds limit $" + limitPrice);
        }
    }
}
