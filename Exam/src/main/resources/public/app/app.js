var app = angular.module('task', [ 'ngRoute', 'ngResource' ]);

app.config(function($routeProvider, $locationProvider) {
	$routeProvider

	.when('/tasks/create', {
		templateUrl : 'task-create.html',
		controller : 'TaskCreateController'
	}).when('/tasks/update/:taskId', {
		templateUrl : 'task-update.html',
		controller : 'TaskUpdateController'
	}).when('/tasks', {
		templateUrl : 'todo.html',
		controller : 'TasksController'
	})
});

app.factory('Task', [ '$resource', function($resource) {
	return $resource('/tasks/:taskId', {
		taskId : '@taskId'
	}, {
		update : {
			method : 'PUT'
		}
	});
} ]);

app.controller('TasksController', function($scope, $routeParams, Task) {
	$scope.params = $routeParams;
	$scope.tasks = Task.query();
	
	$scope.deleteTask = function(task){
		task.taskId = task.id;
		task.$delete();
		window.setTimeout(function(){location.reload()},1500);
	}
	$scope.updateTaskState = function(task){
		task.finished = !task.finished;
		task.$update();
		window.setTimeout(function(){location.reload()},500);
	}
	
	
});
	
app.controller('TaskCreateController', function($scope, Task) {
	$scope.task = new Task();

	$scope.createTask = function() {

		$scope.task.$save();
		window.setTimeout(function(){window.location.replace("/#/tasks")},2000);
		

	};
});

app.controller('TaskUpdateController', function($scope, $routeParams, Task) {
	$scope.task = new Task();
	$scope.params = $routeParams;

	$scope.updateTitle = function(task) {
		task.id = $routeParams.taskId;
		$scope.task.$update();
		window.setTimeout(function(){window.location.replace("/#/tasks")},2000);

	};
	
});
