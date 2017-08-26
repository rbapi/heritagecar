package com.entiros.springbootrestapiprojects.oauth.repository;

import com.entiros.springbootrestapiprojects.oauth.model.HeritageCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource

public interface HeritageCarRepository extends CrudRepository<HeritageCar, String> {

    public HeritageCar findById(String id);

    public HeritageCar deleteById(String id);

//    public HeritageCar savebyId(String id);


}
