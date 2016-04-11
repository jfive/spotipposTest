package br.com.vivareal.spotippos.web.servlets.importacao;

import java.util.List;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class PropriedadesImport {

    private Long totalProperties;
    private List<PropriedadesData> properties;

    public Long getTotalProperties() {
        return totalProperties;
    }

    public void setTotalProperties(Long totalProperties) {
        this.totalProperties = totalProperties;
    }

    public List<PropriedadesData> getProperties() {
        return properties;
    }

    public void setProperties(List<PropriedadesData> properties) {
        this.properties = properties;
    }
}
