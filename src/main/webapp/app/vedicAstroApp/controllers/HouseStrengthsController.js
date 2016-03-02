(function() {
	'use strict';

	angular.module('vedicAstroApp').controller('HouseStrengthsController',
			HouseStrengthsController);

	HouseStrengthsController.$inject = ['$scope','HouseService'];
	function HouseStrengthsController($scope, HouseService) {
		var vm = this;

		vm.panelTitle = '< House Strengths >';
		vm.selectedHouseIndex = 0;
		vm.popupTemplateUrl = 'app/vedicAstroApp/modals/house_strength_pop_up.html';
		vm.getHouseSelected = getHouseSelected;
		vm.setHouseSelected = setHouseSelected;
		vm.housesStrengthInfo = {strengths:[], significances:[]};

		(function init() {
			loadHouseStrengthsInfo();
		})();

		function loadHouseStrengthsInfo() {
			HouseService.getHousesStrengthInfo($scope.predictionSystem)
               .then(function (housesStrengthInfo) {
            	   console.log(housesStrengthInfo);
                   vm.housesStrengthInfo = housesStrengthInfo;
                   constructGauges();
               });
		};
		function setHouseSelected(index){
			vm.selectedHouseIndex = index;
		};
		
		function getHouseSelected(){
			return vm.housesStrengthInfo.significances[vm.selectedHouseIndex];
		};

		
		function constructGauges() {

			for (var i = 0; i < vm.housesStrengthInfo.strengths.length; i++) {
				var houseStrength = vm.housesStrengthInfo.strengths[i];
				constructGauge(houseStrength);
			}
		}
		
	};

	function constructGauge(houseStrength) {
		var gauge = new JustGage({
			id : houseStrength.id,
			value : houseStrength.score,
			title : houseStrength.house,
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
	}
	;
})();
