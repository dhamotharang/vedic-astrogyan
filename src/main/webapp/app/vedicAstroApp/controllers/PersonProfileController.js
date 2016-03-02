(function() {

	'use strict';

	var node = {
		name : '',
		children : [],
		predictions : ''
	};
	angular.module('vedicAstroApp').controller('PersonProfileController',
			PersonProfileController);
	PersonProfileController.$inject = ['$rootScope','$scope','ProfileService'];

	function PersonProfileController($rootScope, $scope, ProfileService) {
		$scope.panelTitle = '< Personal Profile >';
		$scope.profile = [ {
			name : 'Body',
			children : [ {
				name : 'Physical Appearance',
				children : [ {
					name : 'Looks',
					children : [ {
						name : 'Child 1.1.1.1',
						headings :['Source','Component','Condition','Outcome','Time dependence','Impact', 'Nature'],
					      predictions : [{analysisGroup:'Zod',componentName :'Asc',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
					              {analysisGroup:'Nak',componentName :'Sun Nak',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
					              {analysisGroup:'Planet',componentName :'Sun',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Malefic'}],
					      mappedTemplates : '[A, B]'        
					
					}, {
						name : 'Child 1.1.1.2',
						headings :['Source','Component','Condition','Outcome','Time dependence','Impact', 'Nature'],
					      predictions : [{analysisGroup:'Zod',componentName :'Asc',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
					              {analysisGroup:'Nak',componentName :'Sun Nak',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
					              {analysisGroup:'Planet',componentName :'Sun',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Malefic'}],
					    mappedTemplates : '[A, B]'       
					} ]
				}, {
					name : 'Sub 1.1.2',
					children : [ {
						name : 'Child 1.1.2.1',
						headings :['Source','Component','Condition','Outcome','Time dependence','Impact', 'Nature'],
					      predictions : [{analysisGroup:'Zod',componentName :'Asc',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
					              {analysisGroup:'Nak',componentName :'Sun Nak',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
					              {analysisGroup:'Planet',componentName :'Sun',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Malefic'}],
					      mappedTemplates : '[A, B]'        
					}, {
						name : 'Child 1.1.2.2',
						headings :['Source','Component','Condition','Outcome','Time dependence','Impact', 'Nature'],
					      predictions : [{analysisGroup:'Zod',componentName :'Asc',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
					              {analysisGroup:'Nak',componentName :'Sun Nak',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
					              {analysisGroup:'Planet',componentName :'Sun',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Malefic'}]
					
					}, {
						name : 'Child 1.1.2.3',
						headings :['Source','Component','Condition','Outcome','Time dependence','Impact', 'Nature'],
					      predictions : [{analysisGroup:'Zod',componentName :'Asc',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
					              {analysisGroup:'Nak',componentName :'Sun Nak',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
					              {analysisGroup:'Planet',componentName :'Sun',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Malefic'}]
					    	
					} ]
				} ]
			}, {
				name : 'Sub 1.2',
				children : [ {
					name : 'Physical stature',
					headings :['Source','Component','Condition','Outcome','Time dependence','Impact', 'Nature'],
				      predictions : [{analysisGroup:'Zod',componentName :'Asc',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
				              {analysisGroup:'Nak',componentName :'Sun Nak',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
				              {analysisGroup:'Planet',componentName :'Sun',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Malefic'}]
				    	
				}, {
					name : 'Height',
					headings :['Source','Component','Condition','Outcome','Time dependence','Impact', 'Nature'],
				      predictions : [{analysisGroup:'Zod',componentName :'Asc',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
				              {analysisGroup:'Nak',componentName :'Sun Nak',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
				              {analysisGroup:'Planet',componentName :'Sun',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Malefic'}]
				    	
				} ]
			} ]
		}, {
			name : 'Mind',
			children : [ {
				name : 'Aggression',
				children : [ {
					name : 'Anger',
					headings :['Source','Component','Condition','Outcome','Time dependence','Impact', 'Nature'],
				      predictions : [{analysisGroup:'Zod',condition :'Asc',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
				              {analysisGroup:'Nak',condition :'Sun Nak',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Benefic'},
				              {analysisGroup:'Planet',condition :'Sun',conditionChecked :'No', outcome:'XYZ', timeDependent : true, observation:'Strong',nature:'Malefic'}]
				    	
				} ]
			} ]
		} ];
		
		$scope.aspects = [];
	
		(function init() {
			loadMemberProfile();
		})();

		function loadMemberProfile() {
			var filter = {
					filterType : 'MemberAnalysis',
					filterValue : $rootScope.globals.currentUser.memberId,
					model : $scope.predictionSystem,
					analysisGroup : $scope.analysisGroup 
				};
				ProfileService.getFilteredProfile(filter).then(function(aspects) {
					$scope.aspects = aspects;
				});
		}
		
	};

}());
