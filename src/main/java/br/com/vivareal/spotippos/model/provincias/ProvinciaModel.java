package br.com.vivareal.spotippos.model.provincias;

import br.com.vivareal.spotippos.core.BaseModel;
import br.com.vivareal.spotippos.model.commons.CoordenadasModel;
import br.com.vivareal.spotippos.model.propriedades.PropriedadeModel;
import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class ProvinciaModel implements BaseModel {

    private static final long serialVersionUID = -5682257915407445321L;

    private String nome;
    private ProvinciaFronteiraModel fronteiras;
    private List<PropriedadeModel> propriedades = new ArrayList<>();

    public boolean isProvincia(PropriedadeModel propriedade){
        CoordenadasModel localizacao = propriedade.getLocalizacao();

        return fronteiras.getCoordenadasX().contains(localizacao.getCoordenadaX()) && fronteiras.getCoordenadasY().contains(localizacao.getCoordenadaY());
    }

    public boolean isProvincia(CoordenadasModel pontoSuperiorEsquerdo,CoordenadasModel pontoInferiorDireto) {

        List<Integer> listCoordenadasSuperiorEsquerdo = new ArrayList<Integer>(){{
            add(fronteiras.getCoordenadaSuperiorEsquerda().getCoordenadaX());
            add(fronteiras.getCoordenadaSuperiorEsquerda().getCoordenadaY());
            sort(Comparator.naturalOrder());
        }};

        List<Integer> listCoordenadasInferiorDireito = new ArrayList<Integer>(){{
            add(fronteiras.getCoordenadaInferiorDireita().getCoordenadaX());
            add(fronteiras.getCoordenadaInferiorDireita().getCoordenadaY());
            sort(Comparator.naturalOrder());
        }};

        Range<Integer> superiorEsquerdo = Range.closed(listCoordenadasSuperiorEsquerdo.get(0),listCoordenadasSuperiorEsquerdo.get(1));
        Range<Integer> inferiorDireito = Range.closed(listCoordenadasInferiorDireito.get(0), listCoordenadasInferiorDireito.get(1));

        boolean encontrado = false;

        if(superiorEsquerdo.contains(pontoSuperiorEsquerdo.getCoordenadaX()) || superiorEsquerdo.contains(pontoSuperiorEsquerdo.getCoordenadaY()) ||
                inferiorDireito.contains(pontoInferiorDireto.getCoordenadaX()) || inferiorDireito.contains(pontoInferiorDireto.getCoordenadaY())){
            encontrado = true;
        }

        return encontrado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProvinciaFronteiraModel getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(ProvinciaFronteiraModel fronteiras) {
        this.fronteiras = fronteiras;
    }

    public List<PropriedadeModel> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(List<PropriedadeModel> propriedades) {
        this.propriedades = propriedades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvinciaModel that = (ProvinciaModel) o;

        return fronteiras != null ? fronteiras.equals(that.fronteiras) : that.fronteiras == null;

    }

    @Override
    public int hashCode() {
        return fronteiras != null ? fronteiras.hashCode() : 0;
    }



    @Override
    public String toString() {
        return "ProvinciaModel{" +
                "nome='" + nome + '\'' +
                ", fronteiras=" + fronteiras +
                '}';
    }
}
