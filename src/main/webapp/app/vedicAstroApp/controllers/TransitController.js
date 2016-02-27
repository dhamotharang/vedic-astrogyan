(function() {

	'use strict';
	angular.module('vedicAstroApp').controller('TransitController',
			TransitController);

	TransitController.$inject = [ '$scope', '$rootScope', 'TransitService',
			'ReferenceDataService' ];

	function TransitController($scope, $rootScope, TransitService,
			ReferenceDataService) {

		var vm = this;
		vm.panelTitle = '< Planet Transits >';
		vm.dt = new Date();
		vm.format = 'dd/MM/yyyy';
		vm.dateOptions = {
			formatYear : 'yy',
			startingDay : 1
		};
		vm.evaluateCurrentOrDefault = evaluateCurrentOrDefault;
		vm.changeInput = changeInput;
		vm.transitPlanets = [];
		vm.transitPlanetSelected = {};
		vm.zodiacs = [];
		vm.transitInfo = {};
		
		vm.popup1 = {
			opened : false
		};
		vm.altInputFormats = [ 'd!/M!/yyyy' ];
		vm.clear = function() {
			vm.dt = null;
		};
		vm.disabled = function(date, mode) {
			return mode === 'day'
					&& (date.getDay() === 0 || date.getDay() === 6);
		};

		vm.open1 = function() {
			vm.popup1.opened = true;
		};
		vm.maxDate = new Date(2085, 5, 22);

		(function init() {
			loadTransitPlanets();
		})();

		vm.setDate = function(year, month, day) {
			vm.dt = new Date(year, month, day);
		};

		function loadTransitPlanets() {
			ReferenceDataService.getData('transit_planets').then(
					function(planets) {
						vm.transitPlanets = planets;
						vm.transitPlanetSelected = vm.transitPlanets[0];
						loadTransitInfo(vm.dt,
									vm.transitPlanetSelected.code);
					});
		}
		
		function loadZodiacs(transitInfo) {
			ReferenceDataService.getData('zodiacs').then(
					function(zodiacs) {
						vm.zodiacs = zodiacs;
						for (var j = 0; j < vm.zodiacs.length; j++) {
							if (zodiacs[j].code == transitInfo.zodiac) {
								zodiacs[j].current = true;
							}
							else{
								zodiacs[j].current = false;
							}
						}
					});
		}


		function evaluateCurrentOrDefault(current) {
			var buttonLook;

			if (current) {
				buttonLook = 'btn-primary';
			} else {
				buttonLook = 'btn-default';
			}

			return buttonLook;
		}
		
		function loadTransitInfo(date, transitPlanet) {
			var input = {
				asOfDate : date,
				planet : transitPlanet
			};
			TransitService.getPlanetTransit(input).then(function(transitInfo) {
				vm.transitInfo = transitInfo;
				loadZodiacs(vm.transitInfo);
			});
		}

		function changeInput() {
			loadTransitInfo(vm.dt, vm.transitPlanetSelected.code);
		}
	}
}());
