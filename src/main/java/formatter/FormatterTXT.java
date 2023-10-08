package formatter;

import java.util.List;

public class FormatterTXT implements Formatter {
    @Override
    public String output(List<String> cidades) {
        StringBuilder txt = new StringBuilder("Relatório de Nomes de Cidades\n");
        txt.append("=============================\n");

        for (String cidade : cidades) {
            txt.append("- ").append(cidade).append("\n");
        }

        return txt.toString();
    }
}
