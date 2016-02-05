(function() {
	'use strict';

	angular.module('vedicAstroApp').controller('PlanetaryStrengthsController',
			PlanetaryStrengthsController);

	PlanetaryStrengthsController.$inject = [ '$location', '$scope','AuthService',
			'FlashService' ];
	function PlanetaryStrengthsController($location, $scope, AuthService, FlashService) {
		var vm = this;

		vm.panelTitle = '< Planetary Strengths >';
		vm.gauges = [];
		vm.popupTemplateUrl = 'app/vedicAstroApp/modals/planet_strength_pop_up.html';
		vm.selectedPlanetIndex = 0;
		vm.getPlanetSelected = getPlanetSelected;
		vm.setPlanetSelected = setPlanetSelected;
		vm.planetaryStrengths = [{
			id : 'sun_gauge',
			age : 'Infant',
			planet : 'SUN',
			score : 39.6
		}, {
			id : 'mon_gauge',
			age : 'Matured',
			planet : 'MON',
			score : 43.5
		}, {
			id : 'mer_gauge',
			age : 'Infant',
			planet : 'MER',
			score : 23.5
		}, {
			id : 'ven_gauge',
			age : 'Young',
			planet : 'VEN',
			score : 13.5
		}, {
			id : 'mar_gauge',
			age : 'Infant',
			planet : 'MAR',
			score : 42.5
		}, {
			id : 'jup_gauge',
			age : 'Matured',
			planet : 'JUP',
			score : 26.5
		}, {
			id : 'sat_gauge',
			age : 'Infant',
			planet : 'SAT',
			score : 27.0
		} ];
		vm.planetSignificances = {
				headers : [ 'Planet','Body', 'Mind', 'Karmic', 'Age'],
				significances : [ {
					planet : 'SUN',
					body : 'SUN body',
					mind : 'SUN mind',
					karmic : 'SUN karmic',
					age : 'SUN age impact'
				}, {
					planet : 'MON',
					body : 'MON body',
					mind : 'MON mind',
					karmic : 'MON karmic',
					age : 'MON age impact'
				}, {
					planet : 'MER',
					body : 'MER body',
					mind : 'MER mind',
					karmic : 'MER karmic',
					age : 'MER age impact'
				}, {
					planet : 'VEN',
					body : 'VEN body',
					mind : 'VEN mind',
					karmic : 'VEN karmic',
					age : 'VEN age impact'
				}, {
					planet : 'MAR',
					body : 'MAR body',
					mind : 'MAR mind',
					karmic : 'MAR karmic',
					age : 'MAR age impact'
				}, {
					planet : 'JUP',
					body : 'JUP body',
					mind : 'JUP mind',
					karmic : 'JUP karmic',
					age : 'JUP age impact'
				}, {
					planet : 'SAT',
					body : 'SAT body',
					mind : 'SAT mind',
					karmic : 'SAT karmic',
					age : 'SAT age impact'
				}]
			};

		function setPlanetSelected(index){
			vm.selectedPlanetIndex = index;
		};
		
		function getPlanetSelected(){
			return vm.planetSignificances.significances[vm.selectedPlanetIndex];
		};

		(function init() {
			constructGauges(vm.planetaryStrengths);
		})();

		function constructGauges(planetaryStrengths) {
  
            for (var i = 0; i < planetaryStrengths.length; i++) {
                var planetaryStrength = planetaryStrengths[i];
                constructGauge(planetaryStrength);
                }
            }
        };
		
		function constructGauge(planetaryStrength) {
			console.log(planetaryStrength);
		    var gauge =  new JustGage({
		        id: planetaryStrength.id,
		        value : planetaryStrength.score,
		        title : planetaryStrength.planet,
		        label: planetaryStrength.age,
		        min: 0,
		        max: 60,
		        decimals: 2,
		        gaugeWidthScale: 0.9,
		        titleMinFontSize: 14,
		        valueMinFontSize: 14,
		        customSectors: [{
		          color : "red",
		          lo : 0,
		          hi : 20
		        },{
		          color : "yellow",
		          lo : 20,
		          hi : 40
		        }, {
		          color : "green",
		          lo : 40,
		          hi : 60
		        }],
		        shadowOpacity: 1,
		        shadowSize: 3,
		        shadowVerticalOffset: 5,
		        pointer: true
		      });
		    console.log(gauge);
		};

})();
