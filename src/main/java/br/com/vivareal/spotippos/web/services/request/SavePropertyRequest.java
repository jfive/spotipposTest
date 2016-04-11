package br.com.vivareal.spotippos.web.services.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class SavePropertyRequest {

    @NotNull(message = "{x.notnull}")
    @Min(value = 0,message = "{x.min}")
    @Max(value = 1400,message = "{x.max}")
    private Integer x;
    @NotNull(message = "{y.notnull}")
    @Min(value = 0,message = "{y.min}")
    @Max(value = 1000,message = "{y.max}")
    private Integer y;
    @NotNull(message = "{beds.notnull}")
    @Min(value = 1,message = "{beds.min}")
    @Max(value = 5,message = "{beds.max}")
    private Integer beds;
    @NotNull(message = "{baths.notnull}")
    @Min(value = 1,message = "{baths.min}")
    @Max(value = 4,message = "{baths.max}")
    private Integer baths;
    @NotNull(message = "{squareMeters.notnull}")
    @Min(value = 20,message = "{squareMeters.min}")
    @Max(value = 240,message = "{squareMeters.max}")
    private Integer squareMeters;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }
}
