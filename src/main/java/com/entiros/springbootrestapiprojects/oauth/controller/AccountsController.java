package com.entiros.springbootrestapiprojects.oauth.controller;

import com.entiros.springbootrestapiprojects.oauth.model.Account;
import com.entiros.springbootrestapiprojects.oauth.service.AccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class AccountsController {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    //----------Get All Accounts-----------

    @ApiOperation(value = "Display a list of all Accounts available", response = Account.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the list of all Account in the inventory"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/accounts")
    public Iterable<Account> list(Model model) {
        Iterable<Account> accountList = accountService.listAllAccounts();
        return accountList;
    }

    //----------Get an Account by ID-----------
    @ApiOperation(value = "Display information of Account corresponding to a specific ID", response = Account.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the Account Information for the requested ID"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/accounts/{id}")
    public ResponseEntity showAccount(@PathVariable("id") String id) {

        Account account = accountService.getAccountById(id);
        if (account == null) {
            return new ResponseEntity("No Account found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(account, HttpStatus.OK);
    }

    //----------Add a new  Account to the Inventory-----------
    @ApiOperation(value = "Add a new Account ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Added a new Account"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping("/accounts")
    public ResponseEntity saveAccount(@RequestBody Account account) {
        accountService.saveAccounts(account);
        return new ResponseEntity("Account saved successfully", HttpStatus.OK);
    }


    //----------Update an existing Account -----------------------------
    @ApiOperation(value = "Update an Account", response = Account.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated an existing Account"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @PutMapping(value = "/accounts/{id}")
    public ResponseEntity updateAccount(@PathVariable String id, @RequestBody Account account) {

        Account currentAccount = accountService.getAccountById(id);
        if (currentAccount == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        currentAccount.setId(account.getId());

        accountService.saveAccounts(currentAccount);

        return new ResponseEntity("Account information updated successfully", HttpStatus.OK);

    }
    //----------Delete an Account-----------------------------

    @ApiOperation(value = "Delete an Account", response = Account.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity deleteAccount(@PathVariable String id) {

        accountService.deleteAccountById(id);


        return new ResponseEntity("Account deleted successfully", HttpStatus.OK);

    }


}
