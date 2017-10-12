package com.entiros.springbootrestapiprojects.oauth.repository;

import com.entiros.springbootrestapiprojects.oauth.model.Account;
import com.entiros.springbootrestapiprojects.oauth.model.Consent;
import org.springframework.data.repository.CrudRepository;

public interface ConsentsRespository extends CrudRepository<Consent, String> {
    public Consent findById(String id);

    public Consent deleteById(String id);
}
