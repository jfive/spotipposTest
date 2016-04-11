package br.com.vivareal.spotippos.web.servlets.converter;

import br.com.vivareal.spotippos.model.commons.CoordenadasModel;
import br.com.vivareal.spotippos.model.propriedades.PropriedadeModel;
import br.com.vivareal.spotippos.web.servlets.importacao.PropriedadesData;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public final class PropriedadesModelConverter {

    private PropriedadesModelConverter() {}

    public static PropriedadeModel converter(PropriedadesData data) {

        PropriedadeModel model = new PropriedadeModel();
        model.setId(data.getId());
        model.setMetrosQuadrados(data.getSquareMeters());
        model.setQuantidadeBanheiros(data.getBaths());
        model.setQuantidadeQuartos(data.getBeds());

        CoordenadasModel localizacao = new CoordenadasModel();
        localizacao.setCoordenadaX(data.getX());
        localizacao.setCoordenadaY(data.getY());
        model.setLocalizacao(localizacao);

        return model;
    }

}
