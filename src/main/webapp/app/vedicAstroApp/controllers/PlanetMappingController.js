(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('PlanetMappingController',
			PlanetMappingController);

	PlanetMappingController.$inject = [ '$rootScope', '$scope',
			'ProfileService', 'ReferenceDataService'];

	function PlanetMappingController($rootScope, $scope, ProfileService, ReferenceDataService) {
		$scope.aspects = [];
		var vm = this;
		vm.panelTitle = "< Planet Profile Mapping >";
		vm.planets = [];
		vm.vargas = [];
		vm.houses = [];
		vm.naks = [];
		vm.zodiacs = [];

		(function init() {
			loadProfileAspects();
		})();

		function loadProfileAspects() {
			ProfileService.getProfileHierarchy().then(function(aspects) {
				$scope.aspects = aspects;
			});
		};
	}
}());
