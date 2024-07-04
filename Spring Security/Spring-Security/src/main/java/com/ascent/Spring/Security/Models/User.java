package com.ascent.Spring.Security.Models;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

        @Id
        private String username;
        private String password;
        private String email;
        private String role;

       //Used Lombok so no need to add Setters and Getters method
    }



