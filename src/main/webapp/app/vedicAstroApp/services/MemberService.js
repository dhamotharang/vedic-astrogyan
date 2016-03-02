(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .factory('MemberService', MemberService);

    MemberService.$inject = ['$http','$rootScope'];
    function MemberService($http, $rootScope) {
        var service = {};

        service.getAll = getAll;
        service.getById = getById;
        service.save = save;
        service.update = update;
        service.getByMemberId = getByMemberId;
        service.getAllByAdmin = getAllByAdmin;
        service.getMemberTypesByAdmin = getMemberTypesByAdmin;
        service.getMemberTypesNotInByAdmin = getMemberTypesNotInByAdmin;
        
        return service;

        function getAll() {
            return $http.get('/api/members/all').then(handleGetSuccess, handleError('Error getting all users'));
        }

        function getAllByAdmin(adminId) {
            return $http.get('/api/members/' + adminId).then(handleGetSuccess, handleError('Error getting all users'));
        }
        
        function getMemberTypesByAdmin(memberType, adminId) {
            return $http.get('/api/members/' + memberType + '/' + adminId).then(handleGetSuccess, handleError('Error getting all users'));
        }
        
        function getMemberTypesNotInByAdmin(memberType, adminId) {
            return $http.get('/api/members/not/' + memberType + '/' + adminId).then(handleGetSuccess, handleError('Error getting all users'));
        }
        
        function getById() {
            return $http.get('/api/member/get/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting user by id'));
        }

        function save(member) {
            return $http.post('/api/member/save', member).then(handleSubmitSuccess, handleError('Error creating user'));
        }

        function update(member) {
            return $http.put('/api/member/update' + $rootScope.globals.currentUser.memberId, member).then(handleSubmitSuccess, handleError('Error updating user'));
        }
        
        function getByMemberId(memberId) {
            return $http.get('/api/member/get/' + memberId).then(handleGetSuccess, handleError('Error getting user by id'));
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
