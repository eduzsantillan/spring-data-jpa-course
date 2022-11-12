package pe.isil.springdatajpademo.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long>{

    Application findByDatabaseAndLanguage(String database,String Language);
    Application findByName(String name);
}
