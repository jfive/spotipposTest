package br.com.vivareal.spotippos.model.propriedades;

import br.com.vivareal.spotippos.core.BaseModel;
import br.com.vivareal.spotippos.model.commons.CoordenadasModel;

import java.util.List;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class PropriedadeModel implements BaseModel {

    private static final long serialVersionUID = -8591003198119991680L;
    private Integer id;
    private CoordenadasModel localizacao;
    private Integer quantidadeQuartos;
    private Integer quantidadeBanheiros;
    private List<String> provincias;
    private Integer metrosQuadrados;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CoordenadasModel getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(CoordenadasModel localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(Integer quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public Integer getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(Integer quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public List<String> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<String> provincias) {
        this.provincias = provincias;
    }

    public Integer getMetrosQuadrados() {
        return metrosQuadrados;
    }

    public void setMetrosQuadrados(Integer metrosQuadrados) {
        this.metrosQuadrados = metrosQuadrados;
    }
}
