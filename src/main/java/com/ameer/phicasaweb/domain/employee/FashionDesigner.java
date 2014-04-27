/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.domain.employee;

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
public class FashionDesigner implements Serializable, Employee {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;  
    private Double salary;

   private FashionDesigner(){
        
    }
    
    private FashionDesigner(Builder build){
        
        id = build.id;
        name = build.name;
        surname = build.surname;
        salary = build.salary;        
    }
    
    public static class Builder{
        
        private Long id;
        private String name;
        private String surname; 
        private Double salary;
        
        public Builder(String empName){
            this.name = empName;
        }
        
        public Builder id(Long empID){
            id = empID;
            return this;
        }
        
        public Builder surname(String empSurname){
            surname = empSurname;
            return this;
        }
        
        public Builder salary(Double sal){
            salary = sal;
            return this;
        }
        
        public FashionDesigner build(){
            return new FashionDesigner(this);
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

    public Double getSalary() {
        return salary;
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
        if (!(object instanceof FashionDesigner)) {
            return false;
        }
        FashionDesigner other = (FashionDesigner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.phicasaweb.domain.employee.FashionDesigner[ id=" + id + " ]";
    }
    
}
