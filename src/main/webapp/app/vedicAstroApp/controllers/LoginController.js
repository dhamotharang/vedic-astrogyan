(function () {
    'use strict';

    angular
        .module('vedicAstroApp')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthService', 'FlashService'];
    function LoginController($location, AuthService, FlashService) {
        var vm = this;

        vm.login = login;

        (function init() {
            // reset login status
        	AuthService.clearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            AuthService.login(vm.username, vm.password, function (response) {
            	
                if (response.success) {
                	console.log("Response :" + response.responseData);
                    AuthService.setCredentials(vm.username, vm.password, response.responseData);
                    $location.path('/chart/Prashara/ChartAnalysis');
                    
                } else {
                	
                    FlashService.error(response.failureReason.errorMessage);
                    vm.dataLoading = false;
                }
            });
        };
    }

})();
