package parser;

import cities.Cidades;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JSON2Parser implements Parser{
    @Override
    public List<String> parse(String content) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Cidades> cidadesList = mapper.readValue(content, new TypeReference<>() {});
            List<String> nomeCidades = new ArrayList<>();
            for(Cidades cidades: cidadesList) {
                nomeCidades.add(cidades.getNome());
            }
            return nomeCidades;
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
        return new ArrayList<>();
    }
}
