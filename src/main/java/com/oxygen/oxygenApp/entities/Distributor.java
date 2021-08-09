package com.oxygen.oxygenApp.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Distributor")
@Table(
        name = "distribution_center",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "distribution_cener_name_unique",
                        columnNames = "institution_name"
                )
        }
)
public class Distributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "distributor_id",
            updatable = false
    )
    private  Integer id;

    @Column(
            name = "institution_name",
            nullable = false
    )
    private String name;


    @Column(
            name = "empty_cylinders_large",
            nullable = false
    )
    private Integer emptyCylindersLarge;

    @Column(
            name = "full_cylinders_large",
            nullable = false
    )
    private Integer fullCylindersLarge;

    @Column(
            name = "empty_cylinders_small",
            nullable = false
    )
    private Integer emptyCylindersSmall;

    @Column(
            name = "full_cylinders_small",
            nullable = false
    )
    private Integer fullCylindersSmall;


    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "distributorId",
            fetch = FetchType.LAZY
    )
    private List<Order> orderList = new ArrayList<>();


    public Distributor(String name,
                       Integer emptyCylindersLarge,
                       Integer fullCylindersLarge,
                       Integer emptyCylindersSmall,
                       Integer fullCylindersSmall)
    {
        this.name = name;
        this.emptyCylindersLarge = emptyCylindersLarge;
        this.fullCylindersLarge = fullCylindersLarge;
        this.emptyCylindersSmall = emptyCylindersSmall;
        this.fullCylindersSmall = fullCylindersSmall;
    }

    public Distributor(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getEmptyCylindersLarge() {
        return emptyCylindersLarge;
    }

    public void setEmptyCylindersLarge(Integer emptyCylindersLarge) {
        this.emptyCylindersLarge = emptyCylindersLarge;
    }

    public Integer getFullCylindersLarge() {
        return fullCylindersLarge;
    }

    public void setFullCylindersLarge(Integer fullCylindersLarge) {
        this.fullCylindersLarge = fullCylindersLarge;
    }

    public Integer getEmptyCylindersSmall() {
        return emptyCylindersSmall;
    }

    public void setEmptyCylindersSmall(Integer emptyCylindersSmall) {
        this.emptyCylindersSmall = emptyCylindersSmall;
    }

    public Integer getFullCylindersSmall() {
        return fullCylindersSmall;
    }

    public void setFullCylindersSmall(Integer fullCylindersSmall) {
        this.fullCylindersSmall = fullCylindersSmall;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrder(Order order)
    {
        if(!this.orderList.contains(order))
        {
            this.orderList.add(order);
//            order.setDistributor(this);
        }
    }

    public void removeOrder(Order order)
    {
        if(this.orderList.contains(order))
        {
            orderList.remove(order);
//            order.setDistributor(null);
        }
    }

    @Override
    public String toString() {
        return "Distributor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emptyCylindersLarge=" + emptyCylindersLarge +
                ", fullCylindersLarge=" + fullCylindersLarge +
                ", emptyCylindersSmall=" + emptyCylindersSmall +
                ", fullCylindersSmall=" + fullCylindersSmall +
                ", orderList=" + orderList.size() +
                '}';
    }
}
