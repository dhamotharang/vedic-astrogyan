(function() {

	'use strict';
	angular.module('vedicAstroApp').controller('PredictionTemplateController',
			PredictionTemplateController);

	PredictionTemplateController.$inject = ['$scope','ProfileService', 'ReferenceDataService'];

	function PredictionTemplateController($scope, ProfileService, ReferenceDataService) {

		var vm = this;
		vm.templatePanelTitle = '< Manage Prediction templates >';
		vm.outcomePanelTitle = '< Manage Prediction outcomes >';
		vm.aspectsSelected = [];
		vm.predictionTemplate = {
			code : '',
			name : '',
			aspects : []
		};
		vm.predictionTemplates = [];
		vm.templateSelected = {};
		vm.newTemplate = {};
		vm.memberTypes = [];
		vm.memberTypeSelected = {};
		vm.gotoNextTemplate = gotoNextTemplate;
		vm.gotoPreviousTemplate = gotoPreviousTemplate;
		vm.finishTemplate = finishTemplate;
		vm.gotoStep = gotoStep;

		vm.nextTemplateButton = '';
		vm.previousTemplateButton = 'buttonDisabled';
		vm.finishTemplateButton = 'buttonDisabled';

		vm.nextOutcomeButton = '';
		vm.previousOutcomeButton = 'buttonDisabled';
		vm.finishOutcomeButton = 'buttonDisabled';

		vm.currentTemplateStep = {};
		vm.currentOutcomeStep = {};
		vm.addTemplate = addTemplate;
		vm.updateTemplate = updateTemplate;
		vm.deleteTemplate = deleteTemplate;

		vm.templateStep1 = {
			name : 'Step 1',
			title : 'Add Template name',
			description : 'Create Prediction Template',
			isDone : '0',
			stepNo : 1,
			status : 'selected',
			style : 'block'
		};
		vm.templateStep2 = {
			name : 'Step 2',
			title : 'Add aspects to template',
			description : 'Add Aspects to Template',
			isDone : '0',
			stepNo : 2,
			status : 'disabled',
			style : 'none'
		};

		(function init() {
			vm.currentTemplateStep = vm.templateStep1;
			loadAllTemplates();
			loadAllMemberTypes();
		})();

		function addTemplate(template) {
			vm.predictionTemplates.push(template);
			vm.predictionTemplate = template;

		};
		
		function updateTemplate(template) {
			  ProfileService.saveTemplate(template).then(function(response) {
				  loadAllTemplates();
			  });
			 
		};
		
		function deleteTemplate(template) {
			  ProfileService.deleteTemplate(template).then(function(response) {
				  loadAllTemplates();
			  });
			 
		};
		function loadAllTemplates() {
			ProfileService.getAllTemplates().then(function(templates) {
				vm.predictionTemplates = templates;
				vm.templateSelected = vm.predictionTemplates[0];
			});
		};
		function loadProfileFlat(templateCode, memberType) {
			ProfileService.getTemplateAspects(templateCode, memberType).then(function(aspects) {
				vm.aspectsSelected = aspects;
			});
		};

		function gotoNextTemplate() {
			if (vm.currentTemplateStep.stepNo == 1) {
				loadProfileFlat(vm.templateSelected.code, vm.memberTypeSelected.code);
				moveFrontTemplate(vm.templateStep1, vm.templateStep2);
				vm.previousTemplateButton = '';
				vm.nextTemplateButton = 'buttonDisabled';
				vm.finishTemplateButton = '';
			} 
		};

		function gotoPreviousTemplate() {
			if (vm.currentTemplateStep.stepNo == 2) {
				moveFrontTemplate(vm.templateStep2, vm.templateStep1);
				vm.previousTemplateButton = 'buttonDisabled';
			}
		};
		
		function finishTemplate() {
			var aspectCodes = [];
			for (var i = 0; i < vm.aspectsSelected.length; i++) {
				if(vm.aspectsSelected[i].selected){
					aspectCodes.push(vm.aspectsSelected[i].code);
				}
			}
			vm.predictionTemplate.aspectCodes = aspectCodes;
			ProfileService.saveTemplate(vm.predictionTemplate).then(function(response) {
                reset();
				loadAllTemplates();
			});
		};
		
		function moveFrontTemplate(from, to) {
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
				vm.templateStep1.style = 'block';
				vm.templateStep1.status = 'selected';
				vm.templateStep2.style = 'none';
			} else if (step == 2) {
				vm.templateStep2.style = 'block';
				vm.templateStep2.status = 'selected';
				vm.templateStep1.style = 'none';
			}
		};
		
		function reset(){
			vm.templateStep1.isDone = '0';
			vm.templateStep1.status = 'selected';
			vm.templateStep1.style = 'block';
			
			vm.templateStep2.isDone = '0';
			vm.templateStep2.status = 'disabled';
			vm.templateStep2.style = 'none';
			
			vm.currentTemplateStep = vm.templateStep1;
			vm.currentOutcomeStep = vm.outcomeStep1;
			
			vm.nextTemplateButton = '';
			vm.previousTemplateButton = 'buttonDisabled';
			vm.finishTemplateButton = 'buttonDisabled';

			vm.nextOutcomeButton = '';
			vm.previousOutcomeButton = 'buttonDisabled';
			vm.finishOutcomeButton = 'buttonDisabled';
			vm.newTemplate = {};
		}
		
		function loadAllMemberTypes() {
			ReferenceDataService.getData('member_types').then(function(memberTypes) {
				vm.memberTypes = memberTypes;
				vm.memberTypeSelected = vm.memberTypes[0];
			});
		}
	}
	

}());
