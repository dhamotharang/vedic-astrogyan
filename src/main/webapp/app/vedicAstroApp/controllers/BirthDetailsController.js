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
		vm.countries = [];
		vm.member = {};
		vm.cities = [];

		vm.openSwitchMemberModal = openSwitchMemberModal;

		(function init() {
			// reset login status
			loadAllCountries();
			loadAllCities();
			angular.element(document.getElementById('datetimepicker1')).datetimepicker();
			loadCurrentMember();
		})();

		function loadAllCountries() {
			ReferenceDataService.getData('countries').then(function(countries) {
				vm.countries = countries;
			});
		}
		;

		function loadAllCities() {
			ReferenceDataService.getData('cities').then(function(cities) {
				vm.cities = cities;
			});
		}
		;

		function loadCurrentMember() {
			MemberService.getById().then(function(member) {
				vm.member = member;
			});
		}
		;

		function openSwitchMemberModal() {
			var modalInstance = $uibModal.open({
				animation : true,
				templateUrl : 'app/vedicAstroApp/modals/switch_member.html',
				controller : 'SwitchMemberController',
				size: 'sm',
				controllerAs : 'vm',
			});

		}
		;
	}
	;

	angular.module('vedicAstroApp').controller('SwitchMemberController',
			SwitchMemberController);

	SwitchMemberController.$inject = [ '$rootScope', '$cookieStore', '$route', '$scope', '$uibModalInstance', '$http',
			'MemberService', 'AuthService' ];

	function SwitchMemberController($rootScope, $cookieStore, $route, $scope, $uibModalInstance, $http, MemberService, AuthService) {

		$scope.members = [];
		$scope.selected = undefined;

		(function init() {
			loadMembers();
		})();
	
		function loadMembers() {
			MemberService.getAllByAdmin($rootScope.globals.currentUser.id).then(function(members) {
				$scope.members = members;
			});
		}
		;

		$scope.ok = function() {
			var user = $rootScope.globals;
			user.currentUser.memberId = $scope.selected.id;
			$rootScope.globals = user;
			$cookieStore.remove('globals');
			$cookieStore.put('globals', $rootScope.globals);
			$uibModalInstance.close($scope.selected);
			AuthService.updateLastViewedMember();
			$route.reload();
		};

		$scope.cancel = function() {
			$uibModalInstance.dismiss('cancel');
		};
	}
	;

}());
