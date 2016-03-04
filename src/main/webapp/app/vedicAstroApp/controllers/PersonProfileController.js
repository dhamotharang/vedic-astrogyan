(function() {

	'use strict';

	var node = {
		name : '',
		children : [],
		predictions : ''
	};
	angular.module('vedicAstroApp').controller('PersonProfileController',
			PersonProfileController);
	PersonProfileController.$inject = ['$rootScope','$scope','ProfileService'];

	function PersonProfileController($rootScope, $scope, ProfileService) {
		$scope.panelTitle = '< Personal Profile >';
			
		$scope.aspects = [];
	
		(function init() {
			loadMemberProfile();
		})();

		function loadMemberProfile() {
			var filter = {
					filterType : 'MemberAnalysis',
					filterValue : $rootScope.globals.currentUser.memberId,
					model : $scope.predictionSystem,
					analysisGroup : $scope.analysisGroup 
				};
				ProfileService.getFilteredProfile(filter).then(function(aspects) {
					$scope.aspects = aspects;
				});
		}
		
	};

}());
