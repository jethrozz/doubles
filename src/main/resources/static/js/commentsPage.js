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
                 + "<div class=\"repeat\"><input type=\"text\" id=\"repeatTxt\"><button type=\"button\" id=\"repeat_btn\">回复</button>" + end + end;
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

goEasy.subscribe({
    channel: "newNotice",
    onMessage: function (message) {
        console.log(message);
        var data = message.content;
        var content = JSON.parse(data);
        var me = sessionStorage.getItem("userId");
        console.log(content)
        if(me != content.fromUser && me == content.toUser){
            var str =  "有人评论了您：" + content.msg;
            $("#tip").text(str);
            $("#tip").fadeIn(1500).fadeOut(3000);
        }
    }
});

/*



                我有一头没毛驴
<img src="img/1212741.jpg" alt="">
                啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦...<!-- <span>动态：</span> -->





        <div class="message">
            <div class="left">
                <img src="img/1130596.jpg" alt="">
                <span class="name">我有一头没毛驴</span>
                <span>评论了你</span>
                <span class="topic">啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦...<!-- <span>动态：</span> --></span>
            </div>
            <div class="right">
                <img src="img/1212741.jpg" alt="">
                <span class="hui">回复</span>
            </div>
            <div class="repeat">
                <input type="text" id="repeatTxt">
                <button type="button" id="repeat_btn">回复</button>
            </div>
        </div>
    </div>*/
