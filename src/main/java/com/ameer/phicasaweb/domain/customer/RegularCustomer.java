/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.domain.customer;

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
public class RegularCustomer implements Serializable, Customer {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Double paid;

    private RegularCustomer(){
        
    }
    
    private RegularCustomer(Builder build){
        id = build.id;
        name = build.name;
        surname = build.surname;
        paid = build.paid;
    }
    
    public static class Builder{
        
        private Long id;    
        private String name;
        private String surname;  
        private Double paid; 
        
        public Builder(String cusName){
            this.name = cusName;
        }
    
        public Builder id(Long cusID){
            id = cusID;
            return this;
        }
        
        public Builder surname(String CusSurname){
            surname = CusSurname;
            return this;
        }    
        
        public Builder paid(Double p){
            paid = p;
            return this;
        }
        
        public RegularCustomer build(){
            return new RegularCustomer(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }
    
    public Double getPaid() {
        return paid;
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
        if (!(object instanceof RegularCustomer)) {
            return false;
        }
        RegularCustomer other = (RegularCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.phicasaweb.domain.customer.RegularCustomer[ id=" + id + " ]";
    }
    
}
