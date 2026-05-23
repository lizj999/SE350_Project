// Decorator Pattern - Abstract Decorator
// Wraps any IStock and delegates calls to the inner stock
public abstract class StockDecorator implements IStock {
    protected IStock innerStock;

    public StockDecorator(IStock stock) {
        this.innerStock = stock;
    }

    @Override
    public String getTicker() { return innerStock.getTicker(); }

    @Override
    public double getPrice() { return innerStock.getPrice(); }

    @Override
    public String getDescription() { return innerStock.getDescription(); }
}
