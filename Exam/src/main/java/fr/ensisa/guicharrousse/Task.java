package fr.ensisa.guicharrousse;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

    
    @Id
    @GeneratedValue
    private Long id;
    
    public String title;
    public boolean finished;
    Task() { // jpa only
    }

    public Task(String title, boolean isFinished) {
        this.title = title;
        this.finished = isFinished;
      
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isFinished() {
        return this.finished;
    }
}