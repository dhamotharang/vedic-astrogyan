(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('AspectGroupController',
			AspectGroupController);

	AspectGroupController.$inject = [ 'ProfileService' ];

	function AspectGroupController(ProfileService) {

		var vm = this;
		vm.templatePanelTitle = '< Manage Prediction templates >';
		vm.groupPanelTitle = '< Manage Prediction groups >';
		vm.aspectsSelected = [];
		vm.predictionTemplate = {code:'', name:'', aspects:[]};
		vm.predictionTemplates = [{code:'temp1', name:'Template1'},{code:'temp2', name:'Template2'},{code:'temp3', name:'Template3'}];
		vm.templateSelected = {};
		vm.gotoNext = gotoNext;
		vm.gotoPrevious = gotoPrevious;
		vm.finish = finish;
		vm.gotoStep = gotoStep;
		vm.nextButton = '';
		vm.previousButton = 'buttonDisabled';
		vm.finishButton = 'buttonDisabled';
		vm.currentStep = {};
		vm.addTemplate = addTemplate;
		
		vm.step1 = {
			name : 'Step 1',
			title : 'Add Template name',
			description : 'Create Prediction Template',
			isDone : '0',
			stepNo : 1,
			status : 'selected',
			style : 'block'	
		};
		vm.step2 = {
			name : 'Step 2',
			title : 'Add aspects to template',
			description : 'Add Aspects to Template',
			isDone : '0',
			stepNo : 2,
			status : 'disabled',
			style : 'none'	
		};

		(function init() {
			vm.currentStep = vm.step1;
			vm.templateSelected = vm.predictionTemplates[0];
			
		})();

		function addTemplate(template)
		function loadProfileFlat() {
			ProfileService.getProfileFlat().then(function(flatProfile) {
				vm.aspectsSelected = flatProfile;
				for (var i = 0; i < vm.aspectsSelected.length; i++) {
					vm.aspectsSelected[i].selected = false;
				}
				logAspects("Before selecting");
			});
		};

		function logAspects(msg){
			for (var i = 0; i < vm.aspectsSelected.length; i++) {
				console.log( msg + vm.aspectsSelected[i].path + " = " +vm.aspectsSelected[i].selected);
			}
			
		}
		
		
		function gotoNext(){
			if(vm.currentStep.stepNo == 1){
				loadProfileFlat();
				moveFront(vm.step1, vm.step2);
				vm.previousButton = '';
			}
			else if(vm.currentStep.stepNo == 2){
				vm.nextButton = 'buttonDisabled';
				vm.finishButton = '';
			}
		};
		
		function gotoPrevious(){
			if(vm.currentStep.stepNo == 2){
				moveFront(vm.step2, vm.step1);
				vm.previousButton = 'buttonDisabled';
			}
		};
		function finish(){};
		function moveFront(from, to){
			vm.currentStep = to;
			from.style = 'none';
			from.status = 'done';
			from.isDone = '1';
			to.style = 'block';
			to.status = 'selected';
		};
		function moveBack(from, to){
			vm.currentStep = from;
			to.style = 'none';
			to.status = 'disabled';
			to.isDone = '1';
			from.style = 'block';
			from.status = 'selected';
		};
		function gotoStep(step){
			if(step == 1){
				vm.step1.style = 'block';
				vm.step1.status = 'selected';
				vm.step2.style = 'none';
			}
			else if(step == 2){
				vm.step2.style = 'block';
				vm.step2.status = 'selected';
				vm.step1.style = 'none';
			}
		};
	}
}());
