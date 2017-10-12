package com.entiros.springbootrestapiprojects.oauth.controller;

import com.entiros.springbootrestapiprojects.oauth.model.Consent;
import com.entiros.springbootrestapiprojects.oauth.service.ConsentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class ConsentsController {
    private ConsentService consentService;

    @Autowired
    public void setConsentService(ConsentService consentService) {
        this.consentService = consentService;
    }

    //----------Get All Consents-----------

    @ApiOperation(value = "Display a list of all Consents available", response = Consent.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the list of all Consents in the inventory"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/consents")
    public Iterable<Consent> list(Model model) {
        Iterable<Consent> consentList = consentService.listAllConsents();
        return consentList;
    }

    //----------Get an Consent by ID-----------
    @ApiOperation(value = "Display information of Consent corresponding to a specific ID", response = Consent.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the Consent Information for the requested ID"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/consents/{id}")
    public ResponseEntity showConsent(@PathVariable("id") String id) {

        Consent consent = consentService.getConsentById(id);
        if (consent == null) {
            return new ResponseEntity("No Consent found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(consent, HttpStatus.OK);
    }

    //----------Add a new  Consent to the Inventory-----------
    @ApiOperation(value = "Add a new Consent ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Added a new Consent"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping("/consents")
    public ResponseEntity saveConsent(@RequestBody Consent consent) {
        consentService.saveConsents(consent);
        return new ResponseEntity("Consent saved successfully", HttpStatus.OK);
    }


    //----------Update an existing Consent -----------------------------
    @ApiOperation(value = "Update an Consent", response = Consent.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated an existing Consent"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @PutMapping(value = "/consents/{id}")
    public ResponseEntity updateConsent(@PathVariable String id, @RequestBody Consent consent) {

        Consent currentConsent = consentService.getConsentById(id);
        if (currentConsent == null) {
            return new ResponseEntity<Consent>(HttpStatus.NOT_FOUND);
        }
        currentConsent.setId(consent.getId());

        consentService.saveConsents(currentConsent);

        return new ResponseEntity("Consent information updated successfully", HttpStatus.OK);

    }
    //----------Delete an Consent-----------------------------

    @ApiOperation(value = "Delete an Consent", response = Consent.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/consents/{id}")
    public ResponseEntity deleteConsent(@PathVariable String id) {

        consentService.deleteConsentById(id);


        return new ResponseEntity("Consent deleted successfully", HttpStatus.OK);

    }



}
