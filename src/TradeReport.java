// Template Method Pattern - Abstract Class
// Defines the skeleton of a trade report algorithm
public abstract class TradeReport {

    // Template method - defines the fixed order of steps
    public final void generateReport() {
        gatherData();
        formatReport();
        printReport();
    }

    protected abstract void gatherData();
    protected abstract void formatReport();
    protected abstract void printReport();
}
