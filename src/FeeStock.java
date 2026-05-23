// Decorator Pattern - Concrete Decorator #2
// Adds a 1.5% transaction fee on top of the stock price
public class FeeStock extends StockDecorator {
    private static final double FEE_RATE = 0.015;

    public FeeStock(IStock stock) {
        super(stock);
    }

    @Override
    public double getPrice() {
        double basePrice = innerStock.getPrice();
        double fee = basePrice * FEE_RATE;
        System.out.println("[FEE] Base: $" + String.format("%.2f", basePrice)
                + " | Fee (1.5%): $" + String.format("%.2f", fee));
        return basePrice + fee;
    }

    @Override
    public String getDescription() {
        return innerStock.getDescription() + " [+1.5% FEE]";
    }
}
