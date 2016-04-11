package br.com.vivareal.spotippos.model;

import br.com.vivareal.spotippos.core.BaseModel;
import br.com.vivareal.spotippos.model.provincias.ProvinciaModel;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class SpotipposModel implements BaseModel{

    private static final long serialVersionUID = 764631298541739612L;
    private ProvinciaModel gode;
    private ProvinciaModel ruja;
    private ProvinciaModel jaby;
    private ProvinciaModel scavy;
    private ProvinciaModel groola;
    private ProvinciaModel nova;

    public ProvinciaModel getGode() {
        return gode;
    }

    public void setGode(ProvinciaModel gode) {
        this.gode = gode;
    }

    public ProvinciaModel getRuja() {
        return ruja;
    }

    public void setRuja(ProvinciaModel ruja) {
        this.ruja = ruja;
    }

    public ProvinciaModel getJaby() {
        return jaby;
    }

    public void setJaby(ProvinciaModel jaby) {
        this.jaby = jaby;
    }

    public ProvinciaModel getScavy() {
        return scavy;
    }

    public void setScavy(ProvinciaModel scavy) {
        this.scavy = scavy;
    }

    public ProvinciaModel getGroola() {
        return groola;
    }

    public void setGroola(ProvinciaModel groola) {
        this.groola = groola;
    }

    public ProvinciaModel getNova() {
        return nova;
    }

    public void setNova(ProvinciaModel nova) {
        this.nova = nova;
    }


}
