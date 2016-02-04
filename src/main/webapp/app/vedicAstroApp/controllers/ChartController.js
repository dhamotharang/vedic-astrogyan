(function () {

    var injectParams = ['$scope', '$location', 'AuthService'];
    var ChartController = function ($scope, $location, AuthService) {
        var vm = this;
        vm.appTitle = 'Vedic Astro';
    };

    ChartController.$inject = injectParams;
    angular.module('vedicAstroApp').controller('ChartController', ChartController);
}());
