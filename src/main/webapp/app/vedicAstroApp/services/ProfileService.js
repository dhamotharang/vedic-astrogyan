(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .factory('ProfileService', ProfileService);

    ProfileService.$inject = ['$http','$rootScope'];
    function ProfileService($http, $rootScope) {
        var service = {};

        service.getAnalysisResult = getAnalysisResult;
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
        service.saveComponent = saveComponent;
        service.deleteComponent = deleteComponent;
        service.getComponents = getComponents;
        service.saveSubComponents = saveSubComponents;
        service.getProfileInfo = getProfileInfo;
        service.getFilteredProfile = getFilteredProfile;
        service.saveSubComponent = saveSubComponent;
        service.deleteSubComponent = deleteSubComponent;
        service.getSubComponents = getSubComponents;
        
        return service;

        
        function getAnalysisResult(predictionSystem, analysisGroup) {
            return $http.get('/api/analysis/' + predictionSystem + '/' + analysisGroup + '/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting Analysis result'));
        }
 
        function getHouseProfile() {
            return $http.get('/api/profile/house/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting all users'));
        }

        function getProfileTree(memberType) {
            return $http.get('/api/profile/tree/' + memberType).then(handleGetSuccess, handleError('Error getting profile hierarchy'));
        }

        function getProfileFlat(memberType) {
            return $http.get('/api/profile/flat/' + memberType).then(handleGetSuccess, handleError('Error getting profile hierarchy'));
        }

        function getAllParents(memberType) {
            return $http.get('/api/profile/parents/' + memberType).then(handleGetSuccess, handleError('Error getting parents list'));
        }
        
        function getImmediateChildren(parentCode, memberType) {
            return $http.get('/api/profile/children/' + memberType + '/' + parentCode).then(handleGetSuccess, handleError('Error getting all users'));
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
 
        function getTemplateAspects(templateCode, memberType) {
            return $http.get('/api/template/aspects/' + memberType + '/'+ templateCode).then(handleGetSuccess, handleError('Error getting all users'));
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

        function getOutcomes(templateCode, memberType) {
            return $http.get('/api/outcomes/' + memberType + '/' + templateCode).then(handleGetSuccess, handleError('Error getting all users'));
        }
        
        function saveComponent(component) {
            return $http.post('/api/component/save', component).then(handleSubmitSuccess, handleError('Error adding template'));
        }
        
        function deleteComponent(component) {
            return $http.post('/api/component/delete', component).then(handleSubmitSuccess, handleError('Error adding template'));
        }
        
        function deleteSubComponent(subComponent) {
            return $http.post('/api/subComponent/delete', subComponent).then(handleSubmitSuccess, handleError('Error adding template'));
        }
        
        function saveSubComponent(subComponent) {
            return $http.post('/api/subComponent/save', subComponent).then(handleSubmitSuccess, handleError('Error adding template'));
        }
        
        function deleteComponent(subComponent) {
            return $http.post('/api/subComponent/delete', subComponent).then(handleSubmitSuccess, handleError('Error adding template'));
        }

        function getComponents(predictionSystem, analysisGroup) {
            return $http.get('/api/components/' + predictionSystem + '/' + analysisGroup).then(handleGetSuccess, handleError('Error getting all users'));
        }
        
        function getSubComponents(componentCode, memberType) {
            return $http.get('/api/subComponents/' + memberType + '/' + componentCode).then(handleGetSuccess, handleError('Error getting all users'));
        }

        function saveSubComponents(subComponents) {
            return $http.post('/api/subComponents/save', subComponents).then(handleSubmitSuccess, handleError('Error adding template'));
        }
        
        function getProfileInfo(memberType) {
            return $http.get('/api/profile/info/' + memberType).then(handleGetSuccess, handleError('Error getting profile hierarchy'));
        }
        
        function getFilteredProfile(filter, memberType) {
            return $http.post('/api/profile/filter/' + memberType , filter).then(handleSubmitWithResponse, handleError('Error adding aspect'));
        }

        function getFilteredProfile(filter) {
            return $http.post('/api/profile/filter', filter).then(handleSubmitWithResponse, handleError('Error adding aspect'));
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
