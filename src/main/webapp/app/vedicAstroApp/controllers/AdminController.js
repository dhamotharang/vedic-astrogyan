(function() {
	'use strict';
	angular.module('vedicAstroApp').controller('AdminController',
			AdminController);

	AdminController.$inject = ['$scope', 'AuthService'];

	function AdminController($scope, AuthService) {
		var vm = this;
		vm.panelTitle = "< Manage Admin >";
		vm.admin = {};

		$scope.admins = [];
		$scope.selected = undefined;

		$scope.alerts = [];

		$scope.addAlert = function() {
			$scope.alerts.push({
				msg : 'Another alert!'
			});
		};

		$scope.closeAlert = function(index) {
			$scope.alerts.splice(index, 1);
			vm.admin = {};
			$scope.selected = undefined;
		};

		vm.saveAdmin = saveAdmin;
		vm.loadAdmin = loadAdmin;
		vm.cancel = cancel;

		(function init() {
			loadAdmins();
		})();

		function loadAdmins() {
			AuthService.getAllAdmins().then(function(admins) {
				$scope.admins = admins;
			});
		}

		function loadAdmin(adminId) {
			AuthService.loadAdmin(adminId).then(function(admin) {
				vm.admin = admin;
			});
		}

		function saveAdmin(admin) {
			AuthService.saveAdmin(admin).then(function(response) {
				loadAdmins();
					});
			cancel();
			$scope.alerts.push({
				type : 'success', msg : 'Admin saved successfully !'
			});
		}

		function cancel() {
			vm.admin = {};
			$scope.selected = undefined;
		}
	}
}());
