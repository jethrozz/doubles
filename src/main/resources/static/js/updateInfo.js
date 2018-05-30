//修改资料
$(".reser_btn").on("click",function () {
	var nickname = $("#nickName").val();
	var sex = $("input[name='sexRadios']:checked").val();
	var birthday = $("#userBirthday").val();
	var info = $("#userInfo").val();
	if(nickname == ""){
        alert("用户昵称不能为空");
	}else{
		if(birthday == ""){
			alert("出生日期不能为空");
		}else{
			if(info == ""){
				info = "这个人很懒，什么都没有留下...";
			}
            $.ajax({
                url:"/users/updateInfo",
                type:"post",
                async:true,
                contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                data:{
                    birthday:birthday,
                    nickname:nickname,
                    usersex:sex,
                    userinfo:info
                },
                success: function (data,stauts,result) {
                    var res = JSON.parse(data);
                    if(res.status == 0){
                        alert("修改成功");
                    }
                }
            });
		}
	}
});

//修改密码
$(".s_update").bind("click",function(){
	$('#exampleModal').modal('hide');
	$(".modal-backdrop").remove();
	$("body").removeClass('modal-open');
	if($("#oldPSW").val() != "" && $("#newPSW1").val() != "" && $("#newPSW").val() != ""){
        var old = $("#oldPassword").val();
        if($("#oldPSW").val() != old){
            alert("您输入的旧密码不正确。");
            $("#oldPSW").focus();
        }else if($("#newPSW1").val() != $("#newPSW").val()){
            alert("两次新密码不一致，请重新输入。");
            $("#newPSW1").focus();
		}else{
            $.ajax({
                url:"/users/updateInfo",
                type:"post",
                async:true,
                contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                data:{
                    password:$("#newPSW1").val()
                },
                success: function (data,stauts,result) {
                    var res = JSON.parse(data);
                    if(res.status == 0){
                        alert("修改成功");
                    }
                }
            });
		}
	}
});
//取消按钮
$(".cancel_btn").bind("click",function(){
	$(location).attr('href', '/index'); 
});

//修改头像
//图片遮罩效果
$(".mask").hover(function() {
    $(this).addClass('active');
    $(this).text('修改');
}, function() {
    $(this).removeClass('active');
    $(this).text('');
});

// 初始化七牛上传
uploadInit();
var imageurl = "";
// 初始化七牛上传的方法
function uploadInit() {
    // 创建上传对象
    var uploader = Qiniu.uploader({
        runtimes: 'html5,flash,html4',    //上传模式,依次退化
        browse_button: "mask",       //上传选择的点选按钮，**必需**
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
        // container: containerId,           //上传区域DOM ID，默认是browser_button的父元素，
        max_file_size: '100mb',           //最大文件体积限制
        flash_swf_url: '/js/plupload/Moxie.swf',  //引入flash,相对路径
        filters:{
            mime_types : [ //只允许上传图片和zip文件
                { title : "img", extensions : "png,jpg,jpeg" },
            ],
            max_file_size : '2048kb', //最大只能上传2mb的文件
            prevent_duplicates : true //不允许选取重复文件
        },
        max_retries: 3,                   //上传失败最大重试次数
        dragdrop: false,                   //开启可拖曳上传
        // drop_element: textElemId,        //拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
        chunk_size: '4mb',                //分块上传时，每片的体积
        auto_start: true,                 //选择文件后自动上传，若关闭需要自己绑定事件触发上传
        init: {
            'FilesAdded': function(up, files) {
                if(files.length >1){
                    alert("一次最多上传一个文件");
                    uploader.removeFile(files[0]);
                }
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

                var domain = up.getOption('domain');
                var res = $.parseJSON(info);
                var sourceLink = domain + res.key; //获取上传成功后的文件的Url

				imageurl = sourceLink
                $("#userimg").attr({
                    "src": imageurl
                });
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
//最后给"开始上传"按钮注册事件
if(document.getElementById('up_btn')!=null)
    document.getElementById('up_btn').onclick = function(e){
        if(imageurl != ""){
            $.ajax({
                url:"/users/updateInfo",
                type:"post",
                async:true,
                contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                data:{
                    userimg:imageurl
                },
                success: function (data,stauts,result) {
                    var res = JSON.parse(data);
                    if(res.status == 0){
                        alert("修改成功");
                    }
                }
            });
		}
    }