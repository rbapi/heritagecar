package com.entiros.springbootrestapiprojects.oauth.controller;

import com.entiros.springbootrestapiprojects.oauth.model.Fund;
import com.entiros.springbootrestapiprojects.oauth.service.FundService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class FundsController {
    private FundService fundService;

    @Autowired
    public void setFundService(FundService fundService) {
        this.fundService = fundService;
    }

    //----------Get All Funds-----------

    @ApiOperation(value = "Display a list of all Funds available", response = Fund.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the list of all Funds in the inventory"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/funds")
    public Iterable<Fund> list(Model model) {
        Iterable<Fund> fundList = fundService.listAllFunds();
        return fundList;
    }

    //----------Get an Fund by ID-----------
    @ApiOperation(value = "Display information of Fund corresponding to a specific ID", response = Fund.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the Fund Information for the requested ID"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/funds/{id}")
    public ResponseEntity showFund(@PathVariable("id") String id) {

        Fund fund = fundService.getFundById(id);
        if (fund == null) {
            return new ResponseEntity("No Fund found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(fund, HttpStatus.OK);
    }

    //----------Add a new  Fund to the Inventory-----------
    @ApiOperation(value = "Add a new Fund ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Added a new Fund"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping("/funds")
    public ResponseEntity saveFunds(@RequestBody Fund fund) {
        fundService.saveFund(fund);
        return new ResponseEntity("Fund saved successfully", HttpStatus.OK);
    }


    //----------Update an existing Fund -----------------------------
    @ApiOperation(value = "Update a Fund", response = Fund.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated an existing Fund"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @PutMapping(value = "/funds/{id}")
    public ResponseEntity updateFund(@PathVariable String id, @RequestBody Fund fund) {

        Fund currentFund = fundService.getFundById(id);
        if (currentFund == null) {
            return new ResponseEntity<Fund>(HttpStatus.NOT_FOUND);
        }
        currentFund.setId(fund.getId());

        fundService.saveFund(currentFund);

        return new ResponseEntity("Fund information updated successfully", HttpStatus.OK);

    }
    //----------Delete an Fund-----------------------------

    @ApiOperation(value = "Delete a Fund", response = Fund.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/funds/{id}")
    public ResponseEntity deleteFund(@PathVariable String id) {

        fundService.deleteFundById(id);


        return new ResponseEntity("Fund deleted successfully", HttpStatus.OK);

    }
}
