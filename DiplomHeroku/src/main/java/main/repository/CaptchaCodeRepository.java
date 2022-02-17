package main.repository;

import main.model.entities.CaptchaCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptchaCodeRepository extends CrudRepository<CaptchaCode, Integer> {
    @Query(value = "select code" +
            "         from CaptchaCode p" +
            "        where p.secretCode = ?1")
    String getCaptchaCode(String secret_code);
}