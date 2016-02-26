(function() {
	'use strict';

	angular.module('vedicAstroApp').controller('AnalysisResultController',
			AnalysisResultController);
	AnalysisResultController.$inject = ['ProfileService'];

	function AnalysisResultController(ProfileService) {
		var vm = this;

		vm.panelTitle = '< Analysis Result >';
		vm.aspects = [ {
			id : 'nak-tab',
			tabId : 'tabcontent1',
			fields : [ 'Component', 'Condition checked', 'Outcome'],
			title : 'Nak',
			data : []
		}, {
			id : 'zod-tab',
			tabId : 'tabcontent2',
			fields : [ 'Component', 'Condition checked', 'Outcome'],
			title : 'Zod',
			data : []
		}, {
			id : 'hs-tab',
			tabId : 'tabcontent3',
			fields : [ 'Component', 'Condition checked', 'Outcome'],
			title : 'H-Strength',
			data : []
		}, {
			id : 'ps-tab',
			tabId : 'tabcontent4',
			fields : [ 'Component', 'Condition checked', 'Outcome'],
			title : 'P-Strength',
			data : []
		} ];

		vm.activeTab = vm.aspects[0].id;
		vm.changeActiveTab = changeActiveTab;
		vm.isActiveTab = isActiveTab;

		(function init() {
			loadAnalysisResult();
		})();

		function loadAnalysisResult() {

			ProfileService.getAnalysisResult().then(function(analysisResult) {
	
				for (var i = 0; i < vm.aspects.length; i++) {

					var aspect = vm.aspects[i];

					if (aspect.id == 'nak-tab') {
						aspect.data = analysisResult.nakAnalysis;
					} else if (aspect.id == 'zod-tab') {
						aspect.data = analysisResult.zodAnalysis;
					} else if (aspect.id == 'hs-tab') {
						aspect.data = analysisResult.houseStrengthAnalysis;
					} else if (aspect.id == 'ps-tab') {
						aspect.data = analysisResult.planetStrengthAnalysis;
					}
				}
			});
		};
		
		function isActiveTab(tabId) {
			return tabId === vm.activeTab;
		};

		function changeActiveTab(tab) {
			vm.activeTab = tab;
		};
	}
	;

}());
