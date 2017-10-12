package com.entiros.springbootrestapiprojects.oauth.service;

import com.entiros.springbootrestapiprojects.oauth.model.Fund;

public interface FundService {
    Iterable<Fund> listAllFunds();

    Fund getFundById(String id);

    Fund saveFund(Fund fund);

    void deleteFundById(String FundId);
}
