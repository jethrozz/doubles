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
        type:"post",
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
var str = "";

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
        url:"../article/addComment",
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
