(function() {
	'use strict';

	angular.module('vedicAstroApp').controller('AnalysisResultController',
			AnalysisResultController);
	AnalysisResultController.$inject = ['$scope','ProfileService'];

	function AnalysisResultController($scope, ProfileService) {
		var vm = this;

		vm.panelTitle = '< Analysis Result >';
		vm.analysisResults = [];
		vm.fields = [ 'Component', 'Condition checked', 'Outcome'];
		vm.activeTab = {};
		vm.changeActiveTab = changeActiveTab;
		vm.isActiveTab = isActiveTab;

		(function init() {
			loadAnalysisResult();
		})();

		function loadAnalysisResult() {

			ProfileService.getAnalysisResult($scope.predictionSystem,$scope.analysisGroup).then(function(analysisResults) {
				vm.analysisResults = analysisResults;
				if(analysisResults.length > 0){
				for (var i = 0; i < vm.analysisResults.length; i++) {
					vm.analysisResults[i].fields = vm.fields;
					vm.analysisResults[i].tabId = vm.analysisResults[i].code; 
				}
				vm.activeTab = vm.analysisResults[0].code;
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
