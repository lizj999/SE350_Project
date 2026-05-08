public class Main {
    public static void main(String[] args) {
        // Setup
        User user = new User("Liz", "ACC001", 10000.00);
        Market market = new Market();

        System.out.println("=== Stock Trading Platform ===");
        user.printInfo();
        market.printAllStocks();

        // Demo Strategy Pattern
        System.out.println("\n--- Strategy Pattern Demo ---");
        Stock apple = market.findStock("AAPL");
        Stock tesla = market.findStock("TSLA");

        // Market Order Strategy
        IOrderStrategy marketStrategy = new MarketOrderStrategy();
        marketStrategy.execute(user, apple, 2);

        // Limit Order Strategy - price is below limit so it executes
        IOrderStrategy limitStrategy = new LimitOrderStrategy(250.00);
        limitStrategy.execute(user, tesla, 1);

        // Limit Order Strategy - price is above limit so it does NOT execute
        IOrderStrategy strictLimit = new LimitOrderStrategy(100.00);
        strictLimit.execute(user, apple, 1);

        // Demo Command Pattern
        System.out.println("\n--- Command Pattern Demo ---");
        TradeInvoker invoker = new TradeInvoker();

        Stock google = market.findStock("GOOGL");
        invoker.addCommand(new BuyCommand(user, google, 3, new MarketOrderStrategy()));
        invoker.addCommand(new SellCommand(user, apple, 1));

        invoker.executeAll();

        System.out.println("\n--- Final Account Balance ---");
        user.printInfo();
    }
}
