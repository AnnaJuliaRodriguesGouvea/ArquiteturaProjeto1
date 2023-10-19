package parser;

import java.util.ArrayList;
import java.util.List;

/*
    Classe que implementa a Parser e é responsável pela conversão dos dados
    lidos do arquivo CSV para uma lista de strings (nomes das cidades).

    OBS: o arquivo CSV disponibilizado no link do github da proposta do projeto está “corrompido”
    porque o certo seria ter uma virgula depois das cidades e para nao ter que editar o arquivo
    inteiro implementei com \n, mas sei que é errado usar \n para arquivos CSV.
*/
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
