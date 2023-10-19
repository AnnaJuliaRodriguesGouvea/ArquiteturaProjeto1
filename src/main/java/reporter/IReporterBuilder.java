package reporter;

import formatter.Formatter;
import parser.Parser;

/*
    Interface criada para criar obrigatoriedade dos metódos withParser e withFormaterStrategy
    nas classes reporter builder
*/
public interface IReporterBuilder {
    IReporterBuilder withParser(Parser parser);
    IReporterBuilder withFormaterStrategy(Formatter formatter);

}
