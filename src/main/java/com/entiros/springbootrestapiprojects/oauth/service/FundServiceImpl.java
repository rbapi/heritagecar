package com.entiros.springbootrestapiprojects.oauth.service;

import com.entiros.springbootrestapiprojects.oauth.model.Consent;
import com.entiros.springbootrestapiprojects.oauth.model.Fund;
import com.entiros.springbootrestapiprojects.oauth.repository.ConsentsRespository;
import com.entiros.springbootrestapiprojects.oauth.repository.FundsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FundServiceImpl implements FundService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private FundsRepository fundsRepository;

    @Override
    public Iterable<Fund> listAllFunds() {
        logger.debug("listAllFunds called");
        return fundsRepository.findAll();
    }

    @Override
    public Fund getFundById(String id) {
        logger.debug("getFundById called");
        return fundsRepository.findById(id);
    }

    @Override
    public Fund saveFund(Fund fund) {
        logger.debug("saveFund called");
        return fundsRepository.save(fund);
    }

    @Override
    public void deleteFundById(String fundId) {
        logger.debug("deleteFundById called");
        fundsRepository.delete(fundId);

    }
}