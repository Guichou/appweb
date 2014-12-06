package fr.ensisa.guicharrousse;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

    @JsonIgnore
    @ManyToOne
    private Account account;

    @Id
    @GeneratedValue
    private Long id;

    Task() { // jpa only
    }

    public Task(Account account, String title, boolean isFinished) {
        this.title = title;
        this.isFinished = isFinished;
        this.account = account;
    }

    public String title;
    public boolean isFinished;

    public Account getAccount() {
        return account;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isFinished() {
        return isFinished;
    }
}