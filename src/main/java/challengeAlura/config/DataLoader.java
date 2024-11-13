package challengeAlura.config;

import challengeAlura.repository.HeroisRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import challengeAlura.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.io.IOException;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private HeroisRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Hero>> typeReference = new TypeReference<List<Hero>>() {};
            System.out.println("Iniciando o carregamento de dados...");

            try {
                // carregar o arquivo hero.json do classpath
                InputStream inputStream = new ClassPathResource("hero.json").getInputStream();
                List<Hero> heros = mapper.readValue(inputStream, typeReference);
                System.out.println("Dados carregados com sucesso!");
                repository.saveAll(heros);
            } catch (IOException e) {
                System.err.println("Erro ao carregar o arquivo hero.json: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Heróis já carregados no banco de dados.");
        }
    }
}
