// Proxy Pattern - Abstract Interface
// Shared by the Proxy and the Real Object
public interface IMarketData {
    double getPrice(String ticker);
    void printInfo(String ticker);
}
