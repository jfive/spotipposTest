package br.com.vivareal.spotippos;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.vivareal.spotippos.exceptions.SpotipposPersistenceException;
import br.com.vivareal.spotippos.model.commons.CoordenadasModel;
import br.com.vivareal.spotippos.model.propriedades.PropriedadeModel;
import br.com.vivareal.spotippos.model.provincias.ProvinciaFronteiraModel;
import br.com.vivareal.spotippos.model.provincias.ProvinciaModel;
import br.com.vivareal.spotippos.repository.SpotipposProvinciasRepository;
import br.com.vivareal.spotippos.repository.impl.SpotipposProvinciasRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by dgrodrigo on 10/04/16.
 */

public class ProvinciasTest {


    private SpotipposProvinciasRepository provinciasRepository;

    @Before
    public void init() {

        provinciasRepository = new SpotipposProvinciasRepositoryImpl();

        Fixture.of(CoordenadasModel.class).addTemplate("valid", new Rule(){{
            add("coordenadaX", uniqueRandom(0,1400));
            add("coordenadaY", uniqueRandom(0,1000));
        }});

        Fixture.of(ProvinciaFronteiraModel.class).addTemplate("valid", new Rule(){{
            add("coordenadaSuperiorEsquerda", one(CoordenadasModel.class,"valid"));
            add("coordenadaInferiorDireita", one(CoordenadasModel.class,"valid"));
        }});

        Fixture.of(ProvinciaModel.class).addTemplate("valid", new Rule(){{
            add("nome",random("GODE","RUJA","JABY"));
            add("fronteiras", one(ProvinciaFronteiraModel.class,"valid"));
        }});


        // FIXTURE GODE
        Fixture.of(CoordenadasModel.class).addTemplate("godeTopLeft", new Rule(){{
            add("coordenadaX", 0);
            add("coordenadaY", 1000);
        }});

        Fixture.of(CoordenadasModel.class).addTemplate("godeBottomRight", new Rule(){{
            add("coordenadaX", 600);
            add("coordenadaY", 500);
        }});


        Fixture.of(ProvinciaFronteiraModel.class).addTemplate("gode", new Rule(){{
            add("coordenadaSuperiorEsquerda", one(CoordenadasModel.class,"godeTopLeft"));
            add("coordenadaInferiorDireita", one(CoordenadasModel.class,"godeBottomRight"));
        }});

        Fixture.of(ProvinciaModel.class).addTemplate("gode", new Rule(){{
            add("nome",random("GODE"));
            add("fronteiras", one(ProvinciaFronteiraModel.class,"gode"));
        }});

        // FIXTURE Ruja
        Fixture.of(CoordenadasModel.class).addTemplate("rujaTopLeft", new Rule(){{
            add("coordenadaX", 400);
            add("coordenadaY", 1000);
        }});

        Fixture.of(CoordenadasModel.class).addTemplate("rujaBottomRight", new Rule(){{
            add("coordenadaX", 1100);
            add("coordenadaY", 500);
        }});

        Fixture.of(ProvinciaFronteiraModel.class).addTemplate("ruja", new Rule(){{
            add("coordenadaSuperiorEsquerda", one(CoordenadasModel.class,"rujaTopLeft"));
            add("coordenadaInferiorDireita", one(CoordenadasModel.class,"rujaBottomRight"));
        }});

        Fixture.of(ProvinciaModel.class).addTemplate("ruja", new Rule(){{
            add("nome",random("RUJA"));
            add("fronteiras", one(ProvinciaFronteiraModel.class,"ruja"));
        }});

        // FIXTURE Jaby
        Fixture.of(CoordenadasModel.class).addTemplate("jabyTopLeft", new Rule(){{
            add("coordenadaX", 1100);
            add("coordenadaY", 1000);
        }});

        Fixture.of(CoordenadasModel.class).addTemplate("jabyBottomRight", new Rule(){{
            add("coordenadaX", 1400);
            add("coordenadaY", 500);
        }});

        Fixture.of(ProvinciaFronteiraModel.class).addTemplate("jaby", new Rule(){{
            add("coordenadaSuperiorEsquerda", one(CoordenadasModel.class,"jabyTopLeft"));
            add("coordenadaInferiorDireita", one(CoordenadasModel.class,"jabyBottomRight"));
        }});

        Fixture.of(ProvinciaModel.class).addTemplate("jaby", new Rule(){{
            add("nome",random("jaby"));
            add("fronteiras", one(ProvinciaFronteiraModel.class,"jaby"));
        }});

        // FIXTURE Scavy
        Fixture.of(CoordenadasModel.class).addTemplate("scavyTopLeft", new Rule(){{
            add("coordenadaX", 0);
            add("coordenadaY", 500);
        }});

        Fixture.of(CoordenadasModel.class).addTemplate("scavyBottomRight", new Rule(){{
            add("coordenadaX", 600);
            add("coordenadaY", 0);
        }});

        Fixture.of(ProvinciaFronteiraModel.class).addTemplate("scavy", new Rule(){{
            add("coordenadaSuperiorEsquerda", one(CoordenadasModel.class,"scavyTopLeft"));
            add("coordenadaInferiorDireita", one(CoordenadasModel.class,"scavyBottomRight"));
        }});

        Fixture.of(ProvinciaModel.class).addTemplate("scavy", new Rule(){{
            add("nome",random("scavy"));
            add("fronteiras", one(ProvinciaFronteiraModel.class,"scavy"));
        }});

        // FIXTURE Groola
        Fixture.of(CoordenadasModel.class).addTemplate("groolaTopLeft", new Rule(){{
            add("coordenadaX", 600);
            add("coordenadaY", 500);
        }});

        Fixture.of(CoordenadasModel.class).addTemplate("groolaBottomRight", new Rule(){{
            add("coordenadaX", 800);
            add("coordenadaY", 0);
        }});

        Fixture.of(ProvinciaFronteiraModel.class).addTemplate("groola", new Rule(){{
            add("coordenadaSuperiorEsquerda", one(CoordenadasModel.class,"groolaTopLeft"));
            add("coordenadaInferiorDireita", one(CoordenadasModel.class,"groolaBottomRight"));
        }});

        Fixture.of(ProvinciaModel.class).addTemplate("groola", new Rule(){{
            add("nome",random("groola"));
            add("fronteiras", one(ProvinciaFronteiraModel.class,"groola"));
        }});

        // FIXTURE Nova
        Fixture.of(CoordenadasModel.class).addTemplate("novaTopLeft", new Rule(){{
            add("coordenadaX", 800);
            add("coordenadaY", 500);
        }});

        Fixture.of(CoordenadasModel.class).addTemplate("novaBottomRight", new Rule(){{
            add("coordenadaX", 1400);
            add("coordenadaY", 0);
        }});

        Fixture.of(ProvinciaFronteiraModel.class).addTemplate("nova", new Rule(){{
            add("coordenadaSuperiorEsquerda", one(CoordenadasModel.class,"novaTopLeft"));
            add("coordenadaInferiorDireita", one(CoordenadasModel.class,"novaBottomRight"));
        }});

        Fixture.of(ProvinciaModel.class).addTemplate("nova", new Rule(){{
            add("nome",random("nova"));
            add("fronteiras", one(ProvinciaFronteiraModel.class,"nova"));
        }});


        // FIXTURE Geral
        Fixture.of(CoordenadasModel.class).addTemplate("geralTopLeft", new Rule(){{
            add("coordenadaX", 0);
            add("coordenadaY", 1400);
        }});

        Fixture.of(CoordenadasModel.class).addTemplate("geralBottomRight", new Rule(){{
            add("coordenadaX", 0);
            add("coordenadaY", 1000);
        }});


        Fixture.of(ProvinciaFronteiraModel.class).addTemplate("geral", new Rule(){{
            add("coordenadaSuperiorEsquerda", one(CoordenadasModel.class,"geralTopLeft"));
            add("coordenadaInferiorDireita", one(CoordenadasModel.class,"geralBottomRight"));
        }});

        Fixture.of(ProvinciaModel.class).addTemplate("geral", new Rule(){{
            add("nome",random("GERAL"));
            add("fronteiras", one(ProvinciaFronteiraModel.class,"geral"));
        }});



        Fixture.of(PropriedadeModel.class).addTemplate("valid", new Rule(){{
            add("id",random(1,50000));
            add("localizacao", one(CoordenadasModel.class,"valid"));
            add("quantidadeQuartos", random(1,5));
            add("quantidadeBanheiros", random(1,4));
            add("metrosQuadrados", random(20, 240));
        }});

    }

