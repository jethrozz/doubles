var imageurl = "";
var isHave = 0;
var E = window.wangEditor;
var editor = new  E('#div1', '#div2') ;
// 自定义菜单配置
editor.customConfig.menus = [
    'head',  // 标题
    'bold',  // 粗体
    'fontSize',  // 字号
    'fontName',  // 字体
    //'italic',  // 斜体
    'underline',  // 下划线
    'strikeThrough',  // 删除线
    'foreColor',  // 文字颜色
    'backColor',  // 背景颜色
    'link',  // 插入链接
    //'list',  // 列表
    //'justify',  // 对齐方式
    'quote',  // 引用
    'emoticon',  // 表情
    'image',  // 插入图片
    //'table',  // 表格
    //'video',  // 插入视频
    //'code',  // 插入代码
    //'undo',  // 撤销
    'redo'  // 重复
];
// // 配置服务器端地址
// editor.customConfig.uploadImgServer = '../image/uploadArticleImg';
// //自定义文件名
// editor.customConfig.uploadFileName = 'file';
// //定义http头
// editor.customConfig.uploadImgHeaders  = {
//     'Accept' : 'multipart/form-data'
// };
// // 隐藏“网络图片”tab
// editor.customConfig.showLinkImg = false;
// // 将图片大小限制为 10M
// editor.customConfig.uploadImgMaxSize = 10 * 1024 * 1024;
// //上传成功后执行的函数
// editor.customConfig.uploadImgHooks = {
//     customInsert: function (insertImg, result, editor) {
//         console.log(result);
//         var url =result.data;
//         console.log(url);
//         insertImg(url)
//     }
// };
// 允许上传到七牛云存储
editor.customConfig.qiniu = true
editor.create();

function clearContent() {
    editor.txt.html("");
    imageurl = "";
}
$("#sub-article").bind("click",function () {
    var content = editor.txt.html();  // 获取 JSON 格式的内容
    console.log(content);
    console.log(imageurl);
    console.log(getTheCheckBoxValue());
    if(imageurl != ""){
        isHave = 1;
    }
    if(content != null){
        $.ajax({
            url: "../article/submitArticle",
            type: "post",
            async:true,
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data: {
               content:content
               ,userId:$("#index-user-id").val()
                ,type:getTheCheckBoxValue()
            },
            success: function (data,stauts,result) {
                imageurl = "";
                var res = JSON.parse(data);
                if(res.status == 0){
                    alert("发布成功");
                    window.location.reload();
                }
            }
        })
    }
});

/*$("#sub-topic-article").bind("click",function () {
    var content = editor.txt.html();  // 获取 JSON 格式的内容
    console.log(content);
    console.log(imageurl);
    console.log($("#topicId").val());
    if(imageurl != ""){
        isHave = 1;
    }
    if(content != null){
        $.ajax({
            url: "../article/submitArticle",
            type: "post",
            async:true,
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data: {
                content:content
                ,userId:$("#index-user-id").val()
                ,image:imageurl
                ,type:$("#topicId").val()
                ,isHaveimg:isHave
            },
            success: function (data,stauts,result) {
                imageurl = "";
                var res = JSON.parse(data);
                if(res.status == 0){
                    alert("发布成功");
                    window.location.reload();
                }
            }
        })
    }
});*/


// 初始化七牛上传
uploadInit()

