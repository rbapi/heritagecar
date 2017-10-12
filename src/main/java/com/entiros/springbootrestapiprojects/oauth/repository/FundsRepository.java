package com.entiros.springbootrestapiprojects.oauth.repository;

import com.entiros.springbootrestapiprojects.oauth.model.Account;
import com.entiros.springbootrestapiprojects.oauth.model.Fund;
import org.springframework.data.repository.CrudRepository;

public interface FundsRepository extends CrudRepository<Fund, String>{
    public Fund findById(String id);

    public Fund deleteById(String id);

}
