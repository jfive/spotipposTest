package br.com.vivareal.spotippos.repository;

import br.com.vivareal.spotippos.model.commons.CoordenadasModel;
import br.com.vivareal.spotippos.model.propriedades.PropriedadeModel;
import br.com.vivareal.spotippos.model.provincias.ProvinciaModel;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public interface SpotipposProvinciasRepository extends Serializable {
    void salvarProvincia(ProvinciaModel provincia);

    List<ProvinciaModel> recuperarTodas();

    List<ProvinciaModel> recuperarProvinciasDeUmaPropriedade(PropriedadeModel propriedadeModel);

    Set<PropriedadeModel> recuperarPropriedadesPorCoordenadas(CoordenadasModel pontoSuperiorEsquerdo, CoordenadasModel pontoInferiorDireito);

    void salvarPropriedade(PropriedadeModel propriedadeModel);

    PropriedadeModel recuperarPropriedadePorId(Integer id);
}
