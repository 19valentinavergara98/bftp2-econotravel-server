package com.econotravel.api;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="experiences")
public class Experience{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double price;

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

    public String getDescription(){return description;}

    public void setDescription(String description){this.description=description;}

    public double getPrice() {return price;
    }

    public void setPrice(double price) {this.price = price;
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
    public Experience( String name,String description,double price, String duration, String tag ) {
        this.name = name;
        this.description=description;
        this.price = price;
        this.duration = duration;
        this.tag = tag;


        }
    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", duration='" + duration + '\'' +
                ", tag'" + tag + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience experience = (Experience) o;
        return Objects.equals(id, experience.id) && Objects.equals(name, experience.name) && Objects.equals(description, experience.description) && Objects.equals(price, experience.price) && Objects.equals(duration, experience.duration) && Objects.equals(tag, experience.tag);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, duration, tag);
    }
}

