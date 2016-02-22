(function() {
	'use strict';

angular.module('vedicAstroApp')
.directive('nodeLeaf', function($compile) {
    return {
        restrict: 'E',
        terminal: true,
        scope: {
            leaf : '=ngModel'
        },
        link: function ($scope, $element, $attrs) {
        	if (angular.isObject($scope.leaf) && angular.isArray($scope.leaf.predictions)) {
        		  $element.append('<p><b><i>Mapped to : </i></b> {{leaf.mappedTemplates}}</p><br><table class="table table-striped responsive-utilities jambo_table bulk_action"><thead><tr class="headings"><th class="column-title" ng-repeat="heading in leaf.headings">{{heading}}</th></thead><tbody><tr ng-repeat="tableData in leaf.predictions"><td>{{tableData.analysisGroup}}</td><td>{{tableData.componentName}}</td><td>{{tableData.conditionChecked}}</td><td>{{tableData.outcome}}</td><td>{{tableData.timeDependent}}</td><td>{{tableData.observation}}</td><td>{{tableData.nature}}</td></tr></tbody></table>');
        	}
            $compile($element.contents())($scope.$new());
            
        }
    };
})

}());
