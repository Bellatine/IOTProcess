package com.namng.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;
    String userName;
    String passWord;
    String fullName;
    int status;
    int role;

}
