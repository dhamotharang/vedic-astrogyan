(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('ProfileSettingsController',
			ProfileSettingsController);

	ProfileSettingsController.$inject = [ '$rootScope', '$scope', 'ProfileService', 'ReferenceDataService' ];

	function ProfileSettingsController($rootScope, $scope, ProfileService, ReferenceDataService) {
		$scope.aspects = [];
		var vm = this;
		vm.panelTitle = "< Profile setup >";
		vm.memberTypeLabel = "Member type : ";
		vm.panelPreviewTitle1 = "Tree Preview";
		vm.panelPreviewTitle2 = "Flat Preview";
		vm.labels = [ 'Aspect', 'Sub-aspect', 'Sub-sub-aspect' ]
		vm.flatProfile = [];
		vm.memberTypes = [];
		vm.memberTypeSelected = {};
		vm.parents = [];
		vm.parentSelected = {};
		vm.immediateChildren = [];
		vm.immediateChildSelected = {};
		vm.furtherChildren = [];
		vm.furtherChildSelected = {};
		vm.loadChildren = loadChildren;
		vm.newParent = {};
		vm.newImmediateChild = {};
		vm.newFurtherChild = {};
		vm.addParentAspect = addParentAspect;
		vm.addImmediateChildAspect = addImmediateChildAspect;
		vm.addFurtherChildAspect = addFurtherChildAspect;

		vm.updateParentAspect = updateParentAspect;
		vm.updateImmediateChildAspect = updateImmediateChildAspect;
		vm.updateFurtherChildAspect = updateFurtherChildAspect;
		
		vm.deleteParentAspect = deleteParentAspect;
		vm.deleteImmediateChildAspect = deleteImmediateChildAspect;
		vm.deleteFurtherChildAspect = deleteFurtherChildAspect;
		vm.loadAllParents = loadAllParents;
		
		(function init() {
			loadAllMemberTypes();
			//loadAllParents();
			
		})();

		function loadAllMemberTypes() {
			ReferenceDataService.getData('member_types').then(function(memberTypes) {
				vm.memberTypes = memberTypes;
				vm.memberTypeSelected = vm.memberTypes[0];
				loadProfileTree();
				loadProfileFlat();
				ProfileService.getAllParents(vm.memberTypeSelected.code).then(function(parents) {
					vm.parents = parents;
					vm.parentSelected = vm.parents[0];
					
					ProfileService.getImmediateChildren(vm.parentSelected.code, vm.memberTypeSelected.code).then(function(children) {
						vm.immediateChildren = children;
						vm.immediateChildSelected = vm.immediateChildren[0];
						
						ProfileService.getImmediateChildren(vm.immediateChildSelected.code, vm.memberTypeSelected.code).then(function(children) {
							vm.furtherChildren = children;
							vm.furtherChildSelected = vm.furtherChildren[0];
							
						});
					});
				});
			});
		}
		function loadAllParents() {
			ProfileService.getAllParents(vm.memberTypeSelected.code).then(function(parents) {
				vm.parents = parents;
				vm.parentSelected = vm.parents[0];
				if(parents.length > 0){
				ProfileService.getImmediateChildren(vm.parentSelected.code,vm.memberTypeSelected.code).then(function(children) {
					vm.immediateChildren = children;
					vm.immediateChildSelected = vm.immediateChildren[0];
					
					ProfileService.getImmediateChildren(vm.immediateChildSelected.code, vm.memberTypeSelected.code).then(function(children) {
						vm.furtherChildren = children;
						vm.furtherChildSelected = vm.furtherChildren[0];
						
					});
				});
				}
				else{
					vm.immediateChildren = [];
					vm.furtherChildren = [];
				}
			});
			loadProfileTree();
			loadProfileFlat();
		};
		
		function loadProfileTree() {
			ProfileService.getProfileTree(vm.memberTypeSelected.code).then(function(aspects) {
				$scope.aspects = aspects;
			});
		};
		
		function loadProfileFlat() {
			ProfileService.getProfileFlat(vm.memberTypeSelected.code).then(function(flatProfile) {
				vm.flatProfile = flatProfile;
			});
		};
		
		function addParentAspect(code, name) {
			var aspect = {code: code, name : name, memberType : vm.memberTypeSelected.code};
			ProfileService.saveAspect(aspect).then(function(response) {
				vm.newParent = {};
				loadAllParents();
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function addImmediateChildAspect(code, name, parentCode) {
			var aspect = {code: code, name : name, parentCode : parentCode, memberType : vm.memberTypeSelected.code};
			ProfileService.saveAspect(aspect).then(function(response) {
				vm.newImmediateChild = {};
				loadChildren(parentCode, 1);
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function addFurtherChildAspect(code, name, parentCode) {
			var aspect = {code: code, name : name, parentCode : parentCode, memberType : vm.memberTypeSelected.code};
			ProfileService.saveAspect(aspect).then(function(response) {
				vm.newFurtherChild = {};
				loadChildren(parentCode, 2);
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;
		
		function updateParentAspect(code, name, id) {
			var aspect = {code: code, name : name, id : id, memberType : vm.memberTypeSelected.code};
			ProfileService.saveAspect(aspect).then(function(response) {
				loadAllParents();
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function updateImmediateChildAspect(code, name, parentCode, id) {
			var aspect = {code: code, name : name, parentCode : parentCode, id : id, memberType : vm.memberTypeSelected.code};
			ProfileService.saveAspect(aspect).then(function(response) {
				loadChildren(parentCode, 1);
				loadProfileTree();
				loadProfileFlat();
			});
		}
		;

		function updateFurtherChildAspect(code, name, parentCode, id) {
			var aspect = {code: code, name : name, parentCode : parentCode, id : id, memberType : vm.memberTypeSelected.code};
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

		function deleteFurtherChildAspect(id, parentCode) {
			ProfileService.deleteAspect(id).then(function(response) {
				loadChildren(parentCode, 2);
				loadProfileTree();
				loadProfileFlat();
			});
		}
		
		function loadChildren(parent, level) {
			ProfileService
					.getImmediateChildren(parent, vm.memberTypeSelected.code)
					.then(
							function(children) {
								if (level == 1) {
									vm.immediateChildren = children;
									if (vm.immediateChildren) {
										vm.immediateChildSelected = vm.immediateChildren[0];
										loadChildren(vm.immediateChildSelected, 2);
										
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
