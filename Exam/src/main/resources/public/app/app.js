var app = angular.module('task', [ 'ngRoute', 'ngResource' ]);

app.config(function($routeProvider, $locationProvider) {
	$routeProvider

//	.when('/tasks/create', {
//		templateUrl : 'task-create.html',
//		controller : 'TaskCreateController'
//	})
//
//	.when('/tasks/:taskId', {
//		templateUrl : 'task.html',
//		controller : 'TaskController'
//	})

	.when('/tasks', {
		templateUrl : 'tasks.html',
		controller : 'TasksController'
	})
});

app.factory('Task', [ '$resource', function($resource) {
	return $resource('/tasks/:taskId', {
		taskId : '@taskId'
	});
} ]);

app.controller('TasksController', function($scope, $routeParams, Task) {
	alert();
	$scope.params = $routeParams;
	$scope.tasks = Task.query();
});

//app.controller('TaskController', function($scope, Task) {
//	$scope.name = "TaskController";
//	$scope.task = Task.query();
//});
//
//app.controller('TaskCreateController', function($scope, Task) {
//	$scope.task = new Task();
//
//	$scope.createTask = function() {
//
//		$scope.task.$save();
//
//	};
//});
