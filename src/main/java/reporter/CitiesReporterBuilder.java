package reporter;

import formatter.Formatter;
import parser.Parser;

public class CitiesReporterBuilder implements IReporterBuilder{

    private Parser parser;
    private Formatter formatter;

    public CitiesReporterBuilder withParser(Parser parser) {
        this.parser = parser;
        return this;
    }

    public CitiesReporterBuilder withFormaterStrategy(Formatter formatter) {
        this.formatter = formatter;
        return this;
    }

    public CitiesReporter build() {
        if (this.formatter == null || this.parser == null) {
            throw new Error("A strategy/parser must be provided.");
        }
        return CitiesReporter.getInstance(this.formatter, this.parser);
    }
}
