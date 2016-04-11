package br.com.vivareal.spotippos.model.provincias;

import br.com.vivareal.spotippos.core.BaseModel;
import br.com.vivareal.spotippos.model.commons.CoordenadasModel;
import com.google.common.collect.Range;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class ProvinciaFronteiraModel implements BaseModel {

    private CoordenadasModel coordenadaSuperiorEsquerda;
    private CoordenadasModel coordenadaInferiorDireita;


    public CoordenadasModel getCoordenadaSuperiorEsquerda() {
        return coordenadaSuperiorEsquerda;
    }

    public void setCoordenadaSuperiorEsquerda(CoordenadasModel coordenadaSuperiorEsquerda) {
        this.coordenadaSuperiorEsquerda = coordenadaSuperiorEsquerda;
    }

    public CoordenadasModel getCoordenadaInferiorDireita() {
        return coordenadaInferiorDireita;
    }

    public void setCoordenadaInferiorDireita(CoordenadasModel coordenadaInferiorDireita) {
        this.coordenadaInferiorDireita = coordenadaInferiorDireita;
    }

    public Range<Integer> getCoordenadasX(){

        Integer coordenadaEsquedaX = coordenadaSuperiorEsquerda.getCoordenadaX();
        Integer coordenadaDireitaX = coordenadaInferiorDireita.getCoordenadaX();
        List<Integer> listNaturalOrder = createListNaturalOrder(coordenadaEsquedaX, coordenadaDireitaX);

        return Range.closed(listNaturalOrder.get(0), listNaturalOrder.get(1));
    }

    public Range<Integer> getCoordenadasY(){

        Integer coordenadaEsquedaY = coordenadaSuperiorEsquerda.getCoordenadaY();
        Integer coordenadaDireitaY = coordenadaInferiorDireita.getCoordenadaY();

        List<Integer> listNaturalOrder = createListNaturalOrder(coordenadaEsquedaY, coordenadaDireitaY);

        return Range.closed(listNaturalOrder.get(0), listNaturalOrder.get(1));
    }

    private List<Integer> createListNaturalOrder(Integer coordenadaEsquedaX, Integer coordenadaDireitaX) {
        List<Integer> coordenadas = Arrays.asList(coordenadaEsquedaX, coordenadaDireitaX);
        coordenadas.sort(Comparator.naturalOrder());
        return coordenadas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvinciaFronteiraModel that = (ProvinciaFronteiraModel) o;

        if (coordenadaSuperiorEsquerda != null ? !coordenadaSuperiorEsquerda.equals(that.coordenadaSuperiorEsquerda) : that.coordenadaSuperiorEsquerda != null)
            return false;
        return coordenadaInferiorDireita != null ? coordenadaInferiorDireita.equals(that.coordenadaInferiorDireita) : that.coordenadaInferiorDireita == null;

    }

    @Override
    public int hashCode() {
        int result = coordenadaSuperiorEsquerda != null ? coordenadaSuperiorEsquerda.hashCode() : 0;
        result = 31 * result + (coordenadaInferiorDireita != null ? coordenadaInferiorDireita.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProvinciaFronteiraModel{" +
                "coordenadaSuperiorEsquerda=" + coordenadaSuperiorEsquerda +
                ", coordenadaInferiorDireita=" + coordenadaInferiorDireita +
                '}';
    }
}
