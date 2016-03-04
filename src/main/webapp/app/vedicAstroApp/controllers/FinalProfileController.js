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
		vm.memberTypes = [];
		vm.memberTypeSelected = {};

		vm.filterByTemplate = filterByTemplate;
		vm.filterByAnalysisGroup = filterByAnalysisGroup;
		vm.loadProfileAspects = loadProfileAspects;

		(function init() {
			loadAllMemberTypes();
			loadAllTemplates();
			loadAllAnalysisGroups();
		})();

		function loadProfileAspects(memberType) {
			ProfileService.getProfileInfo(memberType).then(function(aspects) {
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
			ProfileService.getFilteredProfile(filter, vm.memberTypeSelected.code).then(function(aspects) {
				$scope.aspects = aspects;
				vm.analysisGroupSelected = {};
			});
		}
		
		function filterByAnalysisGroup(analysisGroupCode) {
			var filter = {
				filterType : 'AnalysisGroup',
				filterValue : analysisGroupCode
			};
			ProfileService.getFilteredProfile(filter, vm.memberTypeSelected.code).then(function(aspects) {
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
		
		function loadAllMemberTypes() {
			ReferenceDataService.getData('member_types').then(function(memberTypes) {
				vm.memberTypes = memberTypes;
				vm.memberTypeSelected = vm.memberTypes[0];
				loadProfileAspects(vm.memberTypeSelected.code); 
			});
		}
	}
	
}());
