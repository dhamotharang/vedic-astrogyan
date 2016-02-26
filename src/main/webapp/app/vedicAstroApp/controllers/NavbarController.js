(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('NavbarController',
			NavbarController);

	NavbarController.$inject = [ '$scope', '$location', 'AuthService', '$rootScope'];

	function NavbarController($scope, $location, AuthService, $rootScope) {
		var vm = this;

		vm.menuTitle = 'Vedic Astro';
		vm.appIcon = 'fa-eye';
		vm.user = $rootScope.globals.currentUser;
		vm.menuItems = [ {
			menuTitle : 'Prashari',
			icon : 'fa-laptop',
			subItems : [ {
				title : 'Chart Analysis',
				href : '#/pr-chart-analysis/'
			}, {
				title : 'House Analysis',
				href : '#/pr-house-analysis/'
			}, {
				title : 'Varga Analysis',
				href : '#/pr-varga-analysis/'
			}, {
				title : 'Yogas',
				href : '#/pr-yogas/'
			}, {
				title : 'Nakshatra Dashas',
				href : '#/nak-dashas/'
			}, {
				title : 'Transits',
				href : '#/pr-transits/'
			}, {
				title : 'Event Prediction',
				href : '#/pr-event-prediction/'
			}, {
				title : 'References',
				href : '#/pr-references/'
			} ]
		},		
		{
			menuTitle : 'Settings',
			icon : 'fa-wrench',
			subItems : [ {
				title : 'Profile Setup',
				href : '#/profile-settings/'
			}, {
				title : 'Prediction Templates',
				href : '#/prediction-templates/'
			}, {
				title : 'Prediction Outcomes',
				href : '#/prediction-outcomes/'
			}, {
				title : 'Analysis Components',
				href : '#/analysis-components/'
			}, {
				title : 'Final profile',
				href : '#/final-profile/'
			} ]
		},{
			menuTitle : 'User Management',
			icon : 'fa-user',
			subItems : [ {
				title : 'Add User',
				href : '#/add-user/'
			}, {
				title : 'Edit User',
				href : '#/edit-user/'
			}]
		}];
	}
	;
}());
