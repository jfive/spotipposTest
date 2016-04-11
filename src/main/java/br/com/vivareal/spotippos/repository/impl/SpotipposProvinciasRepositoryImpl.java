package br.com.vivareal.spotippos.repository.impl;

import br.com.vivareal.spotippos.exceptions.SpotipposPersistenceException;
import br.com.vivareal.spotippos.model.commons.CoordenadasModel;
import br.com.vivareal.spotippos.model.propriedades.PropriedadeModel;
import br.com.vivareal.spotippos.model.provincias.ProvinciaModel;
import br.com.vivareal.spotippos.repository.SpotipposProvinciasRepository;
import br.com.vivareal.spotippos.util.CoordenadasUtil;
import com.google.common.collect.Range;

import javax.inject.Singleton;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dgrodrigo on 10/04/16.
 */
@Singleton
public class SpotipposProvinciasRepositoryImpl implements SpotipposProvinciasRepository {

    private static final long serialVersionUID = 3193902140266034997L;

    private transient List<ProvinciaModel> provincias;

    public SpotipposProvinciasRepositoryImpl() {
        provincias = new ArrayList<>();
    }

    @Override
    public void salvarProvincia(ProvinciaModel provincia) {
        if (provincias.stream().parallel().noneMatch(p -> p.equals(provincia))) {
            provincias.add(provincia);
        } else {
            throw new SpotipposPersistenceException("provincia ja cadastrada em Spotippos");
        }
    }


    @Override
    public List<ProvinciaModel> recuperarTodas() {
        return provincias;
    }

    @Override
    public List<ProvinciaModel> recuperarProvinciasDeUmaPropriedade(PropriedadeModel propriedadeModel) {
        return provincias.stream()
                .parallel()
                .filter(p -> p.isProvincia(propriedadeModel))
                .sequential()
                .collect(Collectors.toList());
    }


    @Override
    public Set<PropriedadeModel> recuperarPropriedadesPorCoordenadas(CoordenadasModel pontoSuperiorEsquerdo, CoordenadasModel pontoInferiorDireito) {

        List<ProvinciaModel> provinciasList = this.provincias.stream()
                .parallel()
                .filter(p -> p.isProvincia(pontoSuperiorEsquerdo, pontoInferiorDireito))
                .sequential()
                .collect(Collectors.toList());

        List<PropriedadeModel> propriedades = provinciasList.stream()
                .parallel()
                .flatMap(p -> p.getPropriedades().stream())
                .filter(pro -> {

                    Range<Integer> rangeX = CoordenadasUtil.gerarRangeCoordenadas(pontoSuperiorEsquerdo.getCoordenadaX(), pontoInferiorDireito.getCoordenadaX());
                    Range<Integer> rangeY = CoordenadasUtil.gerarRangeCoordenadas(pontoSuperiorEsquerdo.getCoordenadaY(), pontoInferiorDireito.getCoordenadaY());

                    CoordenadasModel localizacao = pro.getLocalizacao();

                    return rangeX.contains(localizacao.getCoordenadaX()) && rangeY.contains(localizacao.getCoordenadaY());

                }).collect(Collectors.toList());

        return new HashSet<>(propriedades);
    }


    @Override
    public void salvarPropriedade(PropriedadeModel propriedadeModel) {

        List<ProvinciaModel> provinciasList = recuperarProvinciasDeUmaPropriedade(propriedadeModel);

        provinciasList.stream().forEach(p -> {

            if(propriedadeModel.getId() == null) {
                Integer id = getNextId();
                propriedadeModel.setId(id);
            }

            propriedadeModel.setProvincias(provinciasList.stream().map(ProvinciaModel::getNome).collect(Collectors.toList()));
            p.getPropriedades().add(propriedadeModel);
        });
    }

    private Integer getNextId() {

        List<PropriedadeModel> propriedades = provincias.stream()
                .parallel()
                .flatMap(p -> p.getPropriedades().stream())
                .sorted(Comparator.comparingInt(PropriedadeModel::getId))
                .collect(Collectors.toList());

        Integer id = 1;
        if(propriedades != null && !propriedades.isEmpty()){
            id = propriedades.get(propriedades.size() - 1).getId();
            id += 1;
        }
        return id;
    }


    @Override
    public PropriedadeModel recuperarPropriedadePorId(final Integer id) {
        return provincias.stream()
                .parallel()
                .flatMap(p -> p.getPropriedades().stream())
                .filter(pro -> pro.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


}
