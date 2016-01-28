(function () {

    var app = angular.module('vedicAstroApp',
        ['ngRoute', 'ngAnimate']);

    app.config(['$routeProvider', function ($routeProvider) {
        var viewBase = '/app/vedicAstroApp/views/';

        $routeProvider
            .when('/pr-chart-analysis/:pid', {
                controller: 'ChartAnalysisController',
                templateUrl: viewBase + 'chart_analysis/pr_chart_analysis.html',
                controllerAs: 'vm'
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
            .when('/login/:redirect*?', {
                controller: 'LoginController',
                templateUrl: viewBase + 'login.html',
                controllerAs: 'vm'
            })
            .otherwise({ redirectTo: '/customers' });

    }]);

    app.run(['$rootScope', '$location', 'authService',
        function ($rootScope, $location, authService) {
            
            //Client-side security. Server-side framework MUST add it's 
            //own security as well since client-based security is easily hacked
            $rootScope.$on("$routeChangeStart", function (event, next, current) {
                if (next && next.$$route && next.$$route.secure) {
                    if (!authService.user.isAuthenticated) {
                        $rootScope.$evalAsync(function () {
                            authService.redirectToLogin();
                        });
                    }
                }
            });

    }]);

}());

