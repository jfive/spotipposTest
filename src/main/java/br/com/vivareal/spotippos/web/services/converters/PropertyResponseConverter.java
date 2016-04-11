package br.com.vivareal.spotippos.web.services.converters;

import br.com.vivareal.spotippos.model.commons.CoordenadasModel;
import br.com.vivareal.spotippos.model.propriedades.PropriedadeModel;
import br.com.vivareal.spotippos.web.services.response.PropertyResponse;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class PropertyResponseConverter {

    private PropertyResponseConverter() {
    }

    public static final PropertyResponse converter(PropriedadeModel propriedade) {

        PropertyResponse response = new PropertyResponse();
        response.setId(propriedade.getId());
        response.setBaths(propriedade.getQuantidadeBanheiros());
        response.setBeds(propriedade.getQuantidadeQuartos());
        response.setProvinces(propriedade.getProvincias());
        response.setSquareMeters(propriedade.getMetrosQuadrados());

        CoordenadasModel localizacao = propriedade.getLocalizacao();
        response.setX(localizacao.getCoordenadaX());
        response.setY(localizacao.getCoordenadaY());

        return response;
    }

}
