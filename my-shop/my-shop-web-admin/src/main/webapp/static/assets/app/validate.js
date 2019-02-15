/**
 * function () {}();说明是一个函数对象
 */
var Validate = function () {
    /**
     * 初始化jQuery validation
     */
    var handlerInitValidate = function () {
        /**
         * 表单验证
         * @param formId
         */
        $("#inputForm").validate({
            errorElement: 'span',
            errorClass: 'help-block',

            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });
    };

    /**
     * 增加自定义验证规则
     */
    var handlerInitCustomVailidate = function () {
        $.validator.addMethod("mobile", function (value, element) {
            var length = value.length;
            var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");
    }
    return {
        /**
         * 初始化
         */
        init: function () {
            handlerInitCustomVailidate();
            handlerInitValidate();
        }
    }
}();

    $(document).ready(function () {
        Validate.init();
    });

