package com.ElvanoSablone.workshop.presentation.dto;

public class WorkingDTO {

    private long id;
    private String description;

    private long processingHours;
    private double priceHours;

    private int processingStatus;

    private long idOrderProduct;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getProcessingHours() {
        return processingHours;
    }

    public void setProcessingHours(long processingHours) {
        this.processingHours = processingHours;
    }

    public double getPriceHours() {
        return priceHours;
    }

    public void setPriceHours(double priceHours) {
        this.priceHours = priceHours;
    }

    public int getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(int processingStatus) {
        this.processingStatus = processingStatus;
    }

    public long getIdOrderProduct() {
        return idOrderProduct;
    }

    public void setIdOrderProduct(long idOrderProduct) {
        this.idOrderProduct = idOrderProduct;
    }
}
