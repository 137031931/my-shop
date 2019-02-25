//初始化对象
var App = function() {

    //iChecked
    var _masterCheckbox;
    var _checkbox;

    //用于存放id的数组

    var _idArray;

    //默认的dropZone对象参数
    var defaultDropZoneOpts = {
        url: "",
        paramName:"dropFile",
        maxFiles: 1,// 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1,// 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传"+this.maxFiles+"个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg。",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持.",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消",
    };
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

        /**
         * 判断用户是否选择了数据项
         */
        if(_idArray.length === 0){
            $('#modal-message').html("您还没有选择任何数据项,至少选择一项");

        }

        else{

            $('#modal-message').html("您确定要删除吗");

        }
        //点击删除按钮时候弹出模态框
        $('#modal-default').modal("show");

        //选择确定删除调用删除方法
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
                            //请求成功与否都要弹出模态框,所以这里要先解绑原来的click事件
                            $("#btnModalOk").unbind("click");

                            //删除成功
                            if(data.status === 200){
                                $("#btnModalOk").bind("click",function () {
                                    //刷新页面
                                    window.location.reload();
                                });
                            }
                            //删除失败
                            else {
                                //确定按钮的事件改为隐藏模态框
                                $("#btnModalOk").bind("click",function () {
                                    $('#modal-default').modal("hide");
                                });

                            }
                            //因为无论如何都要提示信息,所以模态框是必须调用的
                            $('#modal-message').html(data.message);
                            $('#modal-default').modal("show");

                        }
                    });
                },500);

            }

        }
    };

    /**
     * 初始化dataTables
     */
    var handlerInitDataTables = function (url,columns) {
        var _dataTable = $("#dataTable").DataTable({
            "paging":true,
            "info":true,
            "lengthChange":false,
            "ordering":false,
            "processing":true,
            "searching":false,
            "serverSide":true,
            "deferRender":true,
            "ajax":{
                "url": url
            },

            "columns":columns,

            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function( settings ) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            }
        });

        return _dataTable;
    };


    var handlerInitZTree = function (url,autoParam,callback) {
        var setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                url: url,
                autoParam: autoParam,
                otherParam: {"otherParam": "zTreeAsyncTest"},
            }
        };
        $.fn.zTree.init($("#myTree"), setting);

        $("#btnModalOk").bind("click", function () {
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            var nodes = zTree.getSelectedNodes();
            //为选中
            if (nodes.length == 0) {
                alert("请先选择一个节点");
            }
            //已选择
            else {
                callback(nodes);
            }
        });
    };

    /**
     * 初始化DropZone
     * @param opts
     */
    var handerInitDropzone = function (opts) {
        //关闭dropzone的自动发现功能
        Dropzone.autoDiscover = false;
        //继承
        $.extend(defaultDropZoneOpts,opts);
        new Dropzone(defaultDropZoneOpts.id, defaultDropZoneOpts);
    };
    /**
     * 查看详情
     * @param url
     */
    var handlerShowDetail = function (url) {
        //这里通过Ajax请求html的方式将JSP装载进模态框中
        $.ajax({
            url:url,
            type:"get",
            dataType:"html",
            success:function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");

            }
        });
    };

    //公共部分
    return {
        /**
         * 初始化
         */
        init: function () {

            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        /**
         * 批量删除
         * @param url
         */
        deleteMulti:function (url) {
            handlerDeleteMulti(url);
        },

        /**
         * 初始化dataTables
         * @param url
         * @param columns
         * @returns {jQuery|*}
         */
        initDataTables:function (url,columns) {
            return handlerInitDataTables(url,columns);
        },

        /**
         * 初始化ZTree
         * @param url
         * @param autoParam
         * @param callback
         */
        initZTree: function(url,autoParam,callback){
            handlerInitZTree(url,autoParam,callback);
        },


        initDropZone: function(opts){
          handerInitDropzone(opts);
        },
        /**
         * 显示详情
         * @param url
         */
        showDetail:function (url) {
            handlerShowDetail(url);
        }

    }
}();
//导入这个js使其直接生效.
$(document).ready(function () {
    App.init();
});