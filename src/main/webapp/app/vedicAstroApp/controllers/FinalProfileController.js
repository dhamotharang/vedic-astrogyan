(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('FinalProfileController',
			FinalProfileController);
	FinalProfileController.$inject = [ '$scope', 'ProfileService',
			'ReferenceDataService' ];

	function FinalProfileController($scope, ProfileService,
			ReferenceDataService) {
		var vm = this;
		$scope.panelTitle = '< Final Profile >';

		$scope.aspects = [];

		vm.predictionTemplates = [];
		vm.templateSelected = {};
		vm.analysisGroups = [];
		vm.analysisGroupSelected = {};
		vm.filterByTemplate = filterByTemplate;
		vm.filterByAnalysisGroup = filterByAnalysisGroup;
		vm.loadProfileAspects = loadProfileAspects;

		(function init() {
			loadProfileAspects();
			loadAllTemplates();
			loadAllAnalysisGroups();
		})();

		function loadProfileAspects() {
			ProfileService.getProfileInfo().then(function(aspects) {
				$scope.aspects = aspects;
				vm.templateSelected = {};
				vm.analysisGroupSelected = {};
			});
		}
		
		function filterByTemplate(templateCode) {
			var filter = {
				filterType : 'Template',
				filterValue : templateCode
			};
			ProfileService.getFilteredProfile(filter).then(function(aspects) {
				$scope.aspects = aspects;
				vm.analysisGroupSelected = {};
			});
		}
		
		function filterByAnalysisGroup(analysisGroupCode) {
			var filter = {
				filterType : 'AnalysisGroup',
				filterValue : analysisGroupCode
			};
			ProfileService.getFilteredProfile(filter).then(function(aspects) {
				$scope.aspects = aspects;
				vm.templateSelected = {};
			});
		}
		
		function loadAllTemplates() {
			ProfileService.getAllTemplates().then(function(templates) {
				vm.predictionTemplates = templates;

			});
		}

		function loadAllAnalysisGroups() {
			ReferenceDataService.getData('analysis_sources').then(
					function(analysisGroups) {
						vm.analysisGroups = analysisGroups;
					});
		}
	}
	
}());
