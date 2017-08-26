
package com.entiros.springbootrestapiprojects.oauth.controller;

import com.entiros.springbootrestapiprojects.oauth.model.HeritageCar;
import com.entiros.springbootrestapiprojects.oauth.service.HeritageCarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class HeritageCarController {

    private HeritageCarService heritageCarService;

    @Autowired
    public void setHeritageCarService(HeritageCarService heritageCarService) {
        this.heritageCarService = heritageCarService;
    }

    //----------Get All Heritage Cars-----------

    @ApiOperation(value = "Dsiplay a list of all Heritage Cars available", response = HeritageCar.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the list of all Heritage Cars in the inventory"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/heritageCars")
    public Iterable<HeritageCar> list(Model model) {
        Iterable<HeritageCar> heritageCarList = heritageCarService.listAllHeritageCars();
        return heritageCarList;
    }

    //----------Get a Heritage Car by ID-----------
    @ApiOperation(value = "Display information of heritage Car corresponding to a specific ID", response = HeritageCar.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the Heritage Car Information for the requested ID"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/heritageCars/{id}")
    public ResponseEntity showHeriatgeCar(@PathVariable("id") String id) {

        HeritageCar heritageCar = heritageCarService.getHeritageCarById(id);
        if (heritageCar == null) {
            return new ResponseEntity("No Car found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(heritageCar, HttpStatus.OK);
    }

    //----------Add a new  Heritage Car to the Inventory-----------
    @ApiOperation(value = "Add a new Heritage Car to the inventory")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Added a new Heritage Car"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping("/heritageCars")
    public ResponseEntity saveHeritageCar(@RequestBody HeritageCar heritageCar) {
        heritageCarService.saveHeritageCar(heritageCar);
        return new ResponseEntity("Heritage Car saved successfully", HttpStatus.OK);
    }


    //----------Update an existing Heritage Car -----------------------------
    @ApiOperation(value = "Update a Heritage Car", response = HeritageCar.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated an existing Heriatge Car"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @PutMapping(value = "/heritageCars/{id}")
    public ResponseEntity updateHeritageCar(@PathVariable String id, @RequestBody HeritageCar heritageCar) {

        HeritageCar currentHeritageCar = heritageCarService.getHeritageCarById(id);
        if (currentHeritageCar == null) {
            return new ResponseEntity<HeritageCar>(HttpStatus.NOT_FOUND);
        }
        currentHeritageCar.setVolume(heritageCar.getVolume());
        currentHeritageCar.setVariants(heritageCar.getVariants());
        currentHeritageCar.setBody(heritageCar.getBody());
        currentHeritageCar.setEngine(heritageCar.getEngine());
        currentHeritageCar.setProduced(heritageCar.getProduced());

        heritageCarService.saveHeritageCar(currentHeritageCar);

        return new ResponseEntity("Heritage Car information updated successfully", HttpStatus.OK);

    }
    //----------Delete a Heritage Car-----------------------------

    @ApiOperation(value = "Delete a Heritage Car", response = HeritageCar.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/heritageCars/{id}")
    public ResponseEntity deleteHeritageCar(@PathVariable String id) {

        heritageCarService.deleteHeritageCarById(id);


        return new ResponseEntity("Heritage Car deleted successfully", HttpStatus.OK);

    }


}
