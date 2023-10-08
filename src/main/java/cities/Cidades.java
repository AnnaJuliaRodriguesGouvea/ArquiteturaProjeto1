package cities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cidades {

    @JsonProperty("cidades")
    private String cidade;
    @JsonProperty("ID")
    private String id;
    @JsonProperty("Nome")
    private String nome;
    @JsonProperty("Estado")
    private String estado;

    public Cidades(String cidades) {
        this.cidade = cidades;
    }

    public Cidades(){}

    public String getCidades() {
        return cidade;
    }

    public void setCidades(String nomeCidade) {
        this.cidade = nomeCidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

