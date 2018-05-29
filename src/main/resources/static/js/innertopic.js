//关注/取消关注用户

//关注按钮只会显示 已关注 和 关注 两个字样
//当为 已关注 时
// 鼠标移入时 显示为取消关注
// 鼠标点击时  如果字为 取消关注，则表示 此操作为取消关注
var innerTopic_followText = "";
var innerTopic_followisClick = false;
$(".friend_btn").mouseover(function () {
    console.log($(this).text());
    innerTopic_followText = $(this).text();
    if(innerTopic_followText == "已关注" || innerTopic_followText == "相互关注"){
        $(this).text("取消关注");
    }
});
$(".friend_btn").click(function () {
    var userId = sessionStorage.getItem("userId");
    var friendId = $(this).next().val();
    if($(this).text() == "取消关注"){
        innerTopic_followisClick = true;
        followUser(userId,friendId,1,$(this),"关注");
    }else if($(this).text() == "关注"){
        innerTopic_followisClick = true;
        followUser(userId,friendId,0,$(this),"已关注");
    }
});
$(".friend_btn").mouseout(function () {
    console.log($(this).text());
    if(!innerTopic_followisClick){
        $(this).text(innerTopic_followText);
    }
    innerTopic_followisClick = false;
})
function followUser(userId,friendId,type,container,text) {
    $.ajax({
        url:"/users/followOrUnfollowUser",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            userId:userId,
            friendId:friendId,
            isFriend:type
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                container.text(text);
                var box = $(":input[name='friendId']");
                box.each(function(){
                    if($(this).val() == friendId){
                        $(this).prev().text(text);
                    }
                });
            }
        }
    });
}
//点赞
$(function() {
    $('.fave').on('click', function() {
        if($(this).hasClass("active")){
            //有active 点击表示取消点赞
            likeOrUnlike($(this),$(this).next().val(),1)
        }else{
            //无active 点击表示点赞
            likeOrUnlike($(this),$(this).next().val(),0)
        }

    })
})
function likeOrUnlike(container,objectId,opt) {
    console.log(objectId);
    console.log(opt);
    $.ajax({
        url:"/article/addArtLike",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            type:opt,
            articleId:objectId
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                container.toggleClass("active");
                var number = parseInt(container.next().next().text());
                if(opt == 0){
                    number = number+1;
                }else{
                    number = number-1;
                }
                container.next().next().text(number);

            }
        }
    });
}
//订阅话题
var innerTopic_subsscribeText = "";
var innerTopic_isClick = false;
$("#subscribeTopic").mouseover(function () {
    console.log($(this).text());
    innerTopic_subsscribeText = $(this).text();
    if(innerTopic_subsscribeText == "已订阅"){
        $(this).text("取消订阅");
    }
});
$("#subscribeTopic").click(function () {
    var userId = sessionStorage.getItem("userId");
    var topicId = $("#topicId").val();
    if($(this).text() == "取消订阅"){
        innerTopic_isClick = true;
        subscribe(userId,topicId,"unFollow",$(this),"订阅");
    }else if($(this).text() == "订阅"){
        innerTopic_isClick = true;
        subscribe(userId,topicId,"follow",$(this),"已订阅");
    }
});
$("#subscribeTopic").mouseout(function () {
    console.log($(this).text());
    if(!innerTopic_isClick){
        $(this).text(innerTopic_subsscribeText);
    }
    innerTopic_isClick = false;
})
function subscribe(userId,topicId,opt,container,text) {
    $.ajax({
        url:"/topic/followOrUnfollowTopic",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            userId:userId,
            opt:opt,
            topicId:topicId
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                // followUserText($("#fllow"),res.data);
                container.text(text);
                window.location.reload();
            }
        }
    });
}
//回复相关js
var reply_to_id = "";//被回复者id
var str = "";

function subComment(e) {
    var commentBox = $(e).parent().parent().next();
    if(commentBox.is(':hidden')){
        commentBox.show(300);
        commentBox.next().show(300);
    }else{
        commentBox.hide(300);
        commentBox.next().hide(300);
    }
}

function reply(e) {
    //reply_to_id = $(e).parent().prev().children("input").val();
    var text = $(e).parent().prev().children("div").children("a")[0];
    var reply_input = $(e).parent().parent().parent().parent().parent().prev().children().children().children("input:first");
    str = "回复 " +text.innerText+"：";
    reply_to_id = $(e).next().val();

    reply_input.val("");
    reply_input.val(str);
    reply_input.focus();
}


