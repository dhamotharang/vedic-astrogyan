(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .factory('TransitService', TransitService);

    TransitService.$inject = ['$http'];
    function TransitService($http) {
        var service = {};

        service.getPlanetTransit = getPlanetTransit;
  
        return service;

        function getPlanetTransit(transitInput) {
            return $http.post('/api/transit/planet', transitInput).then(handleSubmitWithResponse, handleError('Error getting transit info'));
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
