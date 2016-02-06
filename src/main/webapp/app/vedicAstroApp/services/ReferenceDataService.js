(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .factory('ReferenceDataService', ReferenceDataService);

    ReferenceDataService.$inject = ['$http'];
    function ReferenceDataService($http) {
        var service = {};

        service.getAllCountries = getAllCountries;
        service.getAllCities = getAllCities;
        return service;

        function getAllCountries() {
            return $http.get('/api/lookup/countries').then(handleGetSuccess, handleError('Error getting all users'));
        }

        function getAllCities() {
            return $http.get('/api/lookup/cities').then(handleGetSuccess, handleError('Error getting all users'));
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
