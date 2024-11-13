package challengeAlura.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import challengeAlura.repository.HeroisRepository;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;

@RestController
@RequestMapping("/heros")
public class HeroController {


    @Autowired
    private HeroisRepository heroisRepository;

    @GetMapping()
    public List<Hero> listaHerois() {

        return heroisRepository.findAll();
    }
    @GetMapping("/search")
    public List<Hero> buscarPoderes(@RequestParam String poderes)   {
        return heroisRepository.findByPoderesContainingIgnoreCase(poderes);
    }

    @PostMapping()
    public List<Hero> adicionarHero(@RequestBody List<Hero> hero){
        return heroisRepository.saveAll(hero);
    }

    @PutMapping
    public Hero atualizarHero( @RequestBody Hero hero) {
        if (hero.getId() > 0) {
            return heroisRepository.save(hero);
        }
        return null;
    }
    @DeleteMapping
    public String deletarHero(@RequestBody Hero hero){
        if (hero.getId() > 0){
            heroisRepository.delete(hero);
            return "Heroi foi removido com sucesso!";
        }
        return  "Heroi não encontrado!";
    }

}
