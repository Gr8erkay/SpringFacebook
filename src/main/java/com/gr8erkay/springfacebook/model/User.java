package com.gr8erkay.springfacebook.model;

import com.gr8erkay.springfacebook.model.Friend;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String emailAddress;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String dateOfBirth;
    @Column(nullable = false)
    private String gender;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Friend> friendList;

}
