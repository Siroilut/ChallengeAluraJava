package challengeAlura.repository;

import challengeAlura.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HeroisRepository extends  JpaRepository< Hero, Long>{

@Query("SELECT s FROM Hero s WHERE LOWER(s.poderes) LIKE LOWER (CONCAT('%', :poderes, '%'))")
    List<Hero> findByPoderesContaining(@Param("poderes")String poderes);

    List<Hero> findByPoderesContainingIgnoreCase(String poderes);

}
