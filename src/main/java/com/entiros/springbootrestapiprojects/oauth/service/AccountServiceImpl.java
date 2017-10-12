package com.entiros.springbootrestapiprojects.oauth.service;

        import com.entiros.springbootrestapiprojects.oauth.model.Account;
        import com.entiros.springbootrestapiprojects.oauth.repository.AccountsRepository;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class AccountServiceImpl implements AccountService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private AccountsRepository accountsRepository;

    @Override
    public Iterable<Account> listAllAccounts() {
        logger.debug("listAllAccounts called");
        return accountsRepository.findAll();
    }

    @Override
    public Account getAccountById(String id) {
        logger.debug("getAccountById called");
        return accountsRepository.findById(id);
    }

    @Override
    public Account saveAccounts(Account account) {
        logger.debug("saveAccount called");
        return accountsRepository.save(account);
    }

    @Override
    public void deleteAccountById(String accountId) {
        logger.debug("deleteAccountById called");
        accountsRepository.delete(accountId);

    }


}