package cities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/*
    Classe que representa um modelo Estado a partir de um documento json
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Estados {
    private List<Cidades> cidades;

    public List<Cidades> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidades> cidades) {
        this.cidades = cidades;
    }
}
