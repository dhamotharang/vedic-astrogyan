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
        service.create = create;
        service.update = update;

        return service;

        function getAll() {
            return $http.get('/api/users').then(handleGetSuccess, handleError('Error getting all users'));
        }

        function getById() {
            return $http.get('/api/member/get/' + $rootScope.globals.currentUser.memberId).then(handleGetSuccess, handleError('Error getting user by id'));
        }

        function create(member) {
            return $http.post('/api/users', member).then(handleSubmitSuccess, handleError('Error creating user'));
        }

        function update(member) {
            return $http.put('/api/users/' + $rootScope.globals.currentUser.memberId, member).then(handleSubmitSuccess, handleError('Error updating user'));
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
