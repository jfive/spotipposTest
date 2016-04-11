package br.com.vivareal.spotippos.web.services;

import br.com.vivareal.spotippos.model.commons.CoordenadasModel;
import br.com.vivareal.spotippos.model.propriedades.PropriedadeModel;
import br.com.vivareal.spotippos.repository.SpotipposProvinciasRepository;
import br.com.vivareal.spotippos.repository.converter.SavePropriedadeConverter;
import br.com.vivareal.spotippos.web.services.converters.PropertiesFoundResponseConverter;
import br.com.vivareal.spotippos.web.services.converters.PropertyResponseConverter;
import br.com.vivareal.spotippos.web.services.request.SavePropertyRequest;
import br.com.vivareal.spotippos.web.services.response.PropertiesFoundResponse;
import br.com.vivareal.spotippos.web.services.response.PropertyResponse;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

/**
 * Created by dgrodrigo on 10/04/16.
 */
@Path("/properties")
public class SpotipposRestService {

    @Inject
    private SpotipposProvinciasRepository provinciasRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveProperties(@Valid SavePropertyRequest request) {

        PropriedadeModel model = SavePropriedadeConverter.converter(request);
        provinciasRepository.salvarPropriedade(model);

        return Response.ok().entity(PropertyResponseConverter.converter(model)).build();
    }


    @Path("/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") @NotNull(message = "Por favor informe o ID") Integer id) {

        PropriedadeModel propriedadeModel = provinciasRepository.recuperarPropriedadePorId(id);

        Response response = Response.ok().entity(new PropertyResponse()).build();

        if(propriedadeModel != null) {
            response = Response.ok().entity(PropertyResponseConverter.converter(propriedadeModel)).build();
        }

        return response;
    }


    /**
     *
     * @param upperLeftX
     * @param upperLeftY
     * @param bottomRightX
     * @param bottomRightY
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByLocation(
            @QueryParam("ax")
            @NotNull(message = "{ax.notnull}")
            @Min(value = 0,message = "{ax.min}")
            @Max(value = 1400,message = "{ax.max}")
                    Integer upperLeftX,
            @QueryParam("ay")
            @NotNull(message = "{ay.notnull}")
            @Min(value = 0,message = "{ay.min}")
            @Max(value = 1000,message = "{ay.max}")
                Integer upperLeftY,
            @QueryParam("bx")
            @NotNull(message = "{bx.notnulll}")
            @Min(value = 0,message = "{bx.min}")
            @Max(value = 1400,message = "{bx.max}")
                Integer bottomRightX,
            @QueryParam("by")
            @NotNull(message = "{by.notnull}")
            @Min(value = 0,message = "{by.min}")
            @Max(value = 1000, message = "{by.max}")
                    Integer bottomRightY) {

        CoordenadasModel pontoSuperior = new CoordenadasModel();
        pontoSuperior.setCoordenadaX(upperLeftX);
        pontoSuperior.setCoordenadaY(upperLeftY);

        CoordenadasModel pontoInferior = new CoordenadasModel();
        pontoInferior.setCoordenadaX(bottomRightX);
        pontoInferior.setCoordenadaY(bottomRightY);

        Set<PropriedadeModel> propriedades =  provinciasRepository.recuperarPropriedadesPorCoordenadas(pontoSuperior, pontoInferior);

        Response response = Response.ok().entity(new PropertiesFoundResponse()).build();

        if(propriedades != null && !propriedades.isEmpty()){
            response = Response.ok().entity(PropertiesFoundResponseConverter.converter(propriedades)).build();
        }

        return response;

    }

}
