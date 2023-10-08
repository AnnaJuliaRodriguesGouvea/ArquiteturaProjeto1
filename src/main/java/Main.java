import reporter.CitiesReporter;
import reporter.CitiesReporterBuilder;
import formatter.Formatter;
import formatter.FormatterHTML;
import formatter.FormatterTXT;
import parser.CSVParser;
import parser.JSON1Parser;
import parser.JSON2Parser;
import parser.Parser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java Main <formato>");
            return;
        }

        Path currentRelativePath = Paths.get("");
        String currentAbsolutePath = currentRelativePath.toAbsolutePath().toString();
        String resourcesPath = currentAbsolutePath + "/src/main/resources/";
        String path = resourcesPath + args[1];

        Map<String, Formatter> formaterStrategies = new HashMap<>();
        formaterStrategies.put("html", new FormatterHTML());
        formaterStrategies.put("txt", new FormatterTXT());

        Map<String, Parser> parsers = new HashMap<>();
        parsers.put(resourcesPath + "cidades-1.json", new JSON1Parser());
        parsers.put(resourcesPath + "cidades-2.json", new JSON2Parser());
        parsers.put(resourcesPath + "cidades.csv", new CSVParser());

        Formatter selectedFormater = formaterStrategies.get(args[0]);
        Parser selectedParser = parsers.get(path);

        if (selectedFormater == null || selectedParser == null)  {
            System.out.println("Formato não suportado: " + args[0] + " ou " + args[1]);
            return;
        }

        try {
            CitiesReporter reporter = new CitiesReporterBuilder()
                            .withFormaterStrategy(selectedFormater)
                            .withParser(selectedParser)
                            .build();
            System.out.println(reporter.report(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
