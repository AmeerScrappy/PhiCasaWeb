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
public class VIPCustomer implements Serializable, Customer {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

    private VIPCustomer(){
        
    }
    
    private VIPCustomer(Builder build){
        id = build.id;
        name = build.name;
        surname = build.surname;
    }
    
    public static class Builder{
        
        private Long id;    
        private String name;
        private String surname;   
        
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
        
        public VIPCustomer build(){
            return new VIPCustomer(this);
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
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VIPCustomer)) {
            return false;
        }
        VIPCustomer other = (VIPCustomer) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "com.ameer.phicasaweb.domain.customer.VIPCustomer[ id=" + id + " ]";
    }
    
}
