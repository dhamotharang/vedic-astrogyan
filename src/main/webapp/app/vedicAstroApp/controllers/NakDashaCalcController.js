(function() {

	'use strict';
	angular.module('vedicAstroApp').controller('NakDashaCalcController',
			NakDashaCalcController);

	NakDashaCalcController.$inject = [ '$scope', '$rootScope', 'DashaService',
			'ReferenceDataService' ];

	function NakDashaCalcController($scope, $rootScope, DashaService,
			ReferenceDataService) {

		var vm = this;
		vm.panelTitle = '< Nakshatra Dasha >';
		vm.dt = new Date();
		vm.format = 'dd/MM/yyyy';
		vm.dateOptions = {
			formatYear : 'yy',
			startingDay : 1
		};
		vm.evaluateCurrentOrDefault = evaluateCurrentOrDefault;
		vm.changeMainPeriodPlanet = changeMainPeriodPlanet;
		vm.changeSubPeriod1Planet = changeSubPeriod1Planet;
		vm.changeSubPeriod2Planet = changeSubPeriod2Planet;
		vm.changeDate = changeDate;
		vm.nakDashaOptions = [];
		vm.nakDashaSelected = {};
		vm.mainPeriods = [];
		vm.subPeriods1 = [];
		vm.subPeriods2 = [];
		vm.mainPeriodSelected = {};
		vm.subPeriod1Selected = {};
		vm.subPeriod2Selected = {};
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
			loadNakDashas();
			loadMainPeriods(vm.dt, $rootScope.globals.currentUser.memberId);
			
		})();

		vm.setDate = function(year, month, day) {
			vm.dt = new Date(year, month, day);
		};

		function loadNakDashas() {
			ReferenceDataService.getData('nak_dashas').then(function(dashas) {
				vm.nakDashaOptions = dashas;
				vm.nakDashaSelected = vm.nakDashaOptions[0];
			});
		}
		
		function evaluateCurrentOrDefault(current){
			var buttonLook ;
			
			if(current){
				buttonLook = 'btn-primary';
			}
			else{
				buttonLook = 'btn-default';
			}
			
			return buttonLook
		}
		function loadMainPeriods(date, memberId) {
			var input = {memberPid : memberId, date:date };
			DashaService.getMainPeriods(input).then(function(mahadashas) {
				vm.mainPeriods = mahadashas;
				for (var j = 0; j < vm.mainPeriods.length; j++) {
					if (vm.mainPeriods[j].current) {
						
						vm.mainPeriodSelected = {startDate: vm.mainPeriods[j].startDate, endDate : vm.mainPeriods[j].endDate};
						loadSubPeriod1(vm.mainPeriods[j]);
						break;
					}
				}
			});
		}
		;
		
		function loadSubPeriod1(mainPeriod) {
			var input = {planet : mainPeriod.planet, startDate : mainPeriod.startDate, endDate : mainPeriod.endDate, date : vm.dt}
			DashaService.getSubPeriods(input).then(function(subperiods) {
				vm.subPeriods1 = subperiods;
				for (var j = 0; j < vm.subPeriods1.length; j++) {
					if (vm.subPeriods1[j].current) {
						vm.subPeriod1Selected = {startDate: vm.subPeriods1[j].startDate, endDate : vm.subPeriods1[j].endDate};
						loadSubPeriod2(vm.subPeriods1[j]);
						break;
					}
				}
			});
		}
		
		function loadSubPeriod2(subPeriod1) {
			var input = {planet : subPeriod1.planet, startDate : subPeriod1.startDate, endDate : subPeriod1.endDate, date : vm.dt}
			DashaService.getSubPeriods(input).then(function(subperiods) {
				vm.subPeriods2 = subperiods;
				for (var j = 0; j < vm.subPeriods2.length; j++) {
					if (vm.subPeriods2[j].current) {
						vm.subPeriod2Selected = {startDate: vm.subPeriods2[j].startDate, endDate : vm.subPeriods2[j].endDate};
						break;
					}
				}
			});
		}
		function changeMainPeriodPlanet(mainPeriod){
			
			for (var j = 0; j < vm.mainPeriods.length; j++) {
				if (vm.mainPeriods[j].planet == mainPeriod.planet) {
					vm.mainPeriodSelected = {startDate: vm.mainPeriods[j].startDate, endDate : vm.mainPeriods[j].endDate};
					break;
				}
			}
			loadSubPeriod1(mainPeriod);
			vm.subPeriod1Selected = {};
			vm.subPeriod2Selected = {};
		}
		
		function changeSubPeriod1Planet(subPeriod1){
			for (var j = 0; j < vm.subPeriods1.length; j++) {
				if (vm.subPeriods1[j].planet == subPeriod1.planet) {
					vm.subPeriod1Selected = {startDate: vm.subPeriods1[j].startDate, endDate : vm.subPeriods1[j].endDate};
					break;
				}
			}
			loadSubPeriod2(subPeriod1);
			vm.subPeriod2Selected = {};
		}
		
		function changeSubPeriod2Planet(subPeriod2){
			for (var j = 0; j < vm.subPeriods2.length; j++) {
				if (vm.subPeriods2[j].planet == subPeriod2.planet) {
					vm.subPeriod2Selected = {startDate: vm.subPeriods2[j].startDate, endDate : vm.subPeriods2[j].endDate};
					break;
				}
			}
		}
		
		function changeDate(){
			loadMainPeriods(vm.dt, $rootScope.globals.currentUser.memberId);
		}
	}
}());
