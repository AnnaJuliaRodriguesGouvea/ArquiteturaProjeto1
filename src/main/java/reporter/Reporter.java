package reporter;

import formatter.Formatter;
import parser.Parser;

/*
    Classe abstrata que cria obrigatoriedade de ter um Formatter e um Parser
    nas classes Reporter que extendem ela
*/
public abstract class Reporter {
    private Formatter formatter;
    private Parser parser;

    public Formatter getFormatter() {
        return formatter;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }
}
