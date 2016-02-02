(function () {

    var injectParams = ['$scope', '$location', 'AuthService'];

    var ChartAnalysisController = function ($scope, $location, AuthService) {
        var vm = this;

        vm.appTitle = 'Vedic Astro';
   
    };

    ChartAnalysisController.$inject = injectParams;

    angular.module('vedicAstroApp').controller('ChartAnalysisController', ChartAnalysisController);

}());
