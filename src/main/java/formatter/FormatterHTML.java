package formatter;

import java.util.List;

/*
    Classe que implementa o Fromatter criando a saída de dados em um modelo fixo de HTML
*/
public class FormatterHTML implements Formatter {
    @Override
    public String output(List<String> cidades) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE HTML>\n");
        html.append("<html>\n");
        html.append("<head>\n");
        html.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
        html.append("<title>Relatório de Nomes de Cidades</title>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("<h1>Relatório de Nomes de Cidades</h1>\n");
        html.append("<ul>\n");

        for (String cidade : cidades) {
            html.append("     <li>").append(cidade).append("</li>\n");
        }

        html.append("</ul>\n");
        html.append("</body>\n");
        html.append("</html>\n");

        return html.toString();
    }
}
