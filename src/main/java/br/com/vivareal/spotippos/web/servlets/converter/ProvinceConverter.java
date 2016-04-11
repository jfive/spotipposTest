package br.com.vivareal.spotippos.web.servlets.converter;

import br.com.vivareal.spotippos.model.commons.CoordenadasModel;
import br.com.vivareal.spotippos.model.provincias.ProvinciaFronteiraModel;
import br.com.vivareal.spotippos.model.provincias.ProvinciaModel;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class ProvinceConverter {

    private ProvinceConverter() {}

    public static final List<ProvinciaModel> converter(Map<String,Map> spotippos) {


        return spotippos.entrySet().stream().collect(Collectors.mapping((Function<Map.Entry<String, Map>, ProvinciaModel>) p -> {

            ProvinciaModel model = new ProvinciaModel();
            model.setNome(p.getKey());
            model.setFronteiras(makeFronteiras((Map) p.getValue().get("boundaries")));

            return model;

        }, Collectors.toList()));
    }

    private static ProvinciaFronteiraModel makeFronteiras(Map<String,Map<String,Double>> value) {

        ProvinciaFronteiraModel fronteiraModel = new ProvinciaFronteiraModel();
        fronteiraModel.setCoordenadaSuperiorEsquerda(makeCoordenada(value.get("upperLeft")));
        fronteiraModel.setCoordenadaInferiorDireita(makeCoordenada(value.get("bottomRight")));

        return fronteiraModel;
    }

    private static CoordenadasModel makeCoordenada(Map<String, Double> coordenada) {
        CoordenadasModel coordenadaModel = new CoordenadasModel();
        coordenadaModel.setCoordenadaX(coordenada.get("x").intValue());
        coordenadaModel.setCoordenadaY(coordenada.get("y").intValue());
        return coordenadaModel;
    }


}
