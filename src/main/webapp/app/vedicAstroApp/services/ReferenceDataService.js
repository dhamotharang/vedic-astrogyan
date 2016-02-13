(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .factory('ReferenceDataService', ReferenceDataService);

    ReferenceDataService.$inject = ['$http'];
    function ReferenceDataService($http) {
        var service = {};

        service.getData = getData;
        return service;

        function getData(entity) {
            return $http.get('/api/lookup/' + entity).then(handleGetSuccess, handleError('Error getting all users'));
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
