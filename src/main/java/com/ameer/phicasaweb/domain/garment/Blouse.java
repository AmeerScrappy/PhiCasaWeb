/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.domain.garment;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Scrappy
 */
@Entity
public class Blouse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String name;
    private String size;
    private String color;
    private String fabric;
    private Double price;
    
    private Blouse(){
        
    }
    
    private Blouse(Builder build){
        name = build.name;
        size = build.size;
        color = build.color;
        fabric = build.fabric;
        price = build.price;
    }
    
    public static class Builder{
        
        private Long id;    
        private String name;
        private String size;
        private String color;
        private String fabric;
        private Double price;
        
        public Builder(String garName){
            this.name = garName;
        }
        
        public Builder garmentID(Long garID){
            id = garID;
            return this;
        }
        
        public Builder garmentSize(String garSize){
            size = garSize;
            return this;
        }
        
        public Builder garmentColor(String garColor){
            color = garColor;
            return this;
        }    
        
        public Builder garmentFabric(String fab){
            fabric = fab;
            return this;
        }
        
        public Builder garmentPrice(Double pr){
            price = pr;
            return this;
        }
        
        public Blouse build(){
            return new Blouse(this);
        }
        
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getFabric() {
        return fabric;
    }
    
    public Double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blouse)) {
            return false;
        }
        Blouse other = (Blouse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.phicasaweb.domain.garment.Blouse[ id=" + id + " ]";
    }
    
}
