package reporter;

import formatter.Formatter;
import parser.Parser;

public interface IReporterBuilder {
    public IReporterBuilder withParser(Parser parser);
    public IReporterBuilder withFormaterStrategy(Formatter formatter);

}
