(function() {
	'use strict';

angular.module('vedicAstroApp')
.directive('nodeList', function($compile) {
    return {
        restrict: 'E',
        terminal: true,
        scope: {
            nodes: '=ngModel',
            kids: '@',
            headingField: '@'
        },
        link: function ($scope, $element, $attrs) {
            if (angular.isArray($scope.nodes)) {
                $element.append('<uib-accordion close-others="oneAtATime"><node ng-repeat="item in nodes" ng-model="item" childs="{{kids}}" heading-field="{{headingField}}" ></node></uib-accordion>');
            } 
            $compile($element.contents())($scope.$new());
        }
    };
})
.directive('node', function($compile) {
    return {
        restrict: 'E',
        terminal: true,
        scope: {
            node: '=ngModel',
            childs: '@',
            headingField: '@'
        },
        link: function ($scope, $element, $attrs) {
            if (angular.isArray($scope.node[$scope.childs]) && $scope.node[$scope.childs].length > 0) {
                $element.append('<uib-accordion-group heading="{{node[headingField]}}" ><node-list ng-model="node[childs]" kids="{{childs}}" heading-field="{{headingField}}"></node-list></uib-accordion-group>');
            } else {
            	$element.append('<uib-accordion-group heading="{{node[headingField]}}" ><node-leaf ng-model="node"></node-leaf></uib-accordion-group>');
            }
            $compile($element.contents())($scope.$new());
        }
    };
});

}());
