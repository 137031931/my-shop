//初始化对象
var App = function() {

    //iChecked
    var _masterCheckbox;
    var _checkbox;

    //用于存放id的数组

    var _idArray;

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

    /**
     *     批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new Array();

        //将选中元素加入数组
        //console.log(_checkbox.length);
        //便利checkbox
        _checkbox.each(function () {
            var _id = $(this).attr("id")
            if(_id != null && _id != "undefine" && $(this).is(":checked")){
                _idArray.push(_id);
            }
        });

        if(_idArray.length === 0){
            $('#modal-message').html("您还没有选择任何数据项,至少选择一项");

        }
        else{

            $('#modal-message').html("您确定要删除吗");

        }

        $('#modal-default').modal("show");

        $("#btnModalOk").bind("click",function () {
            del();
        });

        /**
         * 当前函数的私有函数,删除数据
         */
        function del() {

            $('#modal-default').modal("hide");

            //如果没有选择数据项
            if(_idArray.length === 0 ){

            }
            //删除操作
            else{
                //这里延迟执行
                setTimeout(function () {
                    $.ajax({
                        "url":url,
                        "type":"POST",
                        //这里是将请求变为同步请求,即代码从上到下执行
                        // "async":false,
                        "data":{"ids":_idArray.toString()},
                        "dataType":"JSON",
                        "success":function (data) {
                            //删除成功
                            if(data.status === 200){
                                window.location.reload();
                                window.alert("删除成功")
                            }
                            //删除失败
                            else {
                                $("#btnModalOk").unbind("click");
                                $("#btnModalOk").bind("click",function () {
                                    $('#modal-default').modal("hide");
                                });
                                $('#modal-message').html(data.message);
                                $('#modal-default').modal("show");

                            }
                        }
                    });
                },500);

            }

        }
    };

    //公共部分
    return {
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        getCheckbox :function () {
            return _checkbox;
        },

        deleteMulti:function (url) {
            handlerDeleteMulti(url);
        }
    }
}();
//导入这个js使其直接生效.
$(document).ready(function () {
    App.init();
});