package com.entiros.springbootrestapiprojects.oauth.service;

import com.entiros.springbootrestapiprojects.oauth.model.HeritageCar;
import com.entiros.springbootrestapiprojects.oauth.repository.HeritageCarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HeritageCarServiceImpl implements HeritageCarService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private HeritageCarRepository heritageCarRepository;

    @Autowired
    public void setHeritageCarRepository(HeritageCarRepository heritageCarRepository) {
        this.heritageCarRepository = heritageCarRepository;
    }

    @Override
    public Iterable<HeritageCar> listAllHeritageCars() {
        logger.debug("listAllHeritageCars called");
        return heritageCarRepository.findAll();
    }


    @Override
    public HeritageCar getHeritageCarById(String id) {
        logger.debug("getHeritageCarById called");
        return heritageCarRepository.findById(id);
    }

    @Override
    public HeritageCar saveHeritageCar(HeritageCar heritageCar) {
        logger.debug("saveHeritageCar called");
        return heritageCarRepository.save(heritageCar);
    }

    @Override
    public void deleteHeritageCarById(String heritageCarId) {
        logger.debug("deleteHeritageCarById called");
        heritageCarRepository.delete(heritageCarId);

    }


}