    @Test
    public void test_equals_provincia() {

        ProvinciaModel provinciaModel1 = Fixture.from(ProvinciaModel.class).gimme("valid");
        ProvinciaModel provinciaModel2 = provinciaModel1;

        Assert.assertEquals(provinciaModel1, provinciaModel2);

    }

    @Test
    public void test_not_equals_provincia() {

        ProvinciaModel provinciaModel1 = Fixture.from(ProvinciaModel.class).gimme("valid");
        ProvinciaModel provinciaModel2 = Fixture.from(ProvinciaModel.class).gimme("valid");

        Assert.assertNotEquals(provinciaModel1, provinciaModel2);

    }

    @Test
    public void test_save_provincia() {
        int totalProvincias = provinciasRepository.recuperarTodas().size();
        provinciasRepository.salvarProvincia(Fixture.from(ProvinciaModel.class).gimme("valid"));

        Assert.assertTrue(provinciasRepository.recuperarTodas().size() > totalProvincias);
    }


    @Test(expected = SpotipposPersistenceException.class)
    public void test_save_provincia_duplicada() {
        ProvinciaModel provincia = Fixture.from(ProvinciaModel.class).gimme("valid");
        provinciasRepository.salvarProvincia(provincia);
        provinciasRepository.salvarProvincia(provincia);
    }


