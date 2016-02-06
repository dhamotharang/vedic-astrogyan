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
			menuTitle : 'Jaimini',
			subItems : [ {
				title : 'Chart Analysis',
				href : '#/jm-chart-analysis/'
			}, {
				title : 'House Analysis',
				href : '#/jm-house-analysis/'
			}, {
				title : 'Yogas',
				href : '#/jm-yogas/'
			}, {
				title : 'Zodiac Dashas',
				href : '#/jm-zod-dashas/'
			}, {
				title : 'Event Prediction',
				href : '#/jm-event-prediction/'
			}, {
				title : 'References',
				href : '#/jm-references/'
			} ]
		},
		{
			menuTitle : 'Ashtavarga',
			subItems : [ {
				title : 'Chart Analysis',
				href : '#/av-chart-analysis/'
			}, {
				title : 'House Analysis',
				href : '#/av-house-analysis/'
			}, {
				title : 'Yogas',
				href : '#/av-yogas/'
			}, {
				title : 'Nakshatra Dashas',
				href : '#/av-nak-dashas/'
			}, {
				title : 'Transits',
				href : '#/av-transits/'
			}, {
				title : 'Event Prediction',
				href : '#/av-event-prediction/'
			}, {
				title : 'References',
				href : '#/av-references/'
			} ]
		}];
	}
	;
}());
