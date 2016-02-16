(function() {
	'use strict';

angular.module('vedicAstroApp')
.directive('mappedNodeData', function($compile) {
    return {
        restrict: 'E',
        terminal: true,
        scope: {
            leaf : '=ngModel'
        },
        link: function ($scope, $element, $attrs) {
        	if (angular.isArray($scope.leaf.data)) {
             $element.append('<table class="table table-striped responsive-utilities jambo_table bulk_action"><thead><tr class="headings"><th class="column-title" ng-repeat="field in leaf.fields">{{field}}</th></thead><tbody><tr ng-repeat="tableData in leaf.data"><td>{{tableData.source}}</td><td>{{tableData.condition}}</td><td>{{tableData.timeDependence}}</td><td>{{tableData.impact}}</td><td>{{tableData.nature}}</td></tr></tbody></table>');
        	}
            $compile($element.contents())($scope.$new());
            
        }
    };
})

}());
