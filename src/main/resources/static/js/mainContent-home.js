
//删除动态
function deletArtciel(articleId) {
    $.ajax({
        url:"../article/deleteArticle",
        type: "post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data: {
            articleId:articleId
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            if(res.status == 0){
                alert("删除成功");
                window.location.reload();
            }
        }
    });
}


//回复相关js
var reply_to_id = "";//被回复者id
var str = "";

function reply(e) {
    reply_to_id = $(e).parent().prev().children("input").val();
    var text = $(e).parent().prev().children("div").children("a")[0];
    var reply_input = $(e).parent().parent().parent().parent().parent().prev().children().children().children("input");
    str = "回复 " +text.innerText+"：";

    reply_input.val("");
    reply_input.val(str);
    reply_input.focus();
}


function addArticleComment(e) {
    var text =$(e).parent().prev().children("input").val();
    console.log(typeof(text));
    console.log(typeof(str));
    var index = indexStr(text,str);
    if(index == -1 && text != ""){
        //直接评论
        var toUser = $(e).next().val();
        var object = $(e).next().next().val();
        comment(object,toUser,text);
    }else {
        //回复
        var toUser = reply_to_id;
        var object = $(e).next().next().val();
        comment(object,toUser,text);
    }

}

function indexStr(str1,str2) {
    if(str1.indexOf(str2) > 0 ){
        return str1.indexOf(str2);
    }else{
        return -1;
    }
}

function comment(objId,toId,content) {
    $.ajax({
        url:"../article/addComment",
        type: "post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data: {
            objectType:0,
            objectId:objId,
            toUser:toId,
            commentContent:content
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            // if(res.status == 0){
            //     addComment();
            // }
        }
    });
}


function addComment(id,username,type,content,imgsrc) {
    //拼接html语句做渲染
    var str = "<li class='list-group-item'><div class='user-comment'><div class='user-comment-img comment-img'> <img src='"+
        imgsrc+
        "'width=\"20px\" height=\"20px\" /></div><div class=\"comment-content\"><input name='user_id' value='"+id+"' type=\"hidden\">"+
        "<div ><a href='#'>"+username+"</a>&nbsp"+ content +"</div></div><div class='btn-reply'>"+
        "<a href=\"javascript:void(0);\" onclick=\"reply(this)\">回复</a></div></div></li>"
    return str;
}