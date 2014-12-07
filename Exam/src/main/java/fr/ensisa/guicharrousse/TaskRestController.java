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
@RequestMapping("/{userId}/tasks")
class TaskRestController {
	
	//@Autowired
	private final TaskRepository taskRepository;

	private final AccountRepository accountRepository;

	// POST /bob/bookmarks
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@PathVariable String userId, @RequestBody Task input) {
		// Mapping avec l'objet
		this.validateUser(userId);
		
		Account a = this.accountRepository.findByUsername(userId);
		Task result = taskRepository.save(new Task(a,input.title, false));

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}

	// GET => /bob/bookmarks/1
	@RequestMapping(value = "/{bookmarkId}", method = RequestMethod.GET)
	Task readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
		this.validateUser(userId);
		return this.taskRepository.findOne(bookmarkId);
	}
	
	// GET => /bob/bookmars
	@RequestMapping(method = RequestMethod.GET)
	Collection<Task> readTasks(@PathVariable String userId) {
		this.validateUser(userId);
		return this.taskRepository.findByAccountUsername(userId);
	}

	@Autowired
	TaskRestController(TaskRepository taskRepository,
			AccountRepository accountRepository) {
		this.taskRepository = taskRepository;
		this.accountRepository = accountRepository;
	}

	private void validateUser(String userId) {

		Account a = this.accountRepository.findByUsername(userId);
		if(a == null)
			throw new UserNotFoundException(userId);
				
	}
}