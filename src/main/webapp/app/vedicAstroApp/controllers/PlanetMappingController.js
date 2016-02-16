(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('PlanetMappingController',
			PlanetMappingController);

	PlanetMappingController.$inject = [ 'ProfileService', 'ReferenceDataService'];

	function PlanetMappingController(ProfileService, ReferenceDataService) {
		var vm = this;
		vm.aspects = [];
		vm.panelTitle = '< Planet Profile Mapping >';
		vm.planets = [];
		vm.tableHeaders = ['Aspect','Strength','Observation', 'Time','Benefic'];
		vm.tableData = [{strength:'Low', aspect:'Aspect1'},{strength:'Medium', aspect:'Aspect1'},{strength:'High', aspect:'Aspect1'}];
		vm.timeDependent = [{code:'Y', name:'Yes'},{code:'N', name:'No'}];
		vm.benefic = [{code:'Benefic', name:'Benefic'},{code:'Malefic', name:'Malefic'},{code:'Neutral', name:'Neutral'}];
		
		vm.selectedPlanet = {};
		vm.selectedAspect = {};
	//	vm.mapAspect = mapAspect;

		(function init() {
			loadProfileAspects();
			loadAllPlanets();
		})();

		function loadProfileAspects() {
			ProfileService.getProfileFlat().then(function(aspects) {
				vm.aspects = aspects;
			});
		};
		
		function loadAllPlanets() {
			ReferenceDataService.getData('planets').then(function(planets) {
				vm.planets = planets;
			});
		};
		
	}
}());
