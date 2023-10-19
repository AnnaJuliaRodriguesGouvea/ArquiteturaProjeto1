package formatter;

import java.util.List;

/*
    Interface criada para criar obrigatoriedade do metódo output nas classes
    que implementa e serão responsáveis pela saída de dados (HTML, TXT, ...)
*/
public interface Formatter {
    public String output(List<String> cidades);
}
