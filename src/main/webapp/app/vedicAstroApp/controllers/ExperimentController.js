(function () {
	
	angular.module('vedicAstroApp').controller('PopoverDemoCtrl', function ($scope) {
	  $scope.dynamicPopover = {
	    content: 'Hello, World!',
	    templateUrl: 'app/vedicAstroApp/modals/strength_pop_up.html',
	    title: 'Title'
	  };

	  $scope.placement = {
	    options: [
	      'top',
	      'top-left',
	      'top-right',
	      'bottom',
	      'bottom-left',
	      'bottom-right',
	      'left',
	      'left-top',
	      'left-bottom',
	      'right',
	      'right-top',
	      'right-bottom'
	    ],
	    selected: 'top'
	  };
	});
}());
