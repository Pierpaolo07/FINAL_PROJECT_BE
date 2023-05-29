package com.ElvanoSablone.workshop.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_order", nullable = false)
    private Date dateOrder;

    @Column(name = "date_delivery", nullable = false)
    private Date dateDelivery;

    @Column ( name = "invoice", nullable = false)
    private long invoice;

    @OneToMany(mappedBy = "order")
    //@OnDelete(action= OnDeleteAction.CASCADE)

    private List<OrderProduct> orderProducts;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    //@OnDelete(action= OnDeleteAction.CASCADE)
    private Customer customer;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public long getInvoice() {
        return invoice;
    }

    public void setInvoice(long invoice) {
        this.invoice = invoice;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
