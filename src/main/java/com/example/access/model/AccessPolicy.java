package com.example.access.model;
import jakarta.persistence.*;
@Entity
@Table(name="access_policies")
public class AccessPolicy{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String role;
private String action;
private boolean allowed;
public Long getId(){return id;}
public String getRole(){return role;}
public String getAction(){return action;}
public boolean isAllowed(){return allowed;}
public void setId(Long id){this.id=id;}
public void setRole(String role){this.role=role;}
public void setAction(String action){this.action=action;}
public void setAllowed(boolean allowed){this.allowed=allowed;}
}