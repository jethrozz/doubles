//关注
var homePagefirstText = "";
var homePageisClick = false;

$(".fllow_btn").mouseover(function(){
    console.log("mouseover");
    homePagefirstText = $(this).text();
    homePageisClick = false;
    if($(this).text() == '已关注' || $(this).text() == '相互关注'){
        $(this).text("取消关注");
    }
});

$(".fllow_btn").mouseout(function(){
    console.log("mouseleave");
    if(!homePageisClick) {
        $(this).text();
    }
});
$(".fllow_btn").click(function () {
    console.log("click");
    homePageisClick = true;
    var isFriend = 1;
    var friend = $(this).next().val();
    if($(this).text() == '取消关注'){
        isFriend = 1;
    }else if($(this).text() == "关注"){
        isFriend = 0;
    }
    $.ajax({
        url:"../users/followOrUnfollowUser",
        type:POST,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            friendId:friend,
            isFriend:isFriend,
            userId:sessionStorage.getItem("userId")
        },
        success:function(data,result,stauts){
            var res = JSON.parse(data);
            console.log(res);
        }
    })
});



//返回首页
$(".back_btn").bind("click",function(){
	$(location).attr('href', 'index.html'); 
})


//评论部分的js
function subComment(e) {
	console.log(e)
	var commentBox = $(e).parent().parent().parent().parent().next();
    if(commentBox.is(':hidden')){
        commentBox.show(300);
        commentBox.next().show(300);
    }else{
        commentBox.hide(300);
        commentBox.next().hide(300);

    }
}

//评论框
$(document).ready(function() {
 $("#reply-input").focus(function(){
     $(this).animate({"width":"98%","height":"100px"})
     }).blur(function(){
         $(this).animate({"width":"98%","height":"30px"})
         });
});

//回复相关js
var reply_to_id = "";//被回复者id

function reply(e) {
    reply_to_id = $(e).parent().prev().children("input").val();
	var text = $(e).parent().prev().children("div").children("a");
    console.log(text.text());
	console.log(reply_to_id);
	var str = "回复 " +text.text()+"：";
	$("#reply-input").val(str);
    $("#reply-input").focus();
}

$("#btn-reply-input").bind("click",function () {
	var reply = $("#reply-input").val();
	var i = reply.indexOf("：")
	reply = reply.substring(i+1,reply.length);
	console.log(reply);
	console.log(reply_to_id);
	if(reply != ""){
		//发出ajax请求
	}
});

function addComment(id,username,type,content,imgsrc) {
	//拼接html语句做渲染
	var str = "<li class='list-group-item'><div class='user-comment'><div class='user-comment-img comment-img'> <img src='"+
		imgsrc+
		"'width=\"20px\" height=\"20px\" /></div><div class=\"comment-content\"><input name='user_id' value='"+id+"' type=\"hidden\">"+
        "<div ><a href='#'>"+username我有一头没毛驴+"</a>&nbsp"+ content +"</div></div><div class='btn-reply'>"+
		"<a href=\"javascript:void(0);\" onclick=\"reply(this)\">回复</a></div></div></li>"
	return str;
}

//私信
$(".letters").bind("click",function(){
	$(location).attr('href', 'privateletter.html'); 
})


// $(".img_file").bind("click",function(){
// 	$(location).attr('href','file.html')
// })
//
function backIndex(){
	window.location.href = "../index";
}
//图集
function toAlbum(userId) {
    window.location.href = "";
}
