// 定义控制器View1 Controller ，并注入$rootScope 、， $scope 和$httpo
actionApp.controller('View1Controller', ['$rootScope', '$scope', '$http', function ($rootScope, $scope, $http) {

    // 使用$scope.$on 监听$viewContentLoaded 事件，可以在页面内容加载完成后进行一些操作。
    $scope.$on('$viewContentLoaded', function () {
        console.log('页面加载完成');
    });


    $scope.search = function () { // 在scope 内定义一个方法search ，在页面上通过ng-click 调用。
        personName = $scope.personName; // 通过$scope.personName 获取页面定义的ng-model= "personName" 的值。
        $http.get('search', { // 使用$http.get 向服务端地址search 发送get 请求。
            params: {personName: personName} // 使用params 增加请求参数。
        }).success(function (data) {
            // 将服务端返回的数据data 通过$scope.person 赋给模型person ，
            // 这样页面视图上可以通过{ {person.name} }、{ {person.age} }、{ {person.address} }来调用，
            // 且模型person 值改变后，视图是自动更新的。
            $scope.person = data;
        });
        ;

    };
}]);

actionApp.controller('View2Controller', ['$rootScope', '$scope', function ($rootScope, $scope) {
    $scope.$on('$viewContentLoaded', function () {
        console.log('页面加载完成');
    });
}]);


