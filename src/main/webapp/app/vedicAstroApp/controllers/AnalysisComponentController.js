(function() {

	'use strict';
	angular.module('vedicAstroApp').controller('AnalysisComponentController',
			AnalysisComponentController);

	AnalysisComponentController.$inject = [ '$route', 'ProfileService',
			'ReferenceDataService' ];

	function AnalysisComponentController($route, ProfileService,
			ReferenceDataService) {

		var vm = this;
		vm.panelTitle = '< Manage Analysis components >';
		vm.componentHeadings = [ 'Name', 'Condition checked', 'Mapped with',
				'Outcomes', 'Enabled'];
		vm.analysisComponents = [];
		vm.predictionTemplates;
		vm.analysisGroups = [];
		vm.analysisGroupSelected = {};
		vm.componentSelected = {};
		vm.newComponent = {};
		vm.gotoNext = gotoNext;
		vm.gotoPrevious = gotoPrevious;
		vm.finish = finish;
		vm.nextButton = '';
		vm.previousButton = 'buttonDisabled';
		vm.finishButton = 'buttonDisabled';
		vm.currentStep = {};
		vm.saveComponent = saveComponent;
		vm.saveComponents = saveComponents;
		vm.addComponent = addComponent;
		vm.deleteComponent = deleteComponent;
		vm.getComponents = getComponents;
		vm.getOutcomes = getOutcomes;
		vm.step1 = {
			name : 'Step 1',
			title : 'Add Component name',
			description : 'Create Analysis component',
			isDone : '0',
			stepNo : 1,
			status : 'selected',
			style : 'block'
		};
		vm.step2 = {
			name : 'Step 2',
			title : 'Add outcomes to component',
			description : 'Add Outcomes',
			isDone : '0',
			stepNo : 2,
			status : 'disabled',
			style : 'none'
		};

		(function init() {
			vm.currentStep = vm.step1;
			loadAllAnalysisGroups();
		})();

		function loadAllAnalysisGroups(){
			ReferenceDataService.getData('analysis_sources').then(function(analysisGroups) {
				vm.analysisGroups = analysisGroups;
				vm.analysisGroupSelected = vm.analysisGroups[0];
				getComponents(vm.analysisGroupSelected.code);
			});
		};
		
		function addComponent(component, analysisGroupCode) {
			component.analysisGroup = analysisGroupCode;
			ProfileService.saveComponent(component).then(function(response) {
				getComponents(analysisGroupCode);
				vm.newComponent = {};
			});
		};
		
		function saveComponent(component) {
			ProfileService.saveComponent(component).then(function(response) {
				getComponents(vm.analysisGroupSelected.code);
			});
		};
		
		function saveComponents(components) {
			ProfileService.saveComponents(components).then(function(response) {
				getComponents(vm.analysisGroupSelected.code);
			});
		};

		function getComponents(analysisGroupCode) {
			ProfileService.getComponents(analysisGroupCode).then(function(components) {
				vm.analysisComponents = components;
				vm.componentSelected = vm.analysisComponents[0];
			});
		};

		function deleteComponent(component) {
			console.log('deleting component' + component);
			ProfileService.deleteComponent(component).then(function(response) {
				getComponents(vm.analysisGroupSelected.code);
			});

		};
		
		function loadAllTemplates() {
			ProfileService.getAllTemplates().then(function(templates) {
				vm.predictionTemplates = templates;
				vm.templateSelected = vm.predictionTemplates[0];
			});
		};
		
		function getOutcomes(code, templateCode) {
			 ProfileService.getOutcomes(templateCode).then(function(outcomes) {
				 for (var i = 0; i < vm.analysisComponents.length; i++) {
					 if(vm.analysisComponents[i].code == code){
						 vm.analysisComponents[i].predictionOutcomes = outcomes;
					 }
				 }
			  });
		};

		function logAspects(msg) {
			for (var i = 0; i < vm.aspectsSelected.length; i++) {
				console.log(msg + vm.aspectsSelected[i].path + " = "
						+ vm.aspectsSelected[i].selected);
			}
		};

		function gotoNext() {
			if (vm.currentStep.stepNo == 1) {
				loadAllTemplates();
				moveFront(vm.step1, vm.step2);
				vm.previousButton = '';
				vm.nextButton = 'buttonDisabled';
				vm.finishButton = '';
			}
		};

		function finish(components) {
			saveComponents(components);
			reset();
			$route.reload();
		};

		function gotoPrevious() {
			if (vm.currentStep.stepNo == 2) {
				moveFront(vm.step2, vm.step1);
				vm.previousButton = 'buttonDisabled';
			}
		};

		function moveFront(from, to) {
			vm.currentTemplateStep = to;
			from.style = 'none';
			from.status = 'done';
			from.isDone = '1';
			to.style = 'block';
			to.status = 'selected';
		};

		function moveBack(from, to) {
			vm.currentTemplateStep = from;
			to.style = 'none';
			to.status = 'disabled';
			to.isDone = '1';
			from.style = 'block';
			from.status = 'selected';
		};

		function gotoStep(step) {
			if (step == 1) {
				vm.step1.style = 'block';
				vm.step1.status = 'selected';
				vm.step2.style = 'none';
			} else if (step == 2) {
				vm.step2.style = 'block';
				vm.step2.status = 'selected';
				vm.step1.style = 'none';
			}
		};

		function reset() {
			vm.step1.isDone = '0';
			vm.step1.status = 'selected';
			vm.step1.style = 'block';

			vm.step2.isDone = '0';
			vm.step2.status = 'disabled';
			vm.step2.style = 'none';

			vm.currentStep = vm.step1;

			vm.nextButton = '';
			vm.previousButton = 'buttonDisabled';
			vm.finishButton = 'buttonDisabled';
			vm.newComponent = {};
		};
	}
}());
