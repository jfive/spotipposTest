package br.com.vivareal.spotippos.web.services.response;

import java.util.List;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class PropertiesFoundResponse {

    private Integer foundProperties;
    private List<PropertyResponse> properties;

    public Integer getFoundProperties() {
        return foundProperties;
    }

    public void setFoundProperties(Integer foundProperties) {
        this.foundProperties = foundProperties;
    }

    public List<PropertyResponse> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyResponse> properties) {
        this.properties = properties;
    }
}
