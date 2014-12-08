package fr.ensisa.guicharrousse;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
class TaskRestController {
	
	//@Autowired
	private final TaskRepository taskRepository;
	
		// PUT
		@RequestMapping(method = RequestMethod.PUT)
		void update(@RequestBody Task input,@PathVariable Long taskId) {
			//Task t = taskRepository.getOne(taskId);
			taskRepository.delete(taskRepository.getOne(taskId));
			System.out.println("deleted");
			//t.setTitle(input.getTitle());
			taskRepository.save(input);
		}
		// POST
		@RequestMapping(method = RequestMethod.POST)
		void add(@RequestBody Task input) {
			taskRepository.save(new Task(input.getTitle(), false));
			System.out.println("added");
	
		}
	
	

//	// GET => /bob/bookmarks/1
//	@RequestMapping(value = "/{bookmarkId}", method = RequestMethod.GET)
//	Task readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
//		this.validateUser(userId);
//		return this.taskRepository.findOne(bookmarkId);
//	}
//	
	// GET => /bob/bookmars
	@RequestMapping(method = RequestMethod.GET)
	Collection<Task> readTasks() {
		System.out.println(this.taskRepository.findAll());
		return this.taskRepository.findAll();//problem here
	}

	@Autowired
	TaskRestController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
		//this.accountRepository = accountRepository;
	}

//	private void validateUser(String userId) {
//
//		Account a = this.accountRepository.findByUsername(userId);
//		if(a == null)
//			throw new UserNotFoundException(userId);
//				
//	}
}