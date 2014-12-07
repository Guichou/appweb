
	var app = angular.module('task', ['ngRoute', 'ngResource']);
	
	app.config(function($routeProvider, $locationProvider) {
	  $routeProvider
	   .when('/:userId/tasks', {
	    templateUrl: 'tasks.html',
	    controller: 'TasksController'})
	   .when('/:userId/tasks/create', {
	    templateUrl: 'task-create.html',
	    controller: 'TaskCreateController'})
	    					
	   .when('/:userId/tasks/:bookmarkId', {
	    templateUrl: 'bookmark.html',
	    controller: 'BookmarkController'})
	    
	    
	});
	
	
	app.factory('Task', ['$resource', function($resource) {//ici Bookmark -> Task
		return $resource('/:userId/tasks/:bookmarkId',
	    		 {userId:'@userId', bookmarkId:'@bookmarkId'
	    });
	}]);

	 
	app.controller('TasksController', function($scope, $routeParams, Task) {//ici Bookmark -> Task
	     $scope.name = "TasksController"; //n'a aucune influence
	     $scope.params = $routeParams;	     
	     $scope.tasks = Task.query({userId:$scope.params.userId});//ici Bookmark -> Task
	 });
	
	app.controller('BookmarkController', function($scope, $routeParams) {
	     $scope.name = "BookmarkController";
	     $scope.params = $routeParams;
	 });
	
	app.controller('TaskCreateController', function($scope, Task) {
	     $scope.task = new Task();
	
		$scope.createTask = function(){
		
			$scope.task.$save();
			console.log("hello");
			
		};
	 });
	