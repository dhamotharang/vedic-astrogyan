(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('NavbarController',
			NavbarController);

	NavbarController.$inject = [ '$scope', '$location', 'AuthService', '$rootScope'];

	function NavbarController($scope, $location, AuthService, $rootScope) {
		var vm = this;

		vm.menuTitle = 'Vedic Astro';
		vm.user = $rootScope.globals.currentUser;
		vm.menuItems = [ {
			menuTitle : 'Prashari',
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
				href : '#/pr-nak-dashas/'
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
			menuTitle : 'Prediction Mappings',
			subItems : [ {
				title : 'Person Setup',
				href : '#/profile-settings/'
			}, {
				title : 'Aspect Group',
				href : '#/aspect-group-setting/'
			}, {
				title : 'Prediction Group',
				href : '#/prediction-group-setting/'
			}, {
				title : 'Analysis component',
				href : '#/analysis-component-setting/'
			}, {
				title : 'Final profile',
				href : '#/final-profile/'
			} ]
		},{
			menuTitle : 'User Management',
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
