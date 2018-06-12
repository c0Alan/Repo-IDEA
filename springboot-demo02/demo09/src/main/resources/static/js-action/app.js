/**
 *
 */

// 定义模块actionApp ，并依赖于路由模块ngRoute
var actionApp = angular.module('actionApp', ['ngRoute']);

// 配置路由，并注入$routeProvider 来配置。
actionApp.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/oper', { // 此处定义的是某个页面的路由名称。
        controller: 'View1Controller', // 此处定义的是当前页而使用的控制器.
        templateUrl: 'views/view1.html', // 此处定义的要加载的真实页面。
    }).when('/directive', {
        controller: 'View2Controller',
        templateUrl: 'views/view2.html',
    });

}]);
