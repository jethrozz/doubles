$("#myself").click(function () {
   window.location.href = "/users/myself";
});

//点赞
$(".like").on("click",function () {

    if($(this).text() == "已喜欢"){
        //取消喜欢
        likeOrUnlike($(this),$("#hp_articleId").val(),1);
   }else if($(this).text() == "喜欢"){
        //喜欢
        likeOrUnlike($(this),$("#hp_articleId").val(),0)
   }
});
function likeOrUnlike(container,objectId,opt) {
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
            if(res.status == 0){
                if(opt == 0){
                    container.text("已喜欢");
                }else{
                    container.text("喜欢");
                }
            }
        }
    });
}
//转发js
$(".transmit").on("click",function () {
    if($(this).text() == "转载"){
        transmit($("#hp_articleId").val(),$(this));
    }else if($(this).text() == "已转载"){
        unTransmit($("#hp_articleId").val(),$(this));
    }
});
function transmit(objectId,container) {
    $.ajax({
        url:"/article/transmit",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            type:0,
            contentId:objectId
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            if(res.status == 0){
                container.text("已转发");
            }
        }
    });
}
function unTransmit(objectId,container) {
    $.ajax({
        url:"/article/deleteTransmit",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            articleId:objectId
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            if(res.status == 0){
                container.text("转发");
            }
        }
    });
}
//返回首页
$(".back_btn").bind("click",function(){
	$(location).attr('href', '/index');
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

function backIndex(){
	window.location.href = "../index";
}
