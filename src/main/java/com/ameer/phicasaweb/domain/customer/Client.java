/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.domain.customer;

import com.ameer.phicasaweb.domain.embeddables.Contact;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Scrappy
 */
@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String name;
    private String surname;
    private String rank;
    private Double spending;
    private String email;
    
    @Embedded
    private Contact contact;
    
    private Client(){
        
    }
    
    private Client(Builder build){
        
        id = build.id;
        name = build.name;
        surname = build.surname;
        rank = build.rank;
        spending = build.spending;
        email = build.email;
        contact = build.contact;      
    }
    
    public static class Builder{
        
        private Long id;    
        private String name;
        private String surname;
        private String rank;        
        private Double spending;
        private String email;
        private Contact contact;
        
        public Builder(String name){
            this.name = name;
        }
        
        public Builder id(Long value) {
            id = value;
            return this;
        }
        
        public Builder name(String value) {
            name = value;
            return this;
        }
        
        public Builder surname(String value) {
            surname = value;
            return this;
        }
        
        public Builder rank(String value){
            rank = value;
            return this;
        }
        
        public Builder spend(Double value){
            spending = value;
            return this;
        }
        
        public Builder email(String value){
            email = value;
            return this;
        }
        
        public Builder contact(Contact value){
            contact = value;
            return this;
        }
        
        public Builder client(Client client){
            id = client.getId();
            name = client.getName();
            surname = client.getSurname();
            rank = client.getRank();
            spending = client.getSpending();
            email = client.getEmail();
            contact = client.getContact();
            return this;
        }
        
        public Client build(){
            return new Client(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRank() {
        return rank;
    }

    public Double getSpending() {
        return spending;
    }

    public String getEmail() {
        return email;
    }

    public Contact getContact() {
        return contact;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.phicasaweb.domain.customer.Client[ id=" + id + " ]";
    }
    
}
