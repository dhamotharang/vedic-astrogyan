(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .factory('PlanetService', PlanetService);

    PlanetService.$inject = ['$http','$rootScope'];
    function PlanetService($http, $rootScope) {
        var service = {};

        service.getPlanetsStrengthInfo = getPlanetsStrengthInfo;
        
        return service;

        function getPlanetsStrengthInfo() {
            return $http.get('/api/planets/strength/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting all users'));
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
