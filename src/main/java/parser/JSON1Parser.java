package parser;

import cities.Cidades;
import cities.Estados;
import cities.Output;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

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
