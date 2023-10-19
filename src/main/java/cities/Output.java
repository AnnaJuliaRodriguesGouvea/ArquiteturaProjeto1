package cities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/*
    Classe que representa um modelo de resultado que agrupa os valores de um documento json
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Output {
    private List<Estados> estados;

    public List<Estados> getEstados() {
        return estados;
    }

    public void setEstados(List<Estados> estados) {
        this.estados = estados;
    }
}
