(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .factory('ProfileService', ProfileService);

    ProfileService.$inject = ['$http','$rootScope'];
    function ProfileService($http, $rootScope) {
        var service = {};

        service.getChartProfile = getChartProfile;
        service.getHouseProfile = getHouseProfile;
        
        return service;

        function getChartProfile() {
            return $http.get('/api/profile/chart/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting all users'));
        }
        
        function getHouseProfile() {
            return $http.get('/api/profile/house/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting all users'));
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
