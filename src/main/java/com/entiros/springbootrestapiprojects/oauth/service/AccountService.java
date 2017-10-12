package com.entiros.springbootrestapiprojects.oauth.service;

import com.entiros.springbootrestapiprojects.oauth.model.Account;

public interface AccountService {

    Iterable<Account> listAllAccounts();

    Account getAccountById(String id);

    Account saveAccounts(Account account);

    void deleteAccountById(String AccountId);

}
