package fr.ensisa.guicharrousse;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/tasks")
class TaskRestController {
	
	//@Autowired
	private final TaskRepository taskRepository;

//
//	@RequestMapping(method = RequestMethod.POST)
//	void add(@PathVariable String userId, @RequestBody Task input) {
//		// Mapping avec l'objet
//		
//		taskRepository.save(new Task(input.title, false));
//
//		}
	
	@RequestMapping(method = RequestMethod.GET)
	Collection<Task> readTasks() {
		System.out.println(this.taskRepository.findAll().toString());
		return this.taskRepository.findAll();
	}

//	@RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
//	Task readTask(@PathVariable Long id) {
//		System.out.println(this.taskRepository.findOne(id).getTitle());
//		return this.taskRepository.findOne(id);
//	}
	

	

	@Autowired
	TaskRestController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
}