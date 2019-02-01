//初始化对象
var App = function() {
    /**
     * 私有方法
     */
    var handlerInitCheckbox = function () {
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
    }

    return {
        init:function () {
            handlerInitCheckbox();
        }
    }
}
//导入这个js使其直接生效.
$(document).ready(function () {
    App.init();
})