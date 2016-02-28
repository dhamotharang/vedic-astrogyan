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
            .when('/home', {
                controller: 'PageController',
                templateUrl: viewBase + 'chart_analysis/pr_chart_main.html',
                controllerAs: 'vm'
            })
            .when('/experiment', {
                controller: 'AccordionDemoCtrl',
                templateUrl: viewBase + 'experiment/experiment.html',
            })
            .when('/pr-house-analysis/:pid', {
                controller: 'HouseAnalysisController',
                templateUrl: viewBase + 'house_analysis/pr_house_analysis.html',
                controllerAs: 'vm'
            })
           .when('/vargas', {
                controller: 'PageController',
                templateUrl: viewBase + 'varga_analysis/vargas.html',
                controllerAs: 'vm'
            })
           .when('/pr-yogas/:pid', {
                controller: 'YogaAnalysisController',
                templateUrl: viewBase + 'yogas/pr_yoga_analysis.html',
                controllerAs: 'vm'
            })
           .when('/nak-dashas', {
                controller: 'PageController',
                templateUrl: viewBase + 'dashas/nak_dashas.html',
                controllerAs: 'vm'
            })
           .when('/zod-dashas', {
                controller: 'PageController',
                templateUrl: viewBase + 'dashas/zod_dashas.html',
                controllerAs: 'vm'
            })
           .when('/transits', {
                controller: 'PageController',
                templateUrl: viewBase + 'transits/transits.html',
                controllerAs: 'vm'
            })
            .when('/pr-references/:pid', {
                controller: 'ReferencesController',
                templateUrl: viewBase + 'reference/pr_references.html',
                controllerAs: 'vm'
            })
            .when('/profile-settings', {
                controller: 'PageController',
                templateUrl: viewBase + 'settings/profile_settings.html',
                controllerAs: 'vm'
            })
            .when('/prediction-templates', {
                controller: 'PageController',
                templateUrl: viewBase + 'settings/prediction_template_settings.html',
                controllerAs: 'vm'
            })
            .when('/prediction-outcomes', {
                controller: 'PageController',
                templateUrl: viewBase + 'settings/prediction_outcome_settings.html',
                controllerAs: 'vm'
            })
            .when('/analysis-components', {
                controller: 'PageController',
                templateUrl: viewBase + 'settings/analysis_component_setting.html',
                controllerAs: 'vm'
            })
            .when('/final-profile', {
                controller: 'PageController',
                templateUrl: viewBase + 'settings/final_profile.html',
                controllerAs: 'vm'
            })
            .when('/manage-member', {
                controller: 'PageController',
                templateUrl: viewBase + 'members/manage_members.html',
                controllerAs: 'vm'
            })
            .when('/login', {
                controller: 'LoginController',
                templateUrl: viewBase + 'login/login.html',
                controllerAs: 'vm'
            })
            .otherwise({ redirectTo: '/home' });
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
            var restrictedPage = $.inArray($location.path(), ['/login', '/home','/experiment','/profile-settings','/prediction-templates','/prediction-outcomes','/analysis-components','/final-profile','/nak-dashas','/zod-dashas','/transits','/vargas']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();