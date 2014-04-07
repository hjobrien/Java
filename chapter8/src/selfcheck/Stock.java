// A Stock object represents purchases of shares of a particular stock.
public class Stock {
    private String symbol;        // stock symbol, such as "YHOO"
    private int totalShares;      // total number of shares purchased
    private double totalCost;     // total cost for all shares purchased

    // Creates a new Stock with the given symbol and no shares purchased.
    // Precondition: symbol != null
    public Stock(String theSymbol) {
        if (theSymbol == null) {
            throw new NullPointerException();
        }

        symbol = theSymbol;
        totalShares = 0;
        totalCost = 0.00;
    }

    // Removes all purchases of this Stock.
    public void clear() {
        totalShares = 0;
        totalCost = 0.00;
    }

    // Returns whether the two Stock objects have the same state.
    public boolean equals(Object o) {
        if (o instanceof Stock) {
            Stock other = (Stock) o;
            return symbol.equals(other.symbol) &&
                   totalShares == other.totalShares &&
                   totalCost == other.totalCost;
        } else {
            return false;
        }
    }

    // Returns this Stock's total number of shares purchased.
    public int getTotalShares() {
        return totalShares;
    }

    // Returns this Stock's symbol value.
    public String getSymbol() {
        return symbol;
    }

    // Returns this Stock's total cost for all shares.
    public double getTotalCost() {
        return totalCost;
    }

    // Returns the total profit or loss earned on the shares of this stock,
    // based on the given price per share.
    // Precondition: currentPrice >= 0.0
    public double getProfit(double currentPrice) {
        if (currentPrice < 0.0) {
            throw new IllegalArgumentException();
        }

        double marketValue = totalShares * currentPrice;
        return marketValue - totalCost;
    }

    // Records a purchase of the given number of shares of this stock
    // at the given price per share.
    // Precondition: numShares >= 0 && pricePerShare >= 0.00
    public void purchase(int shares, double pricePerShare) {
        if (shares < 0 || pricePerShare < 0.0) {
            throw new IllegalArgumentException();
        }

        totalShares += shares;
        totalCost += shares * pricePerShare;
    }
}
