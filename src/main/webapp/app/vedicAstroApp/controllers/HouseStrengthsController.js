(function() {
	'use strict';

	angular.module('vedicAstroApp').controller('HouseStrengthsController',
			HouseStrengthsController);

	HouseStrengthsController.$inject = [ '$location', '$scope','AuthService',
			'FlashService' ];
	function HouseStrengthsController($location, $scope, AuthService, FlashService) {
		var vm = this;

		vm.panelTitle = 'House Strengths';
		vm.houseStrengths = [{
			id : 'h1_gauge',
			house : 'H1',
			score : 39.6
		}, {
			id : 'h2_gauge',
			house : 'H2',
			score : 43.5
		}, {
			id : 'h3_gauge',
			house : 'H3',
			score : 23.5
		}, {
			id : 'h4_gauge',
			house : 'H4',
			score : 13.5
		}, {
			id : 'h5_gauge',
			house : 'H5',
			score : 42.5
		}, {
			id : 'h6_gauge',
			house : 'H6',
			score : 26.5
		}, {
			id : 'h7_gauge',
			house : 'H7',
			score : 27.0
		} , {
			id : 'h8_gauge',
			house : 'H8',
			score : 51.0
		}, {
			id : 'h9_gauge',
			house : 'H9',
			score : 12.5
		}, {
			id : 'h10_gauge',
			house : 'H10',
			score : 22.0
		}, {
			id : 'h11_gauge',
			house : 'H11',
			score : 17.4
		}, {
			id : 'h12_gauge',
			house : 'H12',
			score : 57.0
		}];
		(function init() {
			constructGauges(vm.houseStrengths);
		})();

		function constructGauges(houseStrengths) {
  
            for (var i = 0; i < houseStrengths.length; i++) {
                var houseStrength = houseStrengths[i];
                constructGauge(houseStrength);
                }
            }
        };
		
		function constructGauge(houseStrength) {
			var gauge =  new JustGage({
		        id: houseStrength.id,
		        value : houseStrength.score,
		        title : houseStrength.house,
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
		};
})();
