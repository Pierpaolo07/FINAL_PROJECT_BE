package com.ElvanoSablone.workshop.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workings")
public class Working {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column ( name = "description_w", nullable = false)
    private String description;
    @Column ( name = "processing_hours", nullable = false)
    private long processingHours;

    @Column ( name = "price_hours", nullable = false)
    private double priceHours;

    @Column (name = "processing_status")
    private int processingStatus;

    @ManyToOne()
    @JoinColumn(name = "order_product_id", nullable = false)
    //@OnDelete(action= OnDeleteAction.CASCADE)
    private OrderProduct orderProduct;

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

    public int getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(int processingStatus) {
        this.processingStatus = processingStatus;
    }

    public double getPriceHours() {
        return priceHours;
    }

    public void setPriceHours(double priceHours) {
        this.priceHours = priceHours;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }
}
