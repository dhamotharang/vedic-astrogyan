(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('BirthDetailsController',
			BirthDetailsController);

	BirthDetailsController.$inject = [ '$rootScope', '$uibModal', '$log',
			'MemberService', 'ReferenceDataService' ];

	function BirthDetailsController($rootScope, $uibModal, $log, MemberService,
			ReferenceDataService) {
		var vm = this;
		vm.panelTitle = "< Birth Details >";
		vm.items = [ 'item1', 'item2', 'item3' ];
		vm.countries = [];
		vm.member = {};
		vm.cities = [];

		vm.openSwitchMemberModal = openSwitchMemberModal;

		(function init() {
            // reset login status
			loadAllCountries();
			loadAllCities();
			loadCurrentMember();
        })();
		
		function loadAllCountries() {
			ReferenceDataService.getAllCountries()
               .then(function (countries) {
                   vm.countries = countries;
               });
		};
		
		function loadAllCities() {
			ReferenceDataService.getAllCities()
               .then(function (cities) {
                   vm.cities = cities;
               });
		};

		function loadCurrentMember() {
			MemberService.getById()
               .then(function (member) {
                   vm.member = member;
               });
		};

		function openSwitchMemberModal() {
			var modalInstance = $uibModal.open({
				animation : true,
				templateUrl : 'app/vedicAstroApp/modals/switch_member.html',
				controller : 'SwitchMemberController',
				controllerAs : 'vm',
				resolve : {
					items : function() {
						return vm.items;
					}
				}
			});

			modalInstance.result.then(function(selectedItem) {
				$scope.selected = selectedItem;
			}, function() {
				$log.info('Modal dismissed at: ' + new Date());
			});

		}
		;
	}
	;

	angular.module('vedicAstroApp').controller('SwitchMemberController',
			function($scope, $uibModalInstance, items) {

				$scope.items = items;
				$scope.selected = {
					item : $scope.items[0]
				};

				$scope.ok = function() {
					$uibModalInstance.close($scope.selected.item);
				};

				$scope.cancel = function() {
					$uibModalInstance.dismiss('cancel');
				};
			});

}());
