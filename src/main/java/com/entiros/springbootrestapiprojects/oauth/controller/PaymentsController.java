package com.entiros.springbootrestapiprojects.oauth.controller;

import com.entiros.springbootrestapiprojects.oauth.model.Payment;
import com.entiros.springbootrestapiprojects.oauth.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


public class PaymentsController {
    private PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //----------Get All Payments-----------

    @ApiOperation(value = "Display a list of all Payments available", response = Payment.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the list of all Payment in the inventory"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/payments")
    public Iterable<Payment> list(Model model) {
        Iterable<Payment> paymentList = paymentService.listAllPayments();
        return paymentList;
    }

    //----------Get an Payment by ID-----------
    @ApiOperation(value = "Display information of PAyment corresponding to a specific ID", response = Payment.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the Payment Information for the requested ID"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/payments/{id}")
    public ResponseEntity showPayment(@PathVariable("id") String id) {

        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            return new ResponseEntity("No Payment found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(payment, HttpStatus.OK);
    }

    //----------Add a new  Payment to the Inventory-----------
    @ApiOperation(value = "Add a new Payment ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Added a new Payment"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping("/payments")
    public ResponseEntity savePayments(@RequestBody Payment payments) {
        paymentService.savePayments(payments);
        return new ResponseEntity("Payment saved successfully", HttpStatus.OK);
    }


    //----------Update an existing Payment -----------------------------
    @ApiOperation(value = "Update a Payment", response = Payment.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated an existing Payment"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @PutMapping(value = "/payments/{id}")
    public ResponseEntity updatePayment(@PathVariable String id, @RequestBody Payment payment) {

        Payment currentPayment = paymentService.getPaymentById(id);
        if (currentPayment == null) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
        currentPayment.setId(payment.getId());

        paymentService.savePayments(currentPayment);

        return new ResponseEntity("Payment information updated successfully", HttpStatus.OK);

    }
    //----------Delete Payment---------------------------

    @ApiOperation(value = "Delete a Payment", response = Payment.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/payments/{id}")
    public ResponseEntity deletePayment(@PathVariable String id) {

        paymentService.deletePaymentById(id);


        return new ResponseEntity("Payment deleted successfully", HttpStatus.OK);

    }
}
