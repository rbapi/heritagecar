package com.entiros.springbootrestapiprojects.oauth.repository;

import com.entiros.springbootrestapiprojects.oauth.model.Account;
import com.entiros.springbootrestapiprojects.oauth.model.HeritageCar;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepository extends CrudRepository<Account, String> {
    public Account findById(String id);

    public Account deleteById(String id);
}

