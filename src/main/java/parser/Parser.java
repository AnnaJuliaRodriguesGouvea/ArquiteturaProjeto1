package parser;

import java.util.List;

/*
    Interface criada para criar obrigatoriedade do metódo parse nas classes
    que implementa e serão responsáveis pela conversão dos dados lidos do arquivo (JSON, CSV, ..)
    para uma lista de strings (nomes das cidades).
*/
public interface Parser {

    List<String> parse(String content);
}
