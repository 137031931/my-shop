//初始化对象
var App = function() {
    /**
     * 私有方法
     */
    var handlerInitCheckbox = function () {
        //iCheck for checkbox and radio inputs
        //激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
    };
    _msterCheckbox =  $('input[type="checkbox"].minimal.icheck_master');

    return {
        init: function () {
            handlerInitCheckbox();
        }
    }
}();
//导入这个js使其直接生效.
$(document).ready(function () {
    App.init();
});