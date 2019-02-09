//初始化对象
var App = function() {

    var _masterCheckbox;
    var _checkbox;

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


    //获取控制端checkbox
    _masterCheckbox =  $('input[type="checkbox"].minimal.icheck_master');

    //获取全部checkbox
    _checkbox = $('input[type="checkbox"].minimal');

    };

    //checkbox的全选功能
    var handlerCheckboxAll =  function () {
        _masterCheckbox.on("ifClicked",function (e) {
            //返回true表示为选中
            if (e.target.checked){
                _checkbox.iCheck("uncheck");

            }

            //选中状态
            else{
                _checkbox.iCheck("check");
            }
        });
    }

    //公共部分
    return {
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        getCheckbox :function () {
            return _checkbox;
        }
    }
}();
//导入这个js使其直接生效.
$(document).ready(function () {
    App.init();
});