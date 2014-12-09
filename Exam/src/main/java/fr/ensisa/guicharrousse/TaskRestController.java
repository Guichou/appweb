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

	// @Autowired
	private final TaskRepository taskRepository;

	// PUT
	@RequestMapping(method = RequestMethod.PUT)
	void update(@RequestBody Task input) {
		this.taskRepository.delete(this.taskRepository.findOne(input.getId()));
		this.taskRepository.save(input);
	}

	// POST
	@RequestMapping(method = RequestMethod.POST)
	void add(@RequestBody Task input) {
		taskRepository.save(new Task(input.getTitle(), false));
	}

	// DELETE
	@RequestMapping(value="/{taskId}",method = RequestMethod.DELETE)
	void delete(@PathVariable Long taskId) {
		System.out.println("deleted");
		taskRepository.delete(taskId);
	}

	//GET ALL
	@RequestMapping(method = RequestMethod.GET)
	Collection<Task> readTasks() {
		return this.taskRepository.findAll();
	}

	@Autowired
	TaskRestController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
}