package br.com.vivareal.spotippos.web.servlets;

import br.com.vivareal.spotippos.core.VivaRealConstants;
import br.com.vivareal.spotippos.model.provincias.ProvinciaModel;
import br.com.vivareal.spotippos.repository.SpotipposProvinciasRepository;
import br.com.vivareal.spotippos.web.servlets.converter.PropriedadesModelConverter;
import br.com.vivareal.spotippos.web.servlets.converter.ProvinceConverter;
import br.com.vivareal.spotippos.web.servlets.importacao.PropriedadesImport;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Created by dgrodrigo on 10/04/16.
 */
@WebServlet(loadOnStartup = 1)
public class CreateRepositoryStartupServlet extends HttpServlet {

    private static final long serialVersionUID = -673233204984736206L;

    private static final Logger LOG = Logger.getLogger(CreateRepositoryStartupServlet.class);

    private final SpotipposProvinciasRepository provinciasRepository;
    private final transient Gson gson;

    @Inject
    public CreateRepositoryStartupServlet(SpotipposProvinciasRepository provinciasRepository) {
        this.provinciasRepository = provinciasRepository;
        this.gson = new Gson();
    }

    @Override
    public void init() throws ServletException {

        inserirProvincias();
        inserirPropriedades();
    }

    private void inserirPropriedades() throws ServletException {

        try{
            /**
             * Criado uma pasta vivareal_home onde deve conter todos os arquivos de propriedades que podem ser alterados
             */
            StringBuilder propertiesJson = lerArquivo(VivaRealConstants.ArquivosConfiguracao.JSON_PROPRIEDADES);
            PropriedadesImport propriedadesImport = gson.fromJson(propertiesJson.toString(), PropriedadesImport.class);

            propriedadesImport.getProperties().forEach(p -> provinciasRepository.salvarPropriedade(PropriedadesModelConverter.converter(p)));

            LOG.info("####### Total Propriedades por provincia");
            provinciasRepository.recuperarTodas().forEach(p -> LOG.info("#### " + p.getNome() + ": " + p.getPropriedades().size()));
            LOG.info("####### Total Propriedades por provincia");

        }catch (Exception e) {
            String message = "erro ao importar base de propriedades";
            LOG.error(message, e);
            throw new ServletException(message);
        }

    }

    private void inserirProvincias() throws ServletException {
        try {



            /**
             * Criado uma pasta vivareal_home onde deve conter todos os arquivos de propriedades que podem ser alterados
             */
            StringBuilder provincesJson = lerArquivo(VivaRealConstants.ArquivosConfiguracao.JSON_PROVINCIAS);

            /**
             * Não foi feito o converter automatico criando uma classe spotippos com as provincias dentro
             * para facilitar a manutenção pois dessa forma podemos adicionar uma nova provincia no arquivo
             * e não será necessário nenhuma mudança de código
             **/
            List<ProvinciaModel> provincias = ProvinceConverter.converter(gson.fromJson(provincesJson.toString(), Map.class));

            provincias.stream().forEach(provinciasRepository::salvarProvincia);

            List<ProvinciaModel> provinciaModels = provinciasRepository.recuperarTodas();
            LOG.info("####### Total Provincias cadastradas: " + provinciaModels.size());
            provinciaModels.stream().forEach(p -> LOG.info("####" + p.getNome()));


        } catch (IOException e) {
            String message = "erro ao importar base de provincias";
            LOG.error(message, e);
            throw new ServletException(message);
        }


    }

    private StringBuilder lerArquivo(String jsonFile) throws IOException {
        Path path = Paths.get(System.getenv().get(VivaRealConstants.NOME_VARIAVEL_AMBIENTE) + "/" + jsonFile);
        StringBuilder provincesJson = new StringBuilder();
        Files.lines(path).forEach(provincesJson::append);

        return provincesJson;
    }

}
