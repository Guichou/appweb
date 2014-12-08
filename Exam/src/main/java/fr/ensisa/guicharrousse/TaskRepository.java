package fr.ensisa.guicharrousse;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
