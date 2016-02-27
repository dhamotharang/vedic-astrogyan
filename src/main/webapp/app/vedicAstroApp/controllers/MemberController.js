(function() {
	'use strict';
	angular.module('vedicAstroApp').controller('MemberController',
			MemberController);

	MemberController.$inject = [ '$rootScope', '$scope','MemberService', 'ReferenceDataService' ];

	function MemberController($rootScope, $scope, MemberService, ReferenceDataService) {
		var vm = this;
		vm.panelTitle = "< Manage member >";
		vm.countries = [];
		vm.member = {};
		vm.cities = [];

		$scope.members = [];
		$scope.selected = undefined;
		
		vm.loadMember = loadMember;
		vm.saveMember = saveMember;
		vm.cancel = cancel;

		(function init() {
			loadAllCountries();
			loadAllCities();
			loadMembers();
		})();

		function loadAllCountries() {
			ReferenceDataService.getData('countries').then(function(countries) {
				vm.countries = countries;
			});
		}
		
		function loadAllCities() {
			ReferenceDataService.getData('cities').then(function(cities) {
				vm.cities = cities;
			});
		}
		
		function loadMembers() {
			MemberService.getAll().then(function(members) {
				$scope.members = members;
			});
		}

		function loadMember(memberId) {
			MemberService.getByMemberId(memberId).then(function(member) {
				vm.member = member;
			});
		}

		function saveMember() {
			MemberService.save(vm.member).then(function(response) {

			});
		}
		
		function cancel() {
			vm.member = {};
		}
	}
}());
