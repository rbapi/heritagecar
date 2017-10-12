package com.entiros.springbootrestapiprojects.oauth.service;


import com.entiros.springbootrestapiprojects.oauth.model.Consent;

public interface ConsentService {
    Iterable<Consent> listAllConsents();

    Consent getConsentById(String id);

    Consent saveConsents(Consent consent);

    void deleteConsentById(String ConsentId);
}
