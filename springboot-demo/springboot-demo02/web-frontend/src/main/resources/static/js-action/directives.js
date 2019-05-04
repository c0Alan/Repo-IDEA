/**
 * 定义一个指令名为datePicker 0
 */
actionApp.directive('datePicker', function () {
    return {
        restrict: 'AC', // 限制为属性指令和样式指令。
        // 使用link方法来定义指令，在link 方法内可使用当前scope 、当前元素及元素属性。
        link: function (scope, elem, attrs) {
            // scope.treeObj = $.fn.zTree.init(elem, scope.settings);
            // 初始化jqueryui 的datePicker (jquery 的写法是$(#id').datePicker())。
            elem.datepicker();
        }
    };
});