// 初始化七牛上传的方法
function uploadInit() {
    // 获取相关 DOM 节点的 ID
    var btnId = editor.imgMenuId;
    var containerId = editor.toolbarElemId;
    var textElemId = editor.textElemId;

    // 创建上传对象
    var uploader = Qiniu.uploader({
        runtimes: 'html5,flash,html4',    //上传模式,依次退化
        browse_button: btnId,       //上传选择的点选按钮，**必需**
        uptoken_url: '../image/getToken',
        //Ajax请求upToken的Url，**强烈建议设置**（服务端提供）
        // uptoken : '<Your upload token>',
        //若未指定uptoken_url,则必须指定 uptoken ,uptoken由其他程序生成
        unique_names: true,
        // 默认 false，key为文件名。若开启该选项，SDK会为每个文件自动生成key（文件名）
        // save_key: true,
        // 默认 false。若在服务端生成uptoken的上传策略中指定了 `sava_key`，则开启，SDK在前端将不对key进行任何处理
        domain: 'http://p8jz8nm27.bkt.clouddn.com/',
        //bucket:"doubles",// 域名，下载资源时用到，**必需**
        container: containerId,           //上传区域DOM ID，默认是browser_button的父元素，
        max_file_size: '100mb',           //最大文件体积限制
        flash_swf_url: '../js/plupload/Moxie.swf',  //引入flash,相对路径
        filters: {
            mime_types: [
                //只允许上传图片文件 （注意，extensions中，逗号后面不要加空格）
                { title: "图片文件", extensions: "jpg,gif,png,bmp" }
            ]
        },
        max_retries: 3,                   //上传失败最大重试次数
        dragdrop: true,                   //开启可拖曳上传
        drop_element: textElemId,        //拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
        chunk_size: '4mb',                //分块上传时，每片的体积
        auto_start: true,                 //选择文件后自动上传，若关闭需要自己绑定事件触发上传
        init: {
            'FilesAdded': function(up, files) {
                plupload.each(files, function(file) {
                    // 文件添加进队列后,处理相关的事情
                    printLog('on FilesAdded');
                });
            },
            'BeforeUpload': function(up, file) {
                // 每个文件上传前,处理相关的事情
                printLog('on BeforeUpload');
            },
            'UploadProgress': function(up, file) {
                // 显示进度
                printLog('进度 ' + file.percent)
            },
            'FileUploaded': function(up, file, info) {
                // 每个文件上传成功后,处理相关的事情
                // 其中 info 是文件上传成功后，服务端返回的json，形式如
                // {
                //    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
                //    "key": "gogopher.jpg"
                //  }
                printLog(info);
                // 参考http://developer.qiniu.com/docs/v6/api/overview/up/response/simple-response.html

                var domain = up.getOption('domain');
                var res = $.parseJSON(info);
                var sourceLink = domain + res.key; //获取上传成功后的文件的Url
                var date = (file.lastModifiedDate).Format("yyyy-MM-dd hh:mm:ss");
                imageurl = sourceLink+"||";
                printLog(sourceLink);

                // 插入图片到editor
                editor.cmd.do('insertHtml', '<img alt="'+date+'" src="' + sourceLink + '" style="max-width:50%;max-height: 50%; "/>')
            },
            'Error': function(up, err, errTip) {
                //上传出错时,处理相关的事情
                printLog('on Error');
            },
            'UploadComplete': function() {
                //队列文件处理完毕后,处理相关的事情
                printLog('on UploadComplete');
            }
            // Key 函数如果有需要自行配置，无特殊需要请注释

            //'Key': function(up, file) {
            //     // 若想在前端对每个文件的key进行个性化处理，可以配置该函数
            //     // 该配置必须要在 unique_names: false , save_key: false 时才生效
            //     var key = timestamp();
            //     // do something with key here
            //    return key
            // }
        }
        // domain 为七牛空间（bucket)对应的域名，选择某个空间后，可通过"空间设置->基本设置->域名设置"查看获取
        // uploader 为一个plupload对象，继承了所有plupload的方法，参考http://plupload.com/docs
    });
}

// 封装 console.log 函数
function printLog(title, info) {
    window.console && console.log(title, info);
}
function getTheCheckBoxValue() {
    var test = $("input[name='topic']:checked");
    console.log(test);
    var checkBoxValue = "";
    test.each(function () {
        checkBoxValue += $(this).val() + "||";
    })
    checkBoxValue = checkBoxValue.substring(0, checkBoxValue.length - 2);
    console.log(checkBoxValue);
    return checkBoxValue;
}

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o){
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}