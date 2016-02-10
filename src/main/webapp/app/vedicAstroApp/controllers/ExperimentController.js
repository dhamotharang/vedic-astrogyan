(function () {
	
	angular.module('vedicAstroApp').controller('AccordionDemoCtrl', function ($scope) {
	  $scope.oneAtATime = true;

	  $scope.groups = [
	    {
	      title: 'Body',
	      content: 'Category - 1',
	      fields :['Entity name','Name','Source','Impact'],
	      data : [{entityType:'entityType1',name :'Name1',source :"Source1", impact:"Impact1"},
			        {entityType:'entityType2',name :'Name2',source :"Source2", impact:"Impact2"},
			        {entityType:'entityType3',name :'Name3',source :"Source3", impact:"Impact3"}]
	    	  
	    },
	    {
	      title: 'Mind',
	      content: 'Category - 2',
	      fields :['Entity name','Name','Source','Impact'],
	      data : [{entityType:'entityType4',name :'Name4',source :"Source4", impact:"Impact4"},
			        {entityType:'entityType5',name :'Name5',source :"Source5", impact:"Impact5"},
			        {entityType:'entityType6',name :'Name6',source :"Source6", impact:"Impact6"}]
	    }
	  ];
	  
	
	});
	
}());
