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
        service.getProfileTree = getProfileTree;
        service.getProfileFlat = getProfileFlat;
        service.getAllParents = getAllParents;
        service.getImmediateChildren = getImmediateChildren;
        service.saveAspect = saveAspect;
        service.deleteAspect = deleteAspect;
        service.saveTemplate = saveTemplate;
        service.getAllTemplates = getAllTemplates;
        service.deleteTemplate = deleteTemplate;
        service.getTemplateAspects = getTemplateAspects;
        service.saveOutcome = saveOutcome;
        service.createOutcome = createOutcome;
        service.deleteOutcome = deleteOutcome;
        service.getOutcomes = getOutcomes;
        
        return service;

        function getChartProfile() {
            return $http.get('/api/profile/chart/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting all users'));
        }
        
        function getHouseProfile() {
            return $http.get('/api/profile/house/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting all users'));
        }

        function getProfileTree() {
            return $http.get('/api/profile/tree').then(handleGetSuccess, handleError('Error getting profile hierarchy'));
        }

        function getProfileFlat() {
            return $http.get('/api/profile/flat').then(handleGetSuccess, handleError('Error getting profile hierarchy'));
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
        
        function saveTemplate(template) {
            return $http.post('/api/template/save', template).then(handleSubmitSuccess, handleError('Error adding template'));
        }
        
        function deleteTemplate(template) {
            return $http.post('/api/template/delete', template).then(handleSubmitSuccess, handleError('Error adding template'));
        }

        function getAllTemplates() {
            return $http.get('/api/templates/all').then(handleGetSuccess, handleError('Error getting template list'));
        }
 
        function getTemplateAspects(templateCode) {
            return $http.get('/api/template/aspects/' + templateCode).then(handleGetSuccess, handleError('Error getting all users'));
        }

        function createOutcome(outcome) {
            return $http.post('/api/outcome/create', outcome).then(handleSubmitSuccess, handleError('Error adding template'));
        }
        
        function saveOutcome(outcome) {
            return $http.post('/api/outcome/save', outcome).then(handleSubmitSuccess, handleError('Error adding template'));
        }
        
        function deleteOutcome(outcome) {
            return $http.post('/api/outcome/delete', outcome).then(handleSubmitSuccess, handleError('Error adding template'));
        }

        function getOutcomes(templateCode) {
            return $http.get('/api/outcomes/' + templateCode).then(handleGetSuccess, handleError('Error getting all users'));
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
