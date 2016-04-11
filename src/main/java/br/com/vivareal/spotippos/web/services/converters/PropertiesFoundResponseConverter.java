package br.com.vivareal.spotippos.web.services.converters;

import br.com.vivareal.spotippos.model.propriedades.PropriedadeModel;
import br.com.vivareal.spotippos.web.services.response.PropertiesFoundResponse;
import br.com.vivareal.spotippos.web.services.response.PropertyResponse;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class PropertiesFoundResponseConverter {

    private PropertiesFoundResponseConverter() {
    }

    public static PropertiesFoundResponse converter(Set<PropriedadeModel> propriedades){
        PropertiesFoundResponse response = new PropertiesFoundResponse();

        List<PropertyResponse> properties = propriedades.stream().map(PropertyResponseConverter::converter).collect(Collectors.toList());
        response.setFoundProperties(propriedades.size());
        response.setProperties(properties);

        return response;
    }

}
