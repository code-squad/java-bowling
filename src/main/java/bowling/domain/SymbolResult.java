package bowling.domain;

import java.util.List;

public class SymbolResult {

    private List<Symbol> symbols;

    private SymbolResult(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public static SymbolResult of(List<Symbol> symbols) {
        return new SymbolResult(symbols);
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }
}
