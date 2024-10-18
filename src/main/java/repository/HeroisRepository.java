package repository;

import model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HeroisRepository extends  JpaRepository< Hero, Long>{



    }
