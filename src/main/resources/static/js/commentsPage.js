function commentsResult() {
    var fromUserId;
    var fromUserNickName
    var content;
}
function getComments() {
    $('#loading').modal('show');
    $.ajax({
        url:"../article/getCommentList",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        /*        data:{
                    userId:userId
                },*/
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                // followUserText($("#fllow"),res.data);
                // //$("#mymodal").modal("toggle");
                //indexText($("#user-article-content-text"),res.data.list.list)
                pinjieComment($("#tongzhi1"),res.data.list);
                $('#loading').modal('hide');
            }
        }
    });
}
 function pinjieComment(container,data) {
     container.empty();
     var htmlBegin = "<div class=\"day\">";
     var html = "";
     var end = "</div>";
     var set = createData(data);
     for(var x of set){
         html = html + htmlBegin + "<div class=\"date\"><h5>" + x + "</h5>" +end;
         for(var i=0;i<data.length;i++){
             if(x == data[i].createTime){
                html = html + "<div class=\"message\"><div class=\"left\"> <img src=\""+data[i].user.userimg+"\" alt=\"\"><span class=\"name\">"
                 + data[i].user.nickname +"</span><span>评论了你</span> <a href=\"../article/getArticle?articleId="+data[i].objectId+"\"><span class=\"topic\">" +subContent(data[i].commentContent)+ "</span></a></div><div class=\"right\"><span class=\"hui\">回复</span></div>"
                 + "<div class=\"repeat\"><input type=\"text\" name='repeatTxt' id=\"repeatTxt\"><button type=\"button\" id=\"repeat_btn\">回复</button><input type='hidden' name='objectId' value='"+data[i].objectId+"'><input type='hidden' name='toUserId' value='"+data[i].user.userId+"' />" + end + end;
             }
         }
         html = html + end;
     }
     container.append(html);
 }

function createData(data) {
    var map = new Map();
    var set = new Set();
    for(var i=0;i<data.length;i++){
        set.add(data[i].createTime)
    }
    return set;
}

function subContent(data) {
    if(data.length >= 20){
        data = data.substring(0,19);
        data = data + "...";
    }
    return data;
}
//通知页回复
$(document).on("click",".hui",function () {
    if($(this).parent().next().css("display")=="none"){
        $(this).parent().next().css({"display":"block"});
        $(this).parent().parent().css({"paddingBottom":"4rem"});
    }else{
        $(this).parent().next().css({"display":"none"});
        $(this).parent().parent().css({"paddingBottom":"1rem"});
    }
}).on("click","#repeat_btn",function () {
    var toUser = $(this).next().next().val();
    var object = $(this).next().val();
    var content = $(this).prev().val();
    if(content != ""){
        $.ajax({
            url:"../article/addComment",
            type: "post",
            async:true,
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data: {
                objectType:0,
                objectId:object,
                toUser:toUser,
                commentContent:content,
                type:1
            },
            success: function (data,stauts,result) {
                var res = JSON.parse(data);
                if(res.status == 0){
                    alert("回复成功");
                    $(this).prev().val("");
                }
            }
        });
    }
});

