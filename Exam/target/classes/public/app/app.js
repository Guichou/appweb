
	var app = angular.module('task', ['ngRoute', 'ngResource']);
	
	app.config(function($routeProvider, $locationProvider) {
	  $routeProvider
	   .when('/:userId/tasks', {
	    templateUrl: 'tasks.html',
	    controller: 'TasksController'})
	   .when('/:userId/tasks/create', {
	    templateUrl: 'bookmark-create.html',
	    controller: 'BookmarkCreateController'})
	    					
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
	
	app.controller('BookmarkCreateController', function($scope, $routeParams, Bookmark) {
	     $scope.name = "BookmarkCreateController";
	     $scope.params = $routeParams;
	     
	     var bookmark = new Bookmark({userId:$scope.params.userId});
	     bookmark.uri = "bidon";
	     bookmark.description = "complete";
	     bookmark.$save();
	 });
	