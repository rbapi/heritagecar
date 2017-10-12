package com.entiros.springbootrestapiprojects.oauth.service;

import com.entiros.springbootrestapiprojects.oauth.model.Account;
import com.entiros.springbootrestapiprojects.oauth.model.Consent;
import com.entiros.springbootrestapiprojects.oauth.repository.AccountsRepository;
import com.entiros.springbootrestapiprojects.oauth.repository.ConsentsRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsentServiceImpl implements ConsentService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ConsentsRespository consentsRespository;

    @Override
    public Iterable<Consent> listAllConsents() {
        logger.debug("listAllConsents called");
        return consentsRespository.findAll();
    }

    @Override
    public Consent getConsentById(String id) {
        logger.debug("getConsentById called");
        return consentsRespository.findById(id);
    }

    @Override
    public Consent saveConsents(Consent consent) {
        logger.debug("saveConsent called");
        return consentsRespository.save(consent);
    }

    @Override
    public void deleteConsentById(String consentId) {
        logger.debug("deleteConsentById called");
        consentsRespository.delete(consentId);

    }
}
