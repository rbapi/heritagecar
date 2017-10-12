package com.entiros.springbootrestapiprojects.oauth.repository;

import com.entiros.springbootrestapiprojects.oauth.model.Account;
import com.entiros.springbootrestapiprojects.oauth.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRespository extends CrudRepository<Payment, String> {
    public Payment findById(String id);

    public Payment deleteById(String id);

}
