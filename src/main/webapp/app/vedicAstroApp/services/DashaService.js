(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .factory('DashaService', DashaService);

    DashaService.$inject = ['$http','$rootScope'];
    function DashaService($http, $rootScope) {
        var service = {};

        service.getMainPeriods = getMainPeriods;
        service.getSubPeriods = getSubPeriods;
        
        return service;

        function getMainPeriods(input) {
            return $http.post('/api/dashas/nak/main' , input).then(handleGetSuccess, handleError('Error getting Main periods result'));
        }
        
        function getSubPeriods(mainPeriod) {
            return $http.post('/api/dashas/nak/subperiods', mainPeriod).then(handleSubmitWithResponse, handleError('Error adding aspect'));
        }
        
        function handleGetSuccess(res) {
            return res.data.responseData;
        }

        function handleSubmitSuccess(res) {
            return res.data;
        }
        
        function handleSubmitWithResponse(res) {
            return res.data.responseData;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