    @Test
    public void test_recuperar_provincias_de_uma_propriedade() {

        salvarProvincias();

        PropriedadeModel prop = new PropriedadeModel();
        prop.setId(1);
        CoordenadasModel localizacao = new CoordenadasModel();
        localizacao.setCoordenadaX(400);
        localizacao.setCoordenadaY(550);

        prop.setLocalizacao(localizacao);
        prop.setMetrosQuadrados(100);

        List<ProvinciaModel> provinciaModels = provinciasRepository.recuperarProvinciasDeUmaPropriedade(prop);
        Assert.assertFalse(provinciaModels.isEmpty());

    }

    @Test
    public void test_save_propriedade() {

        salvarProvincias();
        PropriedadeModel prop = Fixture.from(PropriedadeModel.class).gimme("valid");
        prop.setId(null);

        provinciasRepository.salvarPropriedade(prop);

    }

    @Test
    public void test_recuperar_propriedade() {

        salvarProvincias();
        PropriedadeModel prop = Fixture.from(PropriedadeModel.class).gimme("valid");
        prop.setId(1);
        provinciasRepository.salvarPropriedade(prop);

        PropriedadeModel propriedadeModel = provinciasRepository.recuperarPropriedadePorId(1);
        Assert.assertNotNull(propriedadeModel);

    }


    @Test
    public void test_nao_encontrar_propriedade() {

        salvarProvincias();
        salvarPropriedades(100);

        PropriedadeModel propriedadeModel = provinciasRepository.recuperarPropriedadePorId(99999999);
        Assert.assertNull(propriedadeModel);

    }

    @Test
    public void test_busca_propriedades_por_pontos() {

        createProvinciaSpotippos();
        salvarPropriedades(4000);

        CoordenadasModel pontoSuperior = new CoordenadasModel();
        pontoSuperior.setCoordenadaX(0);
        pontoSuperior.setCoordenadaY(0);

        CoordenadasModel pontoInferior = new CoordenadasModel();
        pontoInferior.setCoordenadaX(1000);
        pontoInferior.setCoordenadaY(1400);


        Set<PropriedadeModel> propriedades =  provinciasRepository.recuperarPropriedadesPorCoordenadas(pontoSuperior, pontoInferior);
        Assert.assertFalse(propriedades.isEmpty());
    }


    private void salvarProvincias() {
        provinciasRepository.salvarProvincia(Fixture.from(ProvinciaModel.class).gimme("gode"));
        provinciasRepository.salvarProvincia(Fixture.from(ProvinciaModel.class).gimme("ruja"));
        provinciasRepository.salvarProvincia(Fixture.from(ProvinciaModel.class).gimme("geral"));
    }

    Integer index = 1;
    private void salvarPropriedades(int quantidade) {

        List<PropriedadeModel> propriedades = Fixture.from(PropriedadeModel.class).gimme(quantidade,"valid");
        propriedades.forEach(p -> {
            try {
                p.setId(index++);
                provinciasRepository.salvarPropriedade(p);
            }catch (Exception e){
                // tratado o erro pois só estamos querendo gerar uma passa de dados aleatoria
            }
        });
    }

    private void createProvinciaSpotippos() {
        provinciasRepository.salvarProvincia(Fixture.from(ProvinciaModel.class).gimme("gode"));
        provinciasRepository.salvarProvincia(Fixture.from(ProvinciaModel.class).gimme("ruja"));
        provinciasRepository.salvarProvincia(Fixture.from(ProvinciaModel.class).gimme("jaby"));
        provinciasRepository.salvarProvincia(Fixture.from(ProvinciaModel.class).gimme("scavy"));
        provinciasRepository.salvarProvincia(Fixture.from(ProvinciaModel.class).gimme("groola"));
        provinciasRepository.salvarProvincia(Fixture.from(ProvinciaModel.class).gimme("nova"));

    }


}
