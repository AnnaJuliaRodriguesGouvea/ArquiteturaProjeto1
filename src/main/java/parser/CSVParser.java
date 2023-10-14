package parser;

import java.util.ArrayList;
import java.util.List;

public class CSVParser implements Parser{
    @Override
    public List<String> parse(String content) {
        String[] split = content.split("\n");
        List<String> cidades = new ArrayList<>();
        for(int i = 1; i < split.length; i++) {
            String[] dados = split[i].split(",");
            cidades.add(dados[2]);
        }

        return cidades;
    }
}
