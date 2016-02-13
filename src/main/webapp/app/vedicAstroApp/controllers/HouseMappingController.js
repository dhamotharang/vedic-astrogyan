(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('HouseMappingController',
			HouseMappingController);

	HouseMappingController.$inject = ['$scope',
			'ProfileService', 'ReferenceDataService'];

	function PlanetMappingController($scope, ProfileService, ReferenceDataService) {
		$scope.aspects = [];
		var vm = this;
		vm.panelTitle = "< House Profile Mapping >";
		vm.vargas = [];
		vm.houses = [];
		vm.mapHouse = mapHouse;

		(function init() {
			loadProfileAspects();
			loadAllHouses();
			loadAllVargas();
		})();

		function loadProfileAspects() {
			ProfileService.getProfileHierarchy().then(function(aspects) {
				$scope.aspects = aspects;
			});
		};
		
		function loadAllHouses() {
			ReferenceDataService.getData('houses').then(function(houses) {
				vm.houses = houses;
			});
		};
		
		function loadAllVargas() {
			ReferenceDataService.getData('vargas').then(function(vargas) {
				vm.houses = vargas;
			});
		};
	}

}());
