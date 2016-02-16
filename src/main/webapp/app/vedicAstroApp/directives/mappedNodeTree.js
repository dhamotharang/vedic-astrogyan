(function() {
	'use strict';

angular.module('vedicAstroApp')
.directive('mappedNodeTree', function($compile) {
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
                $element.append('<uib-accordion close-others="oneAtATime"><mapped-node ng-repeat="item in nodes" ng-model="item" childs="{{kids}}" heading-field="{{headingField}}" ></mapped-node></uib-accordion>');
            } 
            $compile($element.contents())($scope.$new());
        }
    };
})
.directive('mappedNode', function($compile) {
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
                $element.append('<uib-accordion-group heading="{{node[headingField]}}" ><mapped-node-tree ng-model="node[childs]" kids="{{childs}}" heading-field="{{headingField}}"></mapped-node-tree></uib-accordion-group>');
            } else {
            	$element.append('<uib-accordion-group heading="{{node[headingField]}}" ><mapped-node-data ng-model="node"></mapped-node-data></uib-accordion-group>');
            }
            $compile($element.contents())($scope.$new());
        }
    };
});

}());
