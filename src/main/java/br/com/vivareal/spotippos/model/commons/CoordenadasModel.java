package br.com.vivareal.spotippos.model.commons;

import br.com.vivareal.spotippos.core.BaseModel;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class CoordenadasModel implements BaseModel {

    private static final long serialVersionUID = -3779363170685602170L;
    private Integer coordenadaX;
    private Integer coordenadaY;

    public Integer getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoordenadasModel that = (CoordenadasModel) o;

        if (coordenadaX != null ? !coordenadaX.equals(that.coordenadaX) : that.coordenadaX != null) return false;
        return coordenadaY != null ? coordenadaY.equals(that.coordenadaY) : that.coordenadaY == null;

    }

    @Override
    public int hashCode() {
        int result = coordenadaX != null ? coordenadaX.hashCode() : 0;
        result = 31 * result + (coordenadaY != null ? coordenadaY.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CoordenadasModel{" +
                "coordenadaX=" + coordenadaX +
                ", coordenadaY=" + coordenadaY +
                '}';
    }
}
