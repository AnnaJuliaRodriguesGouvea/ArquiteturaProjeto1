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
        //Verifica se foi passado dois argumentos ao rodar o projeto (tipo de saida e arquivo de entrada)
        //Ex: html cidades-2.json
        if (args.length < 2) {
            System.out.println("Uso: java Main <formato>");
            return;
        }

        //Captura o path e adiciona o caminho para a pasta que se encontra os arquivos de entrada
        Path currentRelativePath = Paths.get("");
        String currentAbsolutePath = currentRelativePath.toAbsolutePath().toString();
        String resourcesPath = currentAbsolutePath + "/src/main/resources/";
        String path = resourcesPath + args[1];

        //Mapeia os tipos de formatter com a string devida
        Map<String, Formatter> formaterStrategies = new HashMap<>();
        formaterStrategies.put("html", new FormatterHTML());
        formaterStrategies.put("txt", new FormatterTXT());

        //Mapeia os tipos de parser com os caminhos e nomes dos arquivos devidos
        Map<String, Parser> parsers = new HashMap<>();
        parsers.put(resourcesPath + "cidades-1.json", new JSON1Parser());
        parsers.put(resourcesPath + "cidades-2.json", new JSON2Parser());
        parsers.put(resourcesPath + "cidades.csv", new CSVParser());

        //Pega o formatter e o parser selecionado via parametros
        Formatter selectedFormater = formaterStrategies.get(args[0]);
        Parser selectedParser = parsers.get(path);

        //Verifica se os tipos existem
        if (selectedFormater == null || selectedParser == null)  {
            System.out.println("Formato não suportado: " + args[0] + " ou " + args[1]);
            return;
        }

        try {
            //Cria um CitiesReporter usando o padrao de projeto builder:
            //passando na criação um formatter e um parser
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
