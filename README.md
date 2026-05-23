# SE350_Project


## Sprint 1 Checklist

- **In a group?** No
- **Programming language:** Java (JDK 21)
- **GitHub account set up?** Yes
- **Public repository link:** https://github.com/lizj999/SE350_Project
- **Hello World compiles and runs?** Yes
- **Entry point:** src/Main.java


## Sprint 2

### Project: Stock Trading Platform

A terminal based stock trading platform where users can view stocks, buy and sell shares, and manage their account balance. 

Note: If time allows, a Java Swing GUI will be added on top of the existing terminal logic. This would include a main window with buttons for buying and selling stocks, a table displaying available stocks and prices, and a portfolio view.

### Libraries / Java Utilities

- java.util.ArrayList - to store lists of stocks and orders

- java.util.HashMap - to map stock tickers to prices

- java.util.Scanner - to handle user input from the terminal


## Sprint 3

### Design Patterns Implemented
1. **Strategy Pattern** - IOrderStrategy interface with MarketOrderStrategy 
and LimitOrderStrategy concrete classes. Allows different order execution 
strategies to be used interchangeably.

2. **Command Pattern** - ICommand interface with BuyCommand and SellCommand 
concrete classes. TradeInvoker stores and executes commands. Encapsulates 
each trade as a command object.

### Final Submission Goals
The final submission will demonstrate a fully working terminal-based stock 
trading platform where a user can view stocks, place buy and sell orders 
using different strategies, and manage their account balance. All 6 design 
patterns will be wired together to complete these actions.

### Problems
No major problems encountered this sprint. Strategy and Command patterns 
fit naturally into the trading platform structure.



## Sprint 4 Design Patterns

### Observer Pattern
- IObserver, ISubject - abstract interfaces
- Market - Concrete Subject; holds stock prices and notifies observers on change
- UserPortfolio - Concrete Observer; prints updated portfolio value when prices change

### Decorator Pattern
- IStock - Abstract Component interface
- BasicStock - Concrete Component; plain stock with ticker and price
- StockDecorator - Abstract Decorator; wraps any IStock
- LoggedStock - Concrete Decorator; logs every price access
- FeeStock - Concrete Decorator; adds 1.5% transaction fee to price

## Sprint 4 Final Submission Plan
Planning to demo a working terminal menu where users can update stock prices,
see live updates pushed to their portfolio via Observer, and apply fee/logging
decorators to any stock.

## Sprint 4 Issues
No major issues. Observer integrates cleanly with the existing Market class.
