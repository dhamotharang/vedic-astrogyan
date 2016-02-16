(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('PredictionGroupController',
			PredictionGroupController);

	PredictionGroupController.$inject = ['ProfileService' ];

	function PredictionGroupController(ProfileService) {
		
		var vm = this;
		vm.panelTitle = "< Profile setup >";
		vm.panelPreviewTitle1 = "Tree Preview";
		vm.panelPreviewTitle2 = "Flat Preview";
		vm.labels = [ 'Aspect', 'Sub-aspect', 'Sub-sub-aspect' ]
		vm.flatProfile = [];
		vm.parents = [];
		vm.parentSelected = {};
		vm.immediateChildren = [];
		vm.immediateChildSelected = {};
		vm.furtherChildren = [];
		vm.furtherChildSelected = {};
		vm.loadChildren = loadChildren;
		
		vm.addParentAspect = addParentAspect;
		vm.addImmediateChildAspect = addImmediateChildAspect;
		vm.addFurtherChildAspect = addFurtherChildAspect;

		vm.updateParentAspect = updateParentAspect;
		vm.updateImmediateChildAspect = updateImmediateChildAspect;
		vm.updateFurtherChildAspect = updateFurtherChildAspect;
		
		vm.deleteParentAspect = deleteParentAspect;
		vm.deleteImmediateChildAspect = deleteImmediateChildAspect;
		vm.deleteFurtherChildAspect = deleteFurtherChildAspect;
		
		(function init() {
			loadAllParents();
			loadProfileFlat();
		})();

		function loadAllParents() {
			ProfileService.getAllParents().then(function(parents) {
				vm.parents = parents;
				vm.parentSelected = vm.parents[0];
			});
		};
		
		
		function loadProfileFlat() {
			ProfileService.getProfileFlat().then(function(flatProfile) {
				vm.flatProfile = flatProfile;
			});
		};
		
		function addParentAspect(code, name) {
			var aspect = {code: code, name : name};
			ProfileService.saveAspect(aspect).then(function(response) {
				loadAllParents();
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function addImmediateChildAspect(code, name, parentCode) {
			var aspect = {code: code, name : name, parentCode : parentCode};
			ProfileService.saveAspect(aspect).then(function(response) {
				loadChildren(parentCode, 1);
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function addFurtherChildAspect(code, name, parentCode) {
			var aspect = {code: code, name : name, parentCode : parentCode};
			ProfileService.saveAspect(aspect).then(function(response) {
				loadChildren(parentCode, 2);
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;
		
		function updateParentAspect(code, name, id) {
			var aspect = {code: code, name : name, id : id};
			ProfileService.saveAspect(aspect).then(function(response) {
				loadAllParents();
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function updateImmediateChildAspect(code, name, parentCode, id) {
			var aspect = {code: code, name : name, parentCode : parentCode, id : id};
			ProfileService.saveAspect(aspect).then(function(response) {
				loadChildren(parentCode, 1);
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function updateFurtherChildAspect(code, name, parentCode, id) {
			var aspect = {code: code, name : name, parentCode : parentCode, id : id};
			ProfileService.saveAspect(aspect).then(function(response) {
				loadChildren(parentCode, 2);
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function deleteParentAspect(id) {
			ProfileService.deleteAspect(id).then(function(response) {
				loadAllParents();
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function deleteImmediateChildAspect(id, parentCode) {
			ProfileService.deleteAspect(id).then(function(response) {
				loadChildren(parentCode, 1);
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function deleteFurtherChildAspect(id, parentCode) {
			ProfileService.deleteAspect(id).then(function(response) {
				loadChildren(parentCode, 2);
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		
		function loadChildren(parent, level) {
			console.log("parent = " + parent + "level = " + level);
			ProfileService
					.getImmediateChildren(parent)
					.then(
							function(children) {
								console.log("children = " + children);
								if (level == 1) {
									vm.immediateChildren = children;
									if (vm.immediateChildren) {
										vm.immediateChildSelected = vm.immediateChildren[0];
										vm.furtherChildren = [];
									}
								} else if (level == 2) {
									vm.furtherChildren = children;
									if (vm.furtherChildren) {
										vm.furtherChildSelected = vm.furtherChildren[0];
									}
								}
							});
		}
		;

	}
}());
