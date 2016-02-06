(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .factory('HouseService', HouseService);

    HouseService.$inject = ['$http','$rootScope'];
    function HouseService($http, $rootScope) {
        var service = {};

        service.getHousesStrengthInfo = getHousesStrengthInfo;
        
        return service;

        function getHousesStrengthInfo() {
            return $http.get('/api/houses/strength/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting all users'));
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
