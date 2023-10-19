package reporter;

import formatter.Formatter;
import parser.Parser;

public class CitiesReporterBuilder implements IReporterBuilder{

    private Parser parser;
    private Formatter formatter;

    // Método responsável por construir o tipo Parser do CitiesReporter
    public CitiesReporterBuilder withParser(Parser parser) {
        this.parser = parser;
        return this;
    }

    // Método responsável por construir o tipo Formatter do CitiesReporter
    public CitiesReporterBuilder withFormaterStrategy(Formatter formatter) {
        this.formatter = formatter;
        return this;
    }

    // Método responsável por construir o objeto CitiesReporter
    public CitiesReporter build() {
        if (this.formatter == null || this.parser == null) {
            throw new Error("A strategy/parser must be provided.");
        }
        return CitiesReporter.getInstance(this.formatter, this.parser);
    }
}
