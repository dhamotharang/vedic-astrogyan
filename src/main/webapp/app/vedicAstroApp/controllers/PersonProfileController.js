(function() {

	'use strict';

	var node = {
		name : '',
		children : [],
		data : ''
	};
	angular.module('vedicAstroApp').controller('PersonProfileController',
			PersonProfileController);
	PersonProfileController.$inject = ['$scope','ProfileService'];

	function PersonProfileController($scope, ProfileService) {
		$scope.panelTitle = '< Personal Profile >';
		$scope.profile = [ {
			name : 'Body',
			children : [ {
				name : 'Physical Appearance',
				children : [ {
					name : 'Looks',
					children : [ {
						name : 'Child 1.1.1.1',
						fields :['Source','Condition','Time dependence','Impact', 'Nature'],
					      data : [{source:'Zod',condition :'Asc',timeDependence :'No', impact:'Strong',nature:'Benefic'},
					              {source:'Nak',condition :'Sun Nak',timeDependence :'No', impact:'Strong',nature:'Benefic'},
					              {source:'Planet',condition :'Sun',timeDependence :'No', impact:'Weak',nature:'Malefic'}]
					
					}, {
						name : 'Child 1.1.1.2',
						fields :['Source','Condition','Time dependence','Impact', 'Nature'],
					      data : [{source:'Zod',condition :'Asc',timeDependence :'No', impact:'Strong',nature:'Benefic'},
					              {source:'Nak',condition :'Sun Nak',timeDependence :'No', impact:'Strong',nature:'Benefic'},
					              {source:'Planet',condition :'Sun',timeDependence :'No', impact:'Weak',nature:'Malefic'}]
					} ]
				}, {
					name : 'Sub 1.1.2',
					children : [ {
						name : 'Child 1.1.2.1',
						fields :['Source','Condition','Time dependence','Impact', 'Nature'],
					      data : [{source:'Zod',condition :'Asc',timeDependence :'No', impact:'Strong',nature:'Benefic'},
					              {source:'Nak',condition :'Sun Nak',timeDependence :'No', impact:'Strong',nature:'Benefic'},
					              {source:'Planet',condition :'Sun',timeDependence :'No', impact:'Weak',nature:'Malefic'}]    	
					}, {
						name : 'Child 1.1.2.2',
						fields :['Source','Condition','Time dependence','Impact', 'Nature'],
					      data : [{source:'Zod',condition :'Asc',timeDependence :'No', impact:'Strong',nature:'Benefic'},
					              {source:'Nak',condition :'Sun Nak',timeDependence :'No', impact:'Strong',nature:'Benefic'},
					              {source:'Planet',condition :'Sun',timeDependence :'No', impact:'Weak',nature:'Malefic'}]
					
					}, {
						name : 'Child 1.1.2.3',
						fields :['Source','Condition','Time dependence','Impact', 'Nature'],
					      data : [{source:'Zod',condition :'Asc',timeDependence :'No', impact:'Strong',nature:'Benefic'},
					              {source:'Nak',condition :'Sun Nak',timeDependence :'No', impact:'Strong',nature:'Benefic'},
					              {source:'Planet',condition :'Sun',timeDependence :'No', impact:'Weak',nature:'Malefic'}]
					    	
					} ]
				} ]
			}, {
				name : 'Sub 1.2',
				children : [ {
					name : 'Physical stature',
					fields :['Source','Condition','Time dependence','Impact', 'Nature'],
				      data : [{source:'Zod',condition :'Asc',timeDependence :'No', impact:'Strong',nature:'Benefic'},
				              {source:'Nak',condition :'Sun Nak',timeDependence :'No', impact:'Strong',nature:'Benefic'},
				              {source:'Planet',condition :'Sun',timeDependence :'No', impact:'Weak',nature:'Malefic'}]
				    	
				}, {
					name : 'Height',
					fields :['Source','Condition','Time dependence','Impact', 'Nature'],
				      data : [{source:'Zod',condition :'Asc',timeDependence :'No', impact:'Strong',nature:'Benefic'},
				              {source:'Nak',condition :'Sun Nak',timeDependence :'No', impact:'Strong',nature:'Benefic'},
				              {source:'Planet',condition :'Sun',timeDependence :'No', impact:'Weak',nature:'Malefic'}]
				    	
				} ]
			} ]
		}, {
			name : 'Mind',
			children : [ {
				name : 'Aggression',
				children : [ {
					name : 'Anger',
				      fields :['Source','Condition','Time dependence','Impact', 'Nature'],
				      data : [{source:'Zod',condition :'Asc',timeDependence :'No', impact:'Strong',nature:'Benefic'},
				              {source:'Nak',condition :'Sun Nak',timeDependence :'No', impact:'Strong',nature:'Benefic'},
				              {source:'Planet',condition :'Sun',timeDependence :'No', impact:'Weak',nature:'Malefic'}]
				    	
				} ]
			} ]
		} ];
	
		(function init() {
//			loadChartProfile();
		})();

	};

}());
