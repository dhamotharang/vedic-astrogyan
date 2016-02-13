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
			menuTitle : 'General Settings',
			subItems : [ {
				title : 'Person Profile',
				href : '#/profile-settings/'
			}, {
				title : 'Analysis',
				href : '#/analysis-setting/'
			} ]
		},{
			menuTitle : 'Prediction Mappings',
			subItems : [ {
				title : 'Planet',
				href : '#/planet-mapping/'
			}, {
				title : 'House',
				href : '#/house-mapping/'
			}, {
				title : 'Zodiac',
				href : '#/zodiac-mapping/'
			}, {
				title : 'Nakshatra',
				href : '#/nak-mapping/'
			}, {
				title : 'Yogas',
				href : '#/yoga-mapping/'
			}, {
				title : 'Vargas',
				href : '#/varga-mapping/'
			}, {
				title : 'Dashas',
				href : '#/dasha-mapping/'
			}, {
				title : 'Transits',
				href : '#/transit-mapping/'
			}]
		}];
	}
	;
}());
