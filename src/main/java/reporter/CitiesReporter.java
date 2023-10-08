package reporter;

import formatter.Formatter;
import parser.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CitiesReporter extends Reporter {
    private static CitiesReporter citiesReporter;
    private String citiesFile;

    private List<String> cities;

    private CitiesReporter(Formatter formatter, Parser parser) {
        this.setFormatter(formatter);
        this.setParser(parser);
    }

    public static CitiesReporter getInstance(Formatter formatter, Parser parser) {
        if(CitiesReporter.citiesReporter == null) {
            CitiesReporter.citiesReporter = new CitiesReporter(formatter, parser);
        }
        return CitiesReporter.citiesReporter;
    }

    private void read(String path) throws IOException {
        this.citiesFile = new String(Files.readAllBytes(Paths.get(path)));
    }

    private void parse() {
        this.cities = this.getParser().parse(this.citiesFile);
    }

    public String report(String path) throws IOException {
        read(path);
        parse();
        return this.getFormatter().output(cities);
    }
}
