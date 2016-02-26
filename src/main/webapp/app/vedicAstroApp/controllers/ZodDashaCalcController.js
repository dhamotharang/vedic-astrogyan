(function() {

	'use strict';
	angular.module('vedicAstroApp').controller('ZodDashaCalcController',
			ZodDashaCalcController);

	ZodDashaCalcController.$inject = [ '$scope', '$rootScope', 'DashaService',
			'ReferenceDataService' ];

	function ZodDashaCalcController($scope, $rootScope, DashaService,
			ReferenceDataService) {

		var vm = this;
		vm.panelTitle = '< Zodiac Dasha >';
		vm.dt = new Date();
		vm.format = 'dd/MM/yyyy';
		vm.dateOptions = {
			formatYear : 'yy',
			startingDay : 1
		};
		vm.evaluateCurrentOrDefault = evaluateCurrentOrDefault;
		vm.changeMainPeriodZodiac = changeMainPeriodZodiac;
		vm.changeSubPeriodZodiac = changeSubPeriodZodiac;
		vm.changeInput = changeInput;
		vm.zodDashaOptions = [];
		vm.zodDashaSelected = {};
		vm.mainPeriods = [];
		vm.subPeriods = [];
		vm.mainPeriodSelected = {};
		vm.subPeriodSelected = {};

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
			loadZodDashas();
		})();

		vm.setDate = function(year, month, day) {
			vm.dt = new Date(year, month, day);
		};

		function loadZodDashas() {
			ReferenceDataService.getData('zod_dashas').then(
					function(dashas) {
						vm.zodDashaOptions = dashas;
						vm.zodDashaSelected = vm.zodDashaOptions[0];
						loadMainPeriods(vm.dt,
								$rootScope.globals.currentUser.memberId,
								vm.zodDashaSelected.code);
					});
		}

		function evaluateCurrentOrDefault(current) {
			var buttonLook;

			if (current) {
				buttonLook = 'btn-primary';
			} else {
				buttonLook = 'btn-default';
			}

			return buttonLook
		}
		function loadMainPeriods(date, memberId, zodDashaSytem) {
			var input = {
				memberPid : memberId,
				asOfDate : date,
				dashaSystem : zodDashaSytem
			};
			DashaService.getZodMainPeriods(input).then(function(mahadashas) {

				if (mahadashas != null) {
					vm.mainPeriods = mahadashas;

					for (var j = 0; j < vm.mainPeriods.length; j++) {
						if (vm.mainPeriods[j].current) {

							vm.mainPeriodSelected = {
								startDate : vm.mainPeriods[j].startDate,
								endDate : vm.mainPeriods[j].endDate
							};
							loadSubPeriod(vm.mainPeriods[j]);
							break;
						}
					}
				} else {
					vm.mainPeriods = [];
					vm.subPeriods = [];
					vm.mainPeriodSelected = {};
					vm.subPeriodSelected = {};

				}
			});
		}
		;

		function loadSubPeriod(mainPeriod) {
			var input = {
				zodiac : mainPeriod.zodiac,
				startDate : mainPeriod.startDate,
				endDate : mainPeriod.endDate,
				asOfDate : vm.dt,
				dashaSystem : vm.zodDashaSelected.code
			}
			DashaService.getZodSubPeriods(input).then(function(subperiods) {
				vm.subPeriods = subperiods;
				for (var j = 0; j < vm.subPeriods.length; j++) {
					if (vm.subPeriods[j].current) {
						vm.subPeriodSelected = {
							startDate : vm.subPeriods[j].startDate,
							endDate : vm.subPeriods[j].endDate
						};
						break;
					}
				}
			});
		}

		function changeMainPeriodZodiac(mainPeriod) {

			for (var j = 0; j < vm.mainPeriods.length; j++) {
				if (vm.mainPeriods[j].zodiac == mainPeriod.zodiac) {
					vm.mainPeriodSelected = {
						startDate : vm.mainPeriods[j].startDate,
						endDate : vm.mainPeriods[j].endDate
					};
					break;
				}
			}
			loadSubPeriod(mainPeriod);
			vm.subPeriodSelected = {};
		}

		function changeSubPeriodZodiac(subPeriod) {
			for (var j = 0; j < vm.subPeriods.length; j++) {
				if (vm.subPeriods[j].zodiac == subPeriod.zodiac) {
					vm.subPeriodSelected = {
						startDate : vm.subPeriods[j].startDate,
						endDate : vm.subPeriods[j].endDate
					};
					break;
				}
			}

		}

		function changeInput() {
			loadMainPeriods(vm.dt, $rootScope.globals.currentUser.memberId,
					vm.zodDashaSelected.code);
		}
	}
}());
