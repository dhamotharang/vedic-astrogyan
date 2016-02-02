(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('NavbarController',
			NavbarController);

	NavbarController.$inject = [ '$scope', '$location', 'AuthService' ];

	function NavbarController($scope, $location, AuthService) {
		var vm = this;

		vm.menuTitle = 'Vedic Astro';
		vm.user = {
			firstName : "Sumeer",
			lastName : "Saxena",
			role : "ADMIN"
		};
	};
}());