function addArticleComment(e) {
    var container = $(e).parent().prev().children("input");
    var text =$(e).parent().prev().children("input").val();
    var box = $(e).parent().parent().parent().next().children("ul:first");
    var index = indexStr(text,str);
    if(index == -1 && text != ""){
        //直接评论
        var toUser = $(e).next().val();
        var object = $(e).next().next().val();
        comment(object,toUser,text,container,0,box);
    }else if(text != "") {
        //回复
        var toUser = reply_to_id;
        var object = $(e).next().next().val();
        text = text.substring(str.length,text.length);
        comment(object,toUser,text,container,1,box);
    }

}

function indexStr(str1,str2) {
    if(str2 != ""){
        if(str1.indexOf(str2) >= 0 ){
            return str1.indexOf(str2);
        }else{
            return -1;
        }
    }else{
        return -1;
    }

}

function comment(objId,toId,content,container,t,box) {
    // console.log(objId);
    // console.log(toId);
    // console.log(content);
    // console.log(container);
    // console.log(t)
    // console.log(box);
    $.ajax({
        url:"/article/addComment",
        type: "post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data: {
            objectType:0,
            objectId:objId,
            toUser:toId,
            commentContent:content,
            type:t
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                box.append(addComment(res.data));
                 container.val("");
            }
        }
    });
}


function addComment(data) {
    if(data.type == 0){
        //直接评论
        var str = "<li class=\"list-group-item\"><div class=\"user-comment\"><div class=\"user-comment-img comment-img\">"+
                "<img src=\""+data.user.userimg+"\" width=\"20px\" height=\"20px\" /></div>" +
            "<div class=\"comment-content user-comment-text \"><input name=\""+data.user.userId+"\" value=\"id\" type=\"hidden\">"+
            "<div class=\"\"><a href=\"../article/getMyArticle?userId="+data.user.userId+"\">"+data.user.nickname+"</a>&nbsp"+data.commentContent+"</div></div>" +
            "<div class=\"btn-reply\"><a href=\"javascript:void(0);\" onclick=\"reply(this)\">回复</a><input type=\"hidden\" value=\""+data.user.userId+"\" name=\"replyTo\"/> </div></div></li>";
        return str;
    }else{
        //回复
        var str = "<li class=\"list-group-item\"><div class=\"user-comment\"><div class=\"user-comment-img comment-img\"><img src=\""+data.user.userimg+"\" width=\"20px\" height=\"20px\" /></div>"+
            "<div class=\"comment-content  user-comment-text\"><input name=\""+data.user.userId+"\" value=\"id\" type=\"hidden\"><div >"+
            " <a href=\"../article/getMyArticle?userId="+data.user.userId+"\">"+data.user.nickname+"</a> &nbsp回复&nbsp<a href=\"../article/getMyArticle?userId="+data.to.userId+"\">"+data.to.nickname+"</a>&nbsp"+
            data.commentContent+"</div></div><div class=\"btn-reply\"><a href=\"javascript:void(0);\" onclick=\"reply(this)\">回复</a><input type=\"hidden\" value=\""+data.user.userId+"\" name=\"replyTo\"/></div></div></li>";
        return str;
    }
}

//富文本编辑器
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
    var content = editor.txt.html();  // 获取 Html 格式的内容

    var topicId = $("#topicId").val();
    var tag = getTheCheckBoxValue();
    var userId = sessionStorage.getItem("userId");
    if(tag.indexOf(topicId) == -1){
        tag = tag + "||" + topicId;
    }
    if(imageurl != ""){
        isHave = 1;
    }
    if(content != null){
        $.ajax({
            url: "/article/submitArticle",
            type: "post",
            async:true,
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data: {
               content:content
               ,userId:userId
                ,image:imageurl
                ,type:tag
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
});

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
        uptoken_url: '/image/getToken',
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
        flash_swf_url: '/js/plupload/Moxie.swf',  //引入flash,相对路径
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
                console.log(file.getNative());
                EXIF.getData(file.getNative(), function() {
                    printLog(EXIF.pretty(this));
                });
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
                imageurl = sourceLink+"||";
                printLog(sourceLink);

                // 插入图片到editor
                editor.cmd.do('insertHtml', '<img src="' + sourceLink + '" style="max-width:50%;max-height: 50%;"/>')
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