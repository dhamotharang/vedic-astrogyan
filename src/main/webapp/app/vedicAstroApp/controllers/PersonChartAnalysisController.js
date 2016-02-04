(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('PersonChartAnalysisController',
			PersonChartAnalysisController);

	PersonChartAnalysisController.$inject = [ '$scope', '$location',
			'AuthService' ];

	function PersonChartAnalysisController($scope, $location, AuthService) {
		var vm = this;

		vm.panelTitle = '< Personality Analysis >';
		vm.memberPid = '1234';
		vm.aspects = [ {
			id: 'body-tab',
			tabId : 'tabcontent1',
			fields : [ 'Entity Type', 'Name', 'Source', 'Impact' ],
			title : 'Body',
			data : [ {
				entityType : 'B-Planet',
				name : 'Mars',
				source : 'Strength',
				impact : 'Strong physically'
			}, {
				entityType : 'B-Nakshatra',
				name : 'Mrighshira',
				source : 'Asc',
				impact : 'Lunatic'
			}, {
				entityType : 'B-Zod',
				name : 'Gemini',
				source : 'Asc',
				impact : 'Mentally unstable'
			} ]
		},
		{
			id: 'mind-tab',
			tabId : 'tabcontent2',
			fields : [ 'Entity Type', 'Name', 'Source', 'Impact' ],
			title : 'Mind',
			data : [ {
				entityType : 'M-Planet',
				name : 'Mars',
				source : 'Strength',
				impact : 'Strong physically'
			}, {
				entityType : 'M-Nakshatra',
				name : 'Mrighshira',
				source : 'Asc',
				impact : 'Lunatic'
			}, {
				entityType : 'M-Zod',
				name : 'Gemini',
				source : 'Asc',
				impact : 'Mentally unstable'
			} ]
		},
		{
			id: 'soul-tab',
			tabId : 'tabcontent3',
			fields : [ 'Entity Type', 'Name', 'Source', 'Impact' ],
			title : 'Karmic',
			data : [ {
				entityType : 'K-Planet',
				name : 'Mars',
				source : 'Strength',
				impact : 'Strong physically'
			}, {
				entityType : 'K-Nakshatra',
				name : 'Mrighshira',
				source : 'Asc',
				impact : 'Lunatic'
			}, {
				entityType : 'K-Zod',
				name : 'Gemini',
				source : 'Asc',
				impact : 'Mentally unstable'
			} ]
		}];
		vm.activeTab = vm.aspects[0].id;    
		vm.changeActiveTab = changeActiveTab;
		vm.isActiveTab = isActiveTab;
		
		function isActiveTab(tabId) {
		     return tabId === vm.activeTab;
		  };

		function changeActiveTab(tab) {
		     vm.activeTab = tab;
		  };
	};
	
}());
