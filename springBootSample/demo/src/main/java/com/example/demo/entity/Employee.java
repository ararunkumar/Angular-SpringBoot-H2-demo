package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;
    
    private String firstName;
    
    private int coins; 
       
   public String getFirstName(){
       return firstName;
   }

   void setFirstName(String firstName){
       this.firstName = firstName;
   }
   public int getCoins(){
    return coins;
}

void setCoins(int coins){
    this.coins = coins;
}
}