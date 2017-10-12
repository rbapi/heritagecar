package com.entiros.springbootrestapiprojects.oauth.service;


import com.entiros.springbootrestapiprojects.oauth.model.HeritageCar;


public interface HeritageCarService  {


    Iterable<HeritageCar> listAllHeritageCars();

    HeritageCar getHeritageCarById(String id);

    HeritageCar saveHeritageCar(HeritageCar heritageCar);

    /*HeritageCar saveHeritageCarbyId(HeritageCar heritageCarId);*/

    void deleteHeritageCarById(String heritageCarId);

}