package challengeAlura.repository;

import challengeAlura.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface HeroisRepository extends  JpaRepository< Hero, Long>{


}
