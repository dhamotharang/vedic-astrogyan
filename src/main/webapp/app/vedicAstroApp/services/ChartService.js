(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .factory('ChartService', ChartService);

    ChartService.$inject = ['$http','$rootScope'];
    function ChartService($http, $rootScope) {
        var service = {};

        service.getChartData = getChartData;
        
        return service;

        function getChartData(chartType) {
            return $http.get('/api/chart/' + chartType + '/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting all users'));
        }

        function handleGetSuccess(res) {
            return res.data.responseData;
        }

        function handleSubmitSuccess(res) { 
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
