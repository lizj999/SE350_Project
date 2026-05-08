import java.util.ArrayList;
import java.util.List;

public class TradeInvoker {
    private List<ICommand> commandHistory;

    public TradeInvoker() {
        commandHistory = new ArrayList<>();
    }

    public void addCommand(ICommand command) {
        commandHistory.add(command);
    }

    public void executeAll() {
        System.out.println("\n--- Executing All Trades ---");
        for (ICommand command : commandHistory) {
            command.execute();
        }
        commandHistory.clear();
    }

    public void printHistory() {
        System.out.println("\n--- Trade History ---");
        if (commandHistory.isEmpty()) {
            System.out.println("No pending trades.");
        } else {
            for (int i = 0; i < commandHistory.size(); i++) {
                System.out.println((i + 1) + ". " + commandHistory.get(i).getClass().getSimpleName());
            }
        }
    }
}
