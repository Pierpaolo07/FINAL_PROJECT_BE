package com.ElvanoSablone.workshop.persistence.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "order_products")
public class OrderProduct {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    //@OnDelete(action= OnDeleteAction.CASCADE)
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    //@OnDelete(action= OnDeleteAction.CASCADE)
    private Product product;

    @Column (name = "quantity", nullable = false)
    private long quantity;

    @OneToMany(mappedBy = "orderProduct")
    private List<Working> workings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public List<Working> getWorkings() {
        return workings;
    }

    public void setWorkings(List<Working> workings) {
        this.workings = workings;
    }
}
