(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('AspectGroupController',
			AspectGroupController);

	AspectGroupController.$inject = [ 'ProfileService' ];

	function AspectGroupController(ProfileService) {

		var vm = this;
		vm.panelTitle = '< Predictions setup >';
		vm.flatProfile = [];
		vm.gotoNext = gotoNext;
		vm.gotoPrevious = gotoPrevious;
		vm.finish = finish;
		vm.gotoStep = gotoStep;
		vm.nextButton = '';
		vm.previousButton = 'buttonDisabled';
		vm.finishButton = 'buttonDisabled';
		vm.currentStep = {};
		
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
			title : 'Add Template name',
			description : 'Add Aspects to Template',
			isDone : '0',
			stepNo : 2,
			status : 'disabled',
			style : 'none'	
		};
		vm.step3 = {
			name : 'Step 3',
			title : 'Add Template name',
			description : 'Create Prediction Condition',
			isDone : '0',
			stepNo : 3,
			status : 'disabled',
			style : 'none'	
		};
		vm.step4 = {
			name : 'Step 4',
			title : 'Add Template name',
			description : 'Fill Prediction Details',
			isDone : '0',
			stepNo : 4,
			status : 'disabled',
			style : 'none'	
		};

		(function init() {
			vm.currentStep = vm.step1;
			
		})();

		function loadProfileFlat() {
			ProfileService.getProfileFlat().then(function(flatProfile) {
				vm.flatProfile = flatProfile;
				for (var i = 0; i < vm.flatProfile.length; i++) {
					flatProfile[i].selected = false;
				}
				console.log(vm.flatProfile);
			});
		};

		function gotoNext(){
			if(vm.currentStep.stepNo == 1){
				loadProfileFlat();
				moveFront(vm.step1, vm.step2);
				vm.previousButton = '';
			}
			else if(vm.currentStep.stepNo == 2){
				moveFront(vm.step2, vm.step3);
			}
			else if(vm.currentStep.stepNo == 3){
				moveFront(vm.step3, vm.step4);
				vm.nextButton = 'buttonDisabled';
				vm.finishButton = '';
			}
		};
		
		function gotoPrevious(){
			if(vm.currentStep.stepNo == 2){
				moveFront(vm.step2, vm.step1);
				vm.previousButton = 'buttonDisabled';
			}
			else if(vm.currentStep.stepNo == 3){
				moveFront(vm.step3, vm.step2);
			}
			else if(vm.currentStep.stepNo == 4){
				moveFront(vm.step4, vm.step3);
				vm.nextButton = '';
				vm.finishButton = 'buttonDisabled';
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
				vm.step3.style = 'none';
				vm.step4.style = 'none';
			}
			else if(step == 2){
				vm.step2.style = 'block';
				vm.step2.status = 'selected';
				vm.step1.style = 'none';
				vm.step3.style = 'none';
				vm.step4.style = 'none';
			}
			else if(step == 3){
				vm.step3.style = 'block';
				vm.step3.status = 'selected';
				vm.step2.style = 'none';
				vm.step1.style = 'none';
				vm.step4.style = 'none';
			}
			else if(step == 4){
				vm.step4.style = 'block';
				vm.step4.status = 'selected';
				vm.step2.style = 'none';
				vm.step3.style = 'none';
				vm.step1.style = 'none';
			}
		};
	}
}());
