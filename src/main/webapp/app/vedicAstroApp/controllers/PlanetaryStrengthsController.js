(function() {
	'use strict';

	angular.module('vedicAstroApp').controller('PlanetaryStrengthsController',
			PlanetaryStrengthsController);

	PlanetaryStrengthsController.$inject = ['$scope','PlanetService'];
	function PlanetaryStrengthsController($scope, PlanetService) {
		var vm = this;

		vm.panelTitle = '< Planetary Strengths >';
		vm.gauges = [];
		vm.popupTemplateUrl = 'app/vedicAstroApp/modals/planet_strength_pop_up.html';
		vm.selectedPlanetIndex = 0;
		vm.getPlanetSelected = getPlanetSelected;
		vm.setPlanetSelected = setPlanetSelected;

		vm.planetsStrengthInfo = {strengths:[], significances:[]};
		
		(function init() {
			loadPlanetaryStrengthsInfo();
		})();

		function setPlanetSelected(index) {
			vm.selectedPlanetIndex = index;
		};

		function getPlanetSelected() {
			return vm.planetsStrengthInfo.significances[vm.selectedPlanetIndex];
		};

		function loadPlanetaryStrengthsInfo() {
			PlanetService.getPlanetsStrengthInfo($scope.predictionSystem)
               .then(function (planetsStrengthInfo) {
                   vm.planetsStrengthInfo = planetsStrengthInfo;
                   constructGauges();
               });
		};
		
		function constructGauges() {

			for (var i = 0; i < vm.planetsStrengthInfo.strengths.length; i++) {
				var planetaryStrength = vm.planetsStrengthInfo.strengths[i];
				constructGauge(planetaryStrength);
			}
		}
	};

	function constructGauge(planetaryStrength) {

		var gauge = new JustGage({
			id : planetaryStrength.id,
			value : planetaryStrength.score,
			title : planetaryStrength.planet,
			label : planetaryStrength.age,
			min : 0,
			max : 60,
			decimals : 2,
			gaugeWidthScale : 0.9,
			titleMinFontSize : 14,
			valueMinFontSize : 14,
			customSectors : [ {
				color : "red",
				lo : 0,
				hi : 20
			}, {
				color : "yellow",
				lo : 20,
				hi : 40
			}, {
				color : "green",
				lo : 40,
				hi : 60
			} ],
			shadowOpacity : 1,
			shadowSize : 3,
			shadowVerticalOffset : 5,
			pointer : true
		});
	};
})();
