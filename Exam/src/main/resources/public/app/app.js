
	var app = angular.module('bookmark', ['ngRoute', 'ngResource']);
	
	app.config(function($routeProvider, $locationProvider) {
	  $routeProvider
	   .when('/:userId/bookmarks', {
	    templateUrl: 'bookmarks.html',
	    controller: 'BookmarksController'})
	   .when('/:userId/bookmarks/create', {
	    templateUrl: 'bookmark-create.html',
	    controller: 'BookmarkCreateController'})
	    					
	   .when('/:userId/bookmarks/:bookmarkId', {
	    templateUrl: 'bookmark.html',
	    controller: 'BookmarkController'})
	    
	    
	});
	
	
	app.factory('Bookmark', ['$resource', function($resource) {
		return $resource('/:userId/bookmarks/:bookmarkId',
	    		 {userId:'@userId', bookmarkId:'@bookmarkId'
	    });
	}]);

	 
	app.controller('BookmarksController', function($scope, $routeParams, Bookmark) {
	     $scope.name = "BookmarksController";
	     $scope.params = $routeParams;
	    
	     
	     $scope.bookmarks = Bookmark.query({userId:$scope.params.userId});
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
	