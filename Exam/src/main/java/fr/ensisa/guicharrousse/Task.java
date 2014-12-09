package fr.ensisa.guicharrousse;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    
	private String title;
	private boolean finished;
	
    public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

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