package dev.harshita.AuthService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    private String password;
    @ManyToMany
    private List<Role> roles;
}
