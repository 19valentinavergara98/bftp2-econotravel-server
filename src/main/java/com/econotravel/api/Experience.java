package com.econotravel.api;

import javax.persistence.*;

@Entity
@Table(name="experiences")
public class Experience{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String price;

    private String duration;

    private String tag;

    public Experience() {
    }

    public Experience(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getPrice() {return price;
    }

    public void setPrice(String price) {this.price = price;
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String  getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag= tag;
    }
    public Experience( String name,String price, String duration, String tag) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.tag = tag;

        }
    }
