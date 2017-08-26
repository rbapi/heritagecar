package com.entiros.springbootrestapiprojects.oauth.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HeritageCar {


    @ApiModelProperty(value = "This corresponds to the ID of a Heritage Car")
    @Id
    private String id;
    @ApiModelProperty(value = "Variant of the Car")
    private String variants;
    @ApiModelProperty(value = "Produced year of the Car")
    private Integer produced;
    @ApiModelProperty(value = "Volume of the car ")
    private String volume;
    @ApiModelProperty(value = "Body of the Car")
    private String body;
    @ApiModelProperty(value = "Engine Displacement in cc")
    private double engine;

    //Introducing the dummy constructor
    public HeritageCar() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getVariants() {
        return this.variants;
    }

    public void setVariants(String variants) {
        this.variants = variants;
    }

    public Integer getProduced() {
        return this.produced;
    }

    public void setProduced(Integer produced) {
        this.produced = produced;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public double getEngine() {
        return this.engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }
}
