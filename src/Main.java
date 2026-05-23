import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Decorator Pattern Demo ---
        System.out.println("=== Decorator Pattern Demo ===");
        IStock apple = new BasicStock("AAPL", 175.00);
        IStock loggedApple = new LoggedStock(apple);
        IStock feeApple = new FeeStock(loggedApple);
        System.out.println("Stock: " + feeApple.getDescription());
        System.out.println("Final price with fee: $" + String.format("%.2f", feeApple.getPrice()));

        System.out.println();

        // --- Observer Pattern Demo ---
        System.out.println("=== Observer Pattern Demo ===");
        Market market = new Market();

        UserPortfolio liz = new UserPortfolio("Liz");
        liz.addHolding("AAPL", 10);
        liz.addHolding("TSLA", 5);

        UserPortfolio john = new UserPortfolio("John");
        john.addHolding("AAPL", 20);

        market.attach(liz);
        market.attach(john);

        market.setStockPrice("AAPL", 180.00);
        System.out.println();
        market.setStockPrice("TSLA", 250.00);

        System.out.println();

        // --- Menu ---
        boolean running = true;
        while (running) {
            System.out.println("\n=== Stock Trading Platform ===");
            System.out.println("1. Update stock price");
            System.out.println("2. View all stock prices");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter ticker: ");
                    String ticker = scanner.nextLine().toUpperCase();
                    System.out.print("Enter new price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    market.setStockPrice(ticker, price);
                    break;
                case "2":
                    System.out.println("Current prices: " + market.getAllPrices());
                    break;
                case "3":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
