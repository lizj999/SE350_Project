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
        market.attach(liz);
        market.setStockPrice("AAPL", 180.00);
        market.setStockPrice("TSLA", 250.00);
        System.out.println();

        // --- Template Method Pattern Demo ---
        System.out.println("=== Template Method Pattern Demo ===");
        TradeReport buyReport = new BuyReport("AAPL", 10, 180.00);
        buyReport.generateReport();
        System.out.println();
        TradeReport sellReport = new SellReport("TSLA", 5, 250.00);
        sellReport.generateReport();
        System.out.println();

        // --- Proxy Pattern Demo ---
        System.out.println("=== Proxy Pattern Demo ===");
        IMarketData proxy = new MarketDataProxy();
        proxy.printInfo("AAPL");
        proxy.printInfo("TSLA");
        proxy.printInfo("AAPL"); // should use cache this time
        System.out.println();

        // --- Menu ---
        boolean running = true;
        while (running) {
            System.out.println("\n=== Stock Trading Platform ===");
            System.out.println("1. Update stock price");
            System.out.println("2. View all stock prices");
            System.out.println("3. Generate buy report");
            System.out.println("4. Generate sell report");
            System.out.println("5. Exit");
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
                    System.out.print("Enter ticker: ");
                    String bt = scanner.nextLine().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int bq = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter price: ");
                    double bp = Double.parseDouble(scanner.nextLine());
                    new BuyReport(bt, bq, bp).generateReport();
                    break;
                case "4":
                    System.out.print("Enter ticker: ");
                    String st = scanner.nextLine().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int sq = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter price: ");
                    double sp = Double.parseDouble(scanner.nextLine());
                    new SellReport(st, sq, sp).generateReport();
                    break;
                case "5":
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
