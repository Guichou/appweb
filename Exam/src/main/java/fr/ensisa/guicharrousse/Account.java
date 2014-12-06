package fr.ensisa.guicharrousse;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
public class Account {

    @OneToMany(mappedBy = "account")
    private Set<Task> tasks = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;

    public Set<Task> getBookmarks() {
        return tasks;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public String password;
    public String username;

    public Account(String name, String password) {
        this.username = name;
        this.password = password;
    }

    Account() { // jpa only
    }
}