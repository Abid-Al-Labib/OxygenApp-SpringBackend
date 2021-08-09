package com.oxygen.oxygenApp.entities;

import javax.persistence.*;
import java.util.Date;

@Entity( name = "Order" )
@Table( name = "oxygen_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "order_id",
            updatable = false
    )
    private Integer id;

    @Column(
            name = "type",
            updatable = false,
            nullable = false
    )
    private String type;

    @Column(
            name = "size",
            updatable = false,
            nullable = false
    )
    private String size;

    @Column(
            name = "sender",
            updatable = false,
            nullable = false
    )
    private String sender;

    @Column(
            name = "receiver",
            updatable = false,
            nullable = false
    )
    private String receiver;

    @Column(
            name = "quantity",
            updatable = false,
            nullable = false
    )
    private Integer quantity;

    @Column(
            name = "date",
            updatable = false,
            nullable = false
    )
    private String date;

    @Column(
            name = "distributor_id",
            updatable = false,
            nullable = false
    )
    private Integer distributorId;

//    @ManyToOne(
//            fetch = FetchType.LAZY
//    )
//    @JoinColumn(
//        name = "distributor_id",
//        referencedColumnName = "distributor_id",
//        foreignKey = @ForeignKey(
//                name = "customer_order_book_fk"
//        )
//    )
//    private Distributor distributor;


    public Order(String type, String size, String sender, String receiver, Integer quantity, String date, Integer distributorId) {
        this.type = type;
        this.size = size;
        this.sender = sender;
        this.receiver = receiver;
        this.quantity = quantity;
        this.date = date;
        this.distributorId = distributorId;
    }

    public Order(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                ", distributorId=" + distributorId +
                '}';
    }
}
