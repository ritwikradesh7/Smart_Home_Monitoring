package com.example.demo2.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users") // Maps to "users" collection in MongoDB
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private int age;
    private String UserID;
    private String Role;


    // Constructors
    public User() {}

    public User(String name, String email, int age,String UserID,String Role) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.UserID=UserID;
        this.Role=Role;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getUserID() { return UserID; }
     public void setUserID(String UserID) { this.UserID = UserID; }

     public String getRole() { return Role; }
     public void setRole(String Role) { this.Role = Role; }
}
