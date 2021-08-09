package com.oxygen.oxygenApp.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Booth")
@Table(
        name = "booth",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "booth_institution_name_unique",
                        columnNames = "institution_name"

                )
        }
)
public class Booth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "booth_id",
            updatable = false
    )
    private Integer id;

    @Column(
            name = "location",
            nullable = false
    )
    private String location;

    @Column(
            name = "institution_name",
            nullable = false

    )
    private String name;

    @Column(
            name = "manager_name",
            nullable = false
    )
    private String manager;

    @Column(
            name = "phone_number",
            length = 11
    )
    private String phone_number;

    @Column(
            name = "large_cylinder_stock",
            nullable = false
    )
    private Integer largeCylinderStock;

    @Column(
            name = "small_cylinder_stock",
            nullable = false
    )
    private Integer smallCylinderStock;

    @Column(
            name = "type",
            nullable = false,
            updatable = false
    )
    private String type;


    public Booth(String location,
                 String name,
                 String manager,
                 String phone_number,
                 Integer largeCylinderStock,
                 Integer smallCylinderStock,
                 String type)
    {
        this.location = location;
        this.name = name;
        this.manager = manager;
        this.phone_number = phone_number;
        this.largeCylinderStock = largeCylinderStock;
        this.smallCylinderStock = smallCylinderStock;
        this.type = type;
    }

    public Booth(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getLargeCylinderStock() {
        return this.largeCylinderStock;
    }

    public void setLargeCylinderStock(Integer largeCylinderStock) {
        this.largeCylinderStock = largeCylinderStock;
    }

    public Integer getSmallCylinderStock() {
        return smallCylinderStock;
    }

    public void setSmallCylinderStock(Integer smallCylinderStock) {
        this.smallCylinderStock = smallCylinderStock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Booth{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", LargeCylinderStock=" + largeCylinderStock +
                ", smallCylinderStock=" + smallCylinderStock +
                ", type='" + type + '\'' +
                '}';
    }
}
