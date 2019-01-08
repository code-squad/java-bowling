package bowling.domain;

public class Symbol {

    private String symbol;

    private Symbol(String symbol) {
        this.symbol = symbol;
    }

    public static Symbol of(String symbol) {
        return new Symbol(symbol);
    }

    public static Symbol of(int symbol) {
        return Symbol.of(String.valueOf(symbol));
    }

    public Symbol add(Symbol symbol) {
        return Symbol.of(this.symbol + symbol.getSymbol());
    }

    public String getSymbol() {
        return symbol;
    }
}
