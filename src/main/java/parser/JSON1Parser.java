package parser;

import cities.Cidades;
import cities.Estados;
import cities.Output;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;


/*
    Classe que implementa a Parser e é responsável pela conversão dos dados
    lidos do arquivo cidades-1.json para uma lista de strings (nomes das cidades).
*/
public class JSON1Parser implements Parser {

    @Override
    public List<String> parse(String content) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Output output = mapper.readValue(content, Output.class);
            List<String> nomeCidades = new ArrayList<>();
            for (Estados estados: output.getEstados()) {
                for (Cidades cidades : estados.getCidades()) {
                    nomeCidades.add(cidades.getCidades());
                }
            }
            return nomeCidades;
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
        return new ArrayList<>();
    }
}
