package com.kgisl.sb1.model;
 import org.springframework.data.annotation.Id;


public record Person (@Id Long id, String uname, String email){
   
}