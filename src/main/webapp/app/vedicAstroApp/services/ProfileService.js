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
        service.getProfileHierarchy = getProfileHierarchy;
        service.getAllParents = getAllParents;
        service.getImmediateChildren = getImmediateChildren;
        service.saveAspect = saveAspect;
        service.deleteAspect = deleteAspect;
        
        return service;

        function getChartProfile() {
            return $http.get('/api/profile/chart/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting all users'));
        }
        
        function getHouseProfile() {
            return $http.get('/api/profile/house/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting all users'));
        }

        function getProfileHierarchy() {
            return $http.get('/api/profile/heirarchy').then(handleGetSuccess, handleError('Error getting profile hierarchy'));
        }

        function getAllParents() {
            return $http.get('/api/profile/parents').then(handleGetSuccess, handleError('Error getting parents list'));
        }
        
        function getImmediateChildren(parentCode) {
            return $http.get('/api/profile/children/' + parentCode).then(handleGetSuccess, handleError('Error getting all users'));
        }

       function saveAspect(aspect) {
            return $http.post('/api/profile/save', aspect).then(handleSubmitSuccess, handleError('Error adding aspect'));
        }
        
        function deleteAspect(id) {
            return $http.post('/api/profile/delete/'+ id).then(handleSubmitSuccess, handleError('Error adding aspect'));
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
