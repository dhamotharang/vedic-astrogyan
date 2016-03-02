(function() {

	'use strict';
	angular.module('vedicAstroApp')
			.controller('PageController', PageController);

	PageController.$inject = [ '$scope','$rootScope','$routeParams' ];

	function PageController($scope,$rootScope,$routeParams) {

		var vm = this;

		vm.user = $rootScope.globals.currentUser;
		vm.appTitle = 'Vedic-Astro!';
		vm.appIcon = 'fa-eye';
		vm.footer = 'one place for all astrological investigation';
		vm.company = 'Samlabs';
		vm.copyright ='©2016 All Rights Reserved. Privacy and Terms';
		$scope.predictionSystem = $routeParams.predictionSystem;
		$scope.analysisGroup = $routeParams.analysisGroup;
		
		vm.menuItems = [ {
			menuTitle : 'Prashari',
			icon : 'fa-home',
			subItems : [ {
				title : 'Chart Analysis',
				href : '#/chart/Prashara/ChartAnalysis'
			}, {
				title : 'House Analysis',
				href : '#/house/Prashara/HouseAnalysis'
			}, {
				title : 'Varga Analysis',
				href : '#/vargas/Prashara/VargaAnalysis'
			}, {
				title : 'Yogas',
				href : '#/yogas/Prashara/YogasAnalysis'
			}, {
				title : 'Nakshatra Dashas',
				href : '#/nak-dashas/Prashara/DashaAnalysis'
			}, {
				title : 'Zodiac Dashas',
				href : '#/zod-dashas/Prashara/DashaAnalysis'
			}, {
				title : 'Transits',
				href : '#/transits/Prashara/TransitAnalysis'
			}, {
				title : 'Event Prediction',
				href : '#/event-prediction/Prashara'
			}]
		},
		{
			menuTitle : 'Jaimini',
			icon : 'fa-cubes',
			subItems : [ {
				title : 'Chart Analysis',
				href : '#/chart/Jaimini/ChartAnalysis'
			}, {
				title : 'House Analysis',
				href : '#/house/Jaimini/HouseAnalysis'
			}, {
				title : 'Yogas',
				href : '#/yogas/Jaimini/YogasAnalysis'
			}, {
				title : 'Zodiac Dashas',
				href : '#/zod-dashas/Jaimini/DashaAnalysis'
			},{
				title : 'Event Prediction',
				href : '#/event-prediction/Jaimini'
			}]
		},
		{
			menuTitle : 'Ashtavarga',
			icon : 'fa-laptop',
			subItems : [ {
				title : 'Chart Analysis',
				href : '#/chart/Ashtavarga/ChartAnalysis'
			}, {
				title : 'House Analysis',
				href : '#/house/Ashtavarga/HouseAnalysis'
			}, {
				title : 'Varga Analysis',
				href : '#/vargas/Parashara/VargaAnalysis'
			}, {
				title : 'Yogas',
				href : '#/yogas/Ashtavarga/YogasAnalysis'
			}, {
				title : 'Transits',
				href : '#/transits/Ashtavarga/TransitAnalysis'
			}, {
				title : 'Event Prediction',
				href : '#/event-prediction/Parashara'
			}]
		},
		{
			menuTitle : 'Tajika',
			icon : 'fa-university',
			subItems : [ {
				title : 'Chart Analysis',
				href : '#/chart/VarshaPhala/ChartAnalysis'
			}, {
				title : 'House Analysis',
				href : '#/house/VarshaPhala/HouseAnalysis'
			}, {
				title : 'Varga Analysis',
				href : '#/vargas/Parashara/VargaAnalysis'
			}, {
				title : 'Yogas',
				href : '#/yogas/VarshaPhala/YogasAnalysis'
			}, {
				title : 'Nakshatra Dashas',
				href : '#/nak-dashas/VarshaPhala/DashaAnalysis'
			},{
				title : 'Transits',
				href : '#/transits/VarshaPhala/TransitAnalysis'
			}, {
				title : 'Event Prediction',
				href : '#/event-prediction/VarshaPhala'
			}]
		},
		{
			menuTitle : 'KP',
			icon : 'fa-codepen',
			subItems : [ {
				title : 'Chart Analysis',
				href : '#/chart/KP/ChartAnalysis'
			}, {
				title : 'House Analysis',
				href : '#/house/KP/HouseAnalysis'
			}, {
				title : 'Yogas',
				href : '#/yogas/KP/YogasAnalysis'
			}, {
				title : 'Nakshatra Dashas',
				href : '#/nak-dashas/KP/DashaAnalysis'
			}, {
				title : 'Transits',
				href : '#/transits/KP/TransitAnalysis'
			}, {
				title : 'Event Prediction',
				href : '#/event-prediction/KP'
			}]
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
			menuTitle : 'Users',
			icon : 'fa-user',
			subItems : [ {
				title : 'Members',
				href : '#/manage-member/'
			},
			{
				title : 'Mundane',
				href : '#/manage-entity/'
			},
			{
				title : 'Admins',
				href : '#/manage-admin/'
			}]
		}];
	}
}());
