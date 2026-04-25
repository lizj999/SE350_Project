public class Order {
    public enum OrderType {
        BUY, SELL
    }

    private User user;
    private Stock stock;
    private int quantity;
    private OrderType orderType;

    public Order(User user, Stock stock, int quantity, OrderType orderType) {
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
        this.orderType = orderType;
    }

    public boolean execute() {
        double totalCost = stock.getPrice() * quantity;

        if (orderType == OrderType.BUY) {
            if (user.getAccount().withdraw(totalCost)) {
                System.out.println("Bought " + quantity + " share(s) of " + stock.getTicker() + " for $" + totalCost);
                return true;
            } else {
                return false;
            }
        } else {
            user.getAccount().deposit(totalCost);
            System.out.println("Sold " + quantity + " share(s) of " + stock.getTicker() + " for $" + totalCost);
            return true;
        }
    }

    public void printOrder() {
        System.out.println(orderType + " | " + quantity + " share(s) of " + stock.getTicker() + " @ $" + stock.getPrice());
    }
}
