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
                controller: 'ChartController',
                templateUrl: viewBase + 'chart_analysis/pr_chart_main.html',
                controllerAs: 'vm'
            })
            .when('/experiment', {
                controller: 'PopoverDemoCtrl',
                templateUrl: viewBase + 'experiment/experiment.html',
            })
            .when('/pr-house-analysis/:pid', {
                controller: 'HouseAnalysisController',
                templateUrl: viewBase + 'house_analysis/pr_house_analysis.html',
                controllerAs: 'vm'
            })
           .when('/pr-varga-analysis/:pid', {
                controller: 'VargaAnalysisController',
                templateUrl: viewBase + 'varga_analysis/pr_varga_analysis.html',
                controllerAs: 'vm'
            })
           .when('/pr-yogas/:pid', {
                controller: 'YogaAnalysisController',
                templateUrl: viewBase + 'yogas/pr_yoga_analysis.html',
                controllerAs: 'vm'
            })
           .when('/pr-nak-dasha/:pid', {
                controller: 'DashaAnalysisController',
                templateUrl: viewBase + 'dashas/pr_dasha_analysis.html',
                controllerAs: 'vm'
            })
           .when('/pr-transit/:pid', {
                controller: 'TransitAnalysisController',
                templateUrl: viewBase + 'transit/pr_transit_analysis.html',
                controllerAs: 'vm'
            })
            .when('/pr-references/:pid', {
                controller: 'ReferencesController',
                templateUrl: viewBase + 'reference/pr_references.html',
                controllerAs: 'vm'
            })
            .when('/about', {
                controller: 'AboutController',
                templateUrl: viewBase + 'about.html',
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
            var restrictedPage = $.inArray($location.path(), ['/login', '/home','/experiment']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();