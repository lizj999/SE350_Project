public class User {
    private String name;
    private Account account;

    public User(String name, String accountId, double initialBalance) {
        this.name = name;
        this.account = new Account(accountId, initialBalance);
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public void printInfo() {
        System.out.println("User: " + name);
        account.printBalance();
    }
}
