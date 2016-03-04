(function() {

	'use strict';
	angular.module('vedicAstroApp').controller('PredictionOutcomeController',
			PredictionOutcomeController);

	PredictionOutcomeController.$inject = ['$route','ProfileService','ReferenceDataService'];

	function PredictionOutcomeController($route,ProfileService,ReferenceDataService) {

		var vm = this;
		vm.panelTitle = '< Manage Prediction outcomes >';
		vm.predictionOutcome = {
			code : '',
			name : '',
			templateCode :'',
			memberType : '',
			observations : []
		};
		vm.beneficOptions = [{code:'Benefic', name:'Benefic'},{code:'Malefic', name:'Malefic'},{code:'Neutral', name:'Neutral'}];
		vm.timeDepOptions = [{code:true, name:'Yes'},{code:false, name:'No'}];
		vm.obsHeadings = ['Aspect','Observation','Benefic/Malefic','Time dependent'];
		vm.outcomeObservations = [];
		vm.predictionOutcomes;
		vm.predictionTemplates;
		vm.outcomeSelected = {};
		vm.templateSelected = {};
		vm.newOutcome = {};
		vm.gotoNext = gotoNext;
		vm.gotoPrevious = gotoPrevious;
		vm.finish = finish;

		vm.nextButton = '';
		vm.previousButton = 'buttonDisabled';
		vm.finishButton = 'buttonDisabled';

		vm.currentStep = {};
		vm.addOutcome = addOutcome;
		vm.updateOutcome = updateOutcome;
		vm.deleteOutcome = deleteOutcome;
		vm.getOutcomes = getOutcomes;

		vm.memberTypes = [];
		vm.memberTypeSelected = {};


		vm.step1 = {
			name : 'Step 1',
			title : 'Add Outcome name',
			description : 'Create Prediction Outcome',
			isDone : '0',
			stepNo : 1,
			status : 'selected',
			style : 'block'
		};
		vm.step2 = {
			name : 'Step 2',
			title : 'Add observations to outcome',
			description : 'Add Observations',
			isDone : '0',
			stepNo : 2,
			status : 'disabled',
			style : 'none'
		};

		(function init() {
			vm.currentStep = vm.step1;
			loadAllMemberTypes();
			loadAllTemplates();
		})();

		function addOutcome(outcome, templateCode, memberType) {
			outcome.templateCode = templateCode;
			outcome.memberType = memberType;
			ProfileService.createOutcome(outcome).then(function(response) {
				getOutcomes(templateCode, vm.memberTypeSelected.code);
				  vm.newOutcome = {};
			  });
		};
	
		function getOutcomes(templateCode, memberType) {
			 ProfileService.getOutcomes(templateCode, memberType).then(function(outcomes) {
				 vm.predictionOutcomes = outcomes;
				 vm.outcomeSelected = vm.predictionOutcomes[0];

			  });
		};
		
		function updateOutcome(outcome, memberType) {
			outcome.memberType = memberType;
			  ProfileService.saveOutcome(outcome).then(function(response) {
				  getOutcomes(vm.templateSelected.code, vm.memberTypeSelected.code);
			  });
			 
		};
		
		function deleteOutcome(outcome) {
			  ProfileService.deleteOutcome(outcome).then(function(response) {
				  getOutcomes(vm.templateSelected.code, vm.memberTypeSelected.code);
			  });
			 
		};
		function loadAllTemplates() {
			ProfileService.getAllTemplates().then(function(templates) {
				vm.predictionTemplates = templates;
				vm.templateSelected = vm.predictionTemplates[0];
				getOutcomes(vm.templateSelected.code, vm.memberTypeSelected.code);
			});
		};

		function gotoNext() {
			if (vm.currentStep.stepNo == 1) {
				if(vm.outcomeSelected){
				 for (var i = 0; i < vm.outcomeSelected.observations.length; i++) {
					 var outcomeObservation = {};
					 outcomeObservation.aspectCode = vm.outcomeSelected.observations[i].aspectCode;
					 outcomeObservation.aspectPath = vm.outcomeSelected.observations[i].aspectPath;
					 outcomeObservation.observation = vm.outcomeSelected.observations[i].observation;
					 outcomeObservation.nature = getBeneficObject(vm.outcomeSelected.observations[i].nature);
					 outcomeObservation.timeDependent = getTimeDepObject(vm.outcomeSelected.observations[i].timeDependent);
					 
					 vm.outcomeObservations.push(outcomeObservation);
				 }
				moveFront(vm.step1, vm.step2);
				vm.previousButton = '';
				vm.nextButton = 'buttonDisabled';
				vm.finishButton = '';
				} 
			}
		};
		
		function finish(observations){
			
			vm.outcomeSelected.observations = [];
			
			 for (var i = 0; i < observations.length; i++) {
				 var observation = {};
				 observation.aspectCode = observations[i].aspectCode;
				 observation.observation = observations[i].observation;
				 observation.nature = observations[i].nature.code;
				 observation.timeDependent = observations[i].timeDependent.code;
				 vm.outcomeSelected.observations.push(observation);
			 }
			updateOutcome(vm.outcomeSelected, vm.memberTypeSelected.code);
			reset();
			$route.reload();
		}

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
		
		function reset(){
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
			vm.newOutcome = {};
			vm.outcomeObservations = [];
		}
		
		function getBeneficObject(code){
			var result;
			for (var i = 0; i < vm.beneficOptions.length; i++) {
				if(vm.beneficOptions[i].code == code){
					result = vm.beneficOptions[i];
					break;
				}
			}
			return result;
		}
		
		function getTimeDepObject(code){
			var result;
			for (var i = 0; i < vm.timeDepOptions.length; i++) {
				if(vm.timeDepOptions[i].code == code){
					result = vm.timeDepOptions[i];
					break;
				}
			}
			return result;
		}
		function loadAllMemberTypes() {
			ReferenceDataService.getData('member_types').then(function(memberTypes) {
				vm.memberTypes = memberTypes;
				vm.memberTypeSelected = vm.memberTypes[0];
			});
		}
	}
}());
