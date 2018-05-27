function getPrivateLetter() {
    $('#loading').modal('show');
    $.ajax({
        url:"../chatRecord/getChatRecordList",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        /*        data:{
                    userId:userId
                },*/
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            if(res.status == 0){
                pinjiePrivate($("#private .bottom ul:first"),res.data.list);
                $('#loading').modal('hide');
            }
        }
    });
}

function pinjiePrivate(container,data) {
    container.empty();

    var htmlBegin = "<li>";
    var html = "";
    var end = "</div>";
    var me = sessionStorage.getItem("userId");
    for(var i = 0;i<data.length;i++){
        html = html + htmlBegin;
        if(data[i].fromUser.username != "admin"){
            html = html + "<div class=\"left\"> <img src=\""+data[i].fromUser.userimg+"\" alt=\"\"><div><p>";
            if(me == data[i].fromUser.userId){
                html = html + "发给" + "<a href=\"../article/getMyArticle?userId="+data[i].toUser.userId+"\">"+data[i].toUser.nickname+"</a></p>";
            }else{
                html = html + "来自"+ "<a href=\"../article/getMyArticle?userId="+data[i].fromUser.userId+"\">"+data[i].fromUser.nickname+"</a></p>";
            }

            html = html + "<p>"+data[i].content+"</p><p>"+data[i].create_time+"</p>" +end +end;

            if(me == data[i].fromUser.userId){
                html = html + "<span class=\"right\" onclick=\"showChat(this,'"+data[i].toUser.userId+"')\">";
            }else{
                html = html + "<span class=\"right\" onclick=\"showChat(this,'"+data[i].fromUser.userId+"')\">";
            }
            html = html + "共<span>"+data[i].count+"</span>条对话</span>";
            html = html + "</li>";
        }
    }
    container.append(html);
}

function showChat(e,id){
    var target = $(e).parent().parent().parent().parent().parent();
    //
    $('#loading').modal('show');
    $.ajax({
        url:"../chatRecord/getChatDetail",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                data:{
                    toUserId:id
                },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            if(res.status == 0){
                pinjieChatRecord($("#talk .bottom"),res.data.list);
                target.removeClass("active");
                target.removeClass("show");
                target.next().addClass("active show")
                $('#loading').modal('hide');
            }
        }
    });

}
function pinjieChatRecord(container,data) {
    container.empty();
    var htmlBegin = "";
    var html = "";
    var end= "</div>";
    var me = sessionStorage.getItem("userId");
    for(var i=0;i<data.length;i++){
        if(me == data[i].userId){
            htmlBegin = "<div class=\"chat\">\n" +
                "            <img src=\""+data[i].from.userimg+"\" alt=\"\">\n" +
                "            <div class=\"chatarea\">\n" +
                "                <span style=\"float:right;\">你还可以输入500字</span>\n" +
                "                <textarea name=\"letter-input\" id=\"letter-input\" cols=\"69\" rows=\"3\"></textarea>\n" +
                "                <button onclick=\"sendMsg('data[i].to.userId')\">发送</button>\n" +
                "            </div>\n" +
                "        </div>";
            $("#talkObject").text(data[i].to.nickname);
            break;
        }
    }
    html = html + htmlBegin;
    html = html + "        <div class=\"community\">";
    for(var i=0;i<data.length;i++){
        if(me == data[i].userId){
            html = html + "            <div class=\"mine\">\n" +
                "                <img src=\""+data[i].from.userimg+"\" alt=\"\">\n" +
                "                <div class=\"frimess\">\n" +
                "                    <p>"+data[i].content+"</p>\n" +
                "                    <span>"+data[i].createTime+"</span>\n" +
                "                </div>\n" +
                "            </div>";
        }else{
            html = html + "            <div class=\"friend\">\n" +
                "                <img src=\""+data[i].to.userimg+"\" alt=\"\">\n" +
                "                <div class=\"frimess\">\n" +
                "                    <p>"+data[i].content+"</p>\n" +
                "                    <span>"+data[i].createTime+"</span>\n" +
                "                </div>\n" +
                "            </div>";
        }
    }
    html = html +end;

    container.append(html);
}

function sendMsg(id) {
    if($("#letter-input").val() != ""){
        var text = $.trim($("#letter-input").val());
        $.ajax({
            url:"../sendMsg",
            type:"post",
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data:{
                toUser:id,
                content:text
            },
            success:function(data,result,stauts){
                var res = JSON.parse(data);
                if(res.status == 0){
                    var html = "            <div class=\"mine\">\n" +
                        "                <img src=\""+res.data.from.userimg+"\" alt=\"\">\n" +
                        "                <div class=\"frimess\">\n" +
                        "                    <p>"+res.data.content+"</p>\n" +
                        "                    <span>"+getNowFormatDate()+"</span>\n" +
                        "                </div>\n" +
                        "            </div>";
                    $("#talk .community").prepend(html);
                    $("#letter-input").val("");
                }
            }
        })
    }
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}