package com.econotravel.api;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "experiences")
public class Experience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Lob
    private String resume;

    @Lob
    private String description;

    private double price;

    private String duration;

    private String tag;
    @Lob
    private String coverImage;


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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTag() {return tag;}

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCoverImage() {return coverImage;}

    public void setCoverImage(String coverImage) {this.coverImage = coverImage;}


    public Experience(String name, String resume, String description, double price, String duration, String tag, String coverImage) {
        this.name = name;
        this.resume= resume;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.tag = tag;
        this.coverImage = coverImage;

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience experience = (Experience) o;
        return Objects.equals(id, experience.id) && Objects.equals(name, experience.name) && Objects.equals(resume, experience.resume) && Objects.equals(description, experience.description) && Objects.equals(price, experience.price) && Objects.equals(duration, experience.duration) && Objects.equals(tag, experience.tag) && Objects.equals(coverImage, experience.coverImage);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, resume, description, price, duration, tag, coverImage);
    }
}
