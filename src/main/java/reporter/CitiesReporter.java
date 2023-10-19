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

    //Construtor foi deixado privado para arquitetar o padrao de projeto singleton
    private CitiesReporter(Formatter formatter, Parser parser) {
        this.setFormatter(formatter);
        this.setParser(parser);
    }

    //Método getInstace foi criado para implementar o padrao de projeto singleton
    //Visando existir apenas uma instancia da classe no projeto
    public static CitiesReporter getInstance(Formatter formatter, Parser parser) {
        if(CitiesReporter.citiesReporter == null) {
            CitiesReporter.citiesReporter = new CitiesReporter(formatter, parser);
        }
        return CitiesReporter.citiesReporter;
    }

    //Método que lê o arquivo
    private void read(String path) throws IOException {
        this.citiesFile = new String(Files.readAllBytes(Paths.get(path)));
    }

    //Método que chama o parse de acordo com o Parser construido e converte para uma lista de cidades
    private void parse() {
        this.cities = this.getParser().parse(this.citiesFile);
    }

    //Método que chama o read, parse e realiza a chamada para o método de saída de dados de acordo com o
    //formatter utilizado na construção do objeto
    public String report(String path) throws IOException {
        read(path);
        parse();
        return this.getFormatter().output(cities);
    }
}
