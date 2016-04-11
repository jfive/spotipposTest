package br.com.vivareal.spotippos.repository.converter;

import br.com.vivareal.spotippos.model.commons.CoordenadasModel;
import br.com.vivareal.spotippos.model.propriedades.PropriedadeModel;
import br.com.vivareal.spotippos.web.services.request.SavePropertyRequest;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class SavePropriedadeConverter {

    private SavePropriedadeConverter() {}

    public static PropriedadeModel converter(SavePropertyRequest request) {
        PropriedadeModel model = new PropriedadeModel();
        model.setQuantidadeBanheiros(request.getBaths());
        model.setQuantidadeQuartos(request.getBeds());
        model.setMetrosQuadrados(request.getSquareMeters());

        CoordenadasModel localizacao = new CoordenadasModel();
        localizacao.setCoordenadaY(request.getY());
        localizacao.setCoordenadaX(request.getX());
        model.setLocalizacao(localizacao);

        return model;
    }

}
