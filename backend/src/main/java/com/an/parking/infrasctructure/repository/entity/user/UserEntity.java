package com.an.parking.infrasctructure.repository.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
public class UserEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @OneToOne
     private DataAccessEntity dataAccess;
     @Column(name = "name")
     private  String nameUser;
     @Column(name = "lastname")
     private String lastNameUser;


}
