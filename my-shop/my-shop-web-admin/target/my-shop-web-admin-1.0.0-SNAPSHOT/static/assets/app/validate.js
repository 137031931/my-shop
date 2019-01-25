/**
 * function () {}();说明是一个函数对象
 */
var Validate = function () {
    /**
     * 初始化jQuery validation
     */
    var handlerInitValidate = function () {
        console.log("初始化jQuery validation");
    };
    return {
        init:function () {
            handlerInitValidate();
        }
    }
}();