public interface IOrderStrategy {
    void execute(User user, Stock stock, int quantity);
}
