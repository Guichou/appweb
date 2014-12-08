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
	// .when('/:userId/tasks/:bookmarkId', {
	// templateUrl: 'bookmark.html',
	// controller: 'BookmarkController'})

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
	// $scope.name = "TasksController"; //n'a aucune influence
	$scope.params = $routeParams;
	$scope.tasks = Task.query();// problem here
});

// app.controller('BookmarkController', function($scope, $routeParams) {
// $scope.name = "BookmarkController";
// $scope.params = $routeParams;
// });
//	
app.controller('TaskCreateController', function($scope, Task) {
	$scope.task = new Task();

	$scope.createTask = function() {

		$scope.task.$save();
		window.location.replace("/#/tasks");
		

	};
});

app.controller('TaskUpdateController', function($scope, $routeParams, Task) {
	$scope.task = new Task();
	$scope.params = $routeParams;

	$scope.updateTitle = function(task) {
		task.id = $routeParams.taskId;
		$scope.task.$update();
		window.location.replace("/#/tasks");

	};
});
