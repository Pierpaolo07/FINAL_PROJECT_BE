package com.ElvanoSablone.workshop.persistence.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_pr")
    private String name;

    @Column(name = "description_pr")
    private String description;

    @Column(name = "price_pr")
    private long price;

    @Column(name = "cover", columnDefinition = "MEDIUMBLOB")
    @Lob
    private byte[] cover;

    @OneToMany(mappedBy = "product")
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<OrderProduct> orderProducts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
