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
		vm.componentHeadings = [ 'Component', 'Name', 'Condition checked',
				'Mapped with', 'Outcomes' ];
		vm.labels = [ 'Analysis Group', 'Component', 'Sub-component' ];

		vm.predictionSystems = [];
		vm.predictionSystemSelected = {};

		vm.analysisGroups = [];
		vm.analysisGroupSelected = {};

		vm.components = [];
		vm.componentSelected = {};
		vm.newComponent = {};
		vm.addComponent = addComponent;
		vm.deleteComponent = deleteComponent;
		vm.getComponents = getComponents;
		vm.saveComponent = saveComponent;

		vm.subComponents = [];
		vm.subComponentSelected = {};
		vm.newSubComponent = {};
		vm.saveSubComponents = saveSubComponents;
		vm.getSubComponents = getSubComponents;
		vm.addSubComponent = addSubComponent;
		vm.deleteSubComponent = deleteSubComponent;
		vm.saveSubComponent = saveSubComponent;

		vm.gotoNext = gotoNext;
		vm.gotoPrevious = gotoPrevious;
		vm.finish = finish;
		vm.nextButton = '';
		vm.previousButton = 'buttonDisabled';
		vm.finishButton = 'buttonDisabled';
		vm.currentStep = {};

		vm.predictionTemplates;
		vm.getOutcomes = getOutcomes;
		
		vm.memberTypes = [];
		vm.memberTypeSelected = {};

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
			loadAllMemberTypes();
			loadAllAnalysisGroupsAndPredictionSystems();
		})();

		function loadAllAnalysisGroupsAndPredictionSystems() {
			ReferenceDataService
					.getData('analysis_sources')
					.then(
							function(analysisGroups) {
								vm.analysisGroups = analysisGroups;
								vm.analysisGroupSelected = vm.analysisGroups[0];

								ReferenceDataService
										.getData('prediction_systems')
										.then(
												function(predictionSystems) {
													vm.predictionSystems = predictionSystems;
													vm.predictionSystemSelected = vm.predictionSystems[0];

													getComponents(
															vm.predictionSystemSelected.code,
															vm.analysisGroupSelected.code);

												});
							});

		}

		function addComponent(component, predictionSystem, analysisGroup) {

			component.analysisGroup = analysisGroup;
			component.predictionSystem = predictionSystem;
			ProfileService.saveComponent(component).then(
					function(response) {
						getComponents(vm.predictionSystemSelected.code,
								vm.analysisGroupSelected.code);
						vm.newComponent = {};
					});
		}
		;

		function addSubComponent(subComponent, componentCode) {
			subComponent.componentCode = componentCode;
			ProfileService.saveSubComponent(subComponent).then(
					function(response) {
						getSubComponents(vm.componentSelected.code, vm.memberTypeSelected.code);
						vm.newSubComponent = {};
					});
		}
		;

		function saveComponent(component) {
			ProfileService.saveComponent(component).then(
					function(response) {
						getComponents(vm.predictionSystemSelected.code,
								vm.analysisGroupSelected.code);
					});
		}
		;

		function saveSubComponent(subComponent) {
			ProfileService.saveSubComponent(subComponent).then(
					function(response) {
						getSubComponents(vm.componentSelected.code, vm.memberTypeSelected.code);
					});
		}
		;

		function saveSubComponents(subComponents) {
			ProfileService.saveSubComponents(subComponents).then(function(response) {
				getSubComponents(vm.componentSelected.code, vm.memberTypeSelected.code);
			});
		}
		;

		function getComponents(predictionSystemCode, analysisGroupCode) {
			ProfileService.getComponents(predictionSystemCode,
					analysisGroupCode).then(function(components) {
				if (components.length > 0) {
					vm.components = components;
					vm.componentSelected = vm.components[0];
					getSubComponents(vm.componentSelected.code, vm.memberTypeSelected.code);
				}
				else{
					vm.components = [];
					vm.subComponents = [];
				}
			});

		}
		;

		function getSubComponents(componentCode, memberType) {
			ProfileService.getSubComponents(componentCode, memberType).then(
					function(subComponents) {
						vm.subComponents = subComponents;
						vm.subComponentSelected = vm.subComponents[0];
					});
		}
		;

		function deleteComponent(component) {
			ProfileService.deleteComponent(component).then(
					function(response) {
						getComponents(vm.predictionSystemSelected.code,
								vm.analysisGroupSelected.code);
					});

		}
		;

		function deleteSubComponent(subComponent) {
			ProfileService.deleteSubComponent(subComponent).then(
					function(response) {
						getSubComponents(vm.componentSelected.code, vm.memberTypeSelected.code);
					});

		}
		;

		function loadAllTemplates() {
			ProfileService.getAllTemplates().then(function(templates) {
				vm.predictionTemplates = templates;
				vm.templateSelected = vm.predictionTemplates[0];
			});
		}
		;

		function getOutcomes(code, templateCode, memberType) {
			ProfileService.getOutcomes(templateCode, memberType).then(function(outcomes) {
				for (var i = 0; i < vm.subComponents.length; i++) {
					if (vm.subComponents[i].code == code) {
						vm.subComponents[i].predictionOutcomes = outcomes;
					}
				}
			});
		}
		;

		function gotoNext() {
			if (vm.currentStep.stepNo == 1) {
				loadAllTemplates();
				moveFront(vm.step1, vm.step2);
				vm.previousButton = '';
				vm.nextButton = 'buttonDisabled';
				vm.finishButton = '';
			}
		}
		;

		function finish(subComponents) {
			saveSubComponents(subComponents);
			reset();
			$route.reload();
		}
		;

		function gotoPrevious() {
			if (vm.currentStep.stepNo == 2) {
				moveFront(vm.step2, vm.step1);
				vm.previousButton = 'buttonDisabled';
			}
		}
		;

		function moveFront(from, to) {
			vm.currentTemplateStep = to;
			from.style = 'none';
			from.status = 'done';
			from.isDone = '1';
			to.style = 'block';
			to.status = 'selected';
		}
		;

		function moveBack(from, to) {
			vm.currentTemplateStep = from;
			to.style = 'none';
			to.status = 'disabled';
			to.isDone = '1';
			from.style = 'block';
			from.status = 'selected';
		}
		;

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
		}
		;

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
		}
		
		function loadAllMemberTypes() {
			ReferenceDataService.getData('member_types').then(function(memberTypes) {
				vm.memberTypes = memberTypes;
				vm.memberTypeSelected = vm.memberTypes[0];
			});
		}
	}
}());
