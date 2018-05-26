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
                "                <textarea name=\"\" id=\"\" cols=\"69\" rows=\"3\"></textarea>\n" +
                "                <input type=\"hidden\" name=\"touserId\" value=\""+data[i].to.userId+"\">\n" +
                "                <button>发送</button>\n" +
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

/*

<li><div class="left"><img src="http://p8jz8nm27.bkt.clouddn.com/kenan.png" alt=""><div><p>来自<a href="../article/getMyArticle?userId=50c6d15759cf11e8afae525400864554">我有一头没毛驴</a></p><p>不吃，我只喝水。</p><p>2018-05-26 09:20:35</p></div></div><span class="right" onclick="showChat(this,'50c6d15759cf11e8afae525400864554')">共<span>3</span>条对话</span></li>

 */