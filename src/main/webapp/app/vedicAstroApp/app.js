(function () {
    'use strict';

    angular
        .module('vedicAstroApp', ['ngRoute', 'ngCookies', 'ngAnimate','ui.bootstrap'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
           var viewBase = '/app/vedicAstroApp/views/';

        $routeProvider
            .when('/chart/:predictionSystem/:analysisGroup', {
                controller: 'PageController',
                templateUrl: viewBase + 'chart_analysis.html',
                controllerAs: 'vm'
            })
            .when('/experiment', {
                controller: 'AccordionDemoCtrl',
                templateUrl: viewBase + 'experiment.html',
            })
            .when('/house/:predictionSystem/:analysisGroup', {
                controller: 'PageController',
                templateUrl: viewBase + 'house_analysis.html',
                controllerAs: 'vm'
            })
           .when('/vargas/:predictionSystem/:analysisGroup', {
                controller: 'PageController',
                templateUrl: viewBase + 'vargas.html',
                controllerAs: 'vm'
            })
           .when('/yogas/:predictionSystem/:analysisGroup', {
                controller: 'PageController',
                templateUrl: viewBase + 'yogas.html',
                controllerAs: 'vm'
            })
           .when('/nak-dashas/:predictionSystem/:analysisGroup', {
                controller: 'PageController',
                templateUrl: viewBase + 'nak_dashas.html',
                controllerAs: 'vm'
            })
           .when('/zod-dashas/:predictionSystem/:analysisGroup', {
                controller: 'PageController',
                templateUrl: viewBase + 'zod_dashas.html',
                controllerAs: 'vm'
            })
           .when('/transits/:predictionSystem/:analysisGroup', {
                controller: 'PageController',
                templateUrl: viewBase + 'transits.html',
                controllerAs: 'vm'
            })
            .when('/profile-settings', {
                controller: 'PageController',
                templateUrl: viewBase + 'profile_settings.html',
                controllerAs: 'vm'
            })
            .when('/prediction-templates', {
                controller: 'PageController',
                templateUrl: viewBase + 'prediction_template_settings.html',
                controllerAs: 'vm'
            })
            .when('/prediction-outcomes', {
                controller: 'PageController',
                templateUrl: viewBase + 'prediction_outcome_settings.html',
                controllerAs: 'vm'
            })
            .when('/analysis-components', {
                controller: 'PageController',
                templateUrl: viewBase + 'analysis_component_setting.html',
                controllerAs: 'vm'
            })
            .when('/final-profile', {
                controller: 'PageController',
                templateUrl: viewBase + 'final_profile.html',
                controllerAs: 'vm'
            })
            .when('/manage-member', {
                controller: 'PageController',
                templateUrl: viewBase + 'manage_members.html',
                controllerAs: 'vm'
            })
             .when('/manage-entity', {
                controller: 'PageController',
                templateUrl: viewBase + 'manage_entities.html',
                controllerAs: 'vm'
            })
             .when('/manage-admin', {
                controller: 'PageController',
                templateUrl: viewBase + 'manage_admins.html',
                controllerAs: 'vm'
            })
            .when('/login', {
                controller: 'LoginController',
                templateUrl: viewBase + 'login.html',
                controllerAs: 'vm'
            })
            .otherwise({ redirectTo: '/chart/:predictionSystem/:analysisGroup' });
    }

    run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
    function run($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/home','/experiment','/profile-settings','/prediction-templates','/prediction-outcomes','/analysis-components','/final-profile','/nak-dashas','/zod-dashas','/transits','/vargas','/manage-member','/manage-entity','/manage-admin']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();