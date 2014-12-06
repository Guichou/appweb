(function() {
	var app = angular.module('store-products', [ ]);
	
	app.directive('productTitle', function(){
		return { 
			restrict:'E',
			templateUrl: 'product-title.html'
		};
	});
	
	app.directive('productPanels', function(){
		return { 
			restrict:'E',
			templateUrl: 'product-panels.html',
			controller: function() {
				this.tab = 1;
				this.selectTab = function(_tab){
					this.tab=_tab;
				};
				this.isSelected = function(_tab){
					return this.tab === _tab;
				};
			},
			controllerAs: 'panel'
		};
	});
	
	app.controller("ReviewController", function(){
		this.review = {};
		this.addReview = function(product) {
			product.reviews.push(this.review);
			this.review = {};
		};
	});
	
})();