(function() {

	'use strict';
	angular.module('vedicAstroApp')
			.controller('PageController', PageController);

	PageController.$inject = [ '$scope','$rootScope' ];

	function PageController($scope,$rootScope) {

		var vm = this;

		vm.user = $rootScope.globals.currentUser;
		vm.appTitle = 'Vedic-Astro!';
		vm.appIcon = 'fa-eye';
		vm.footer = 'one place for all astrological investigation';
		vm.company = 'Samlabs';
		vm.copyright ='©2016 All Rights Reserved. Privacy and Terms';
		
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
				href : '#/vargas/'
			}, {
				title : 'Yogas',
				href : '#/pr-yogas/'
			}, {
				title : 'Nakshatra Dashas',
				href : '#/nak-dashas/'
			}, {
				title : 'Zodiac Dashas',
				href : '#/zod-dashas/'
			}, {
				title : 'Transits',
				href : '#/transits/'
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
}());
