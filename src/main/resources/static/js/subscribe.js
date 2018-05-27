goEasy = new GoEasy({
        appkey: "BS-5dbbce5c671147d5a2ab9de9e977c31b"
})

//接收评论消息
goEasy.subscribe({
    channel: "newNotice",
    onMessage: function (message) {
        var data = message.content;
        var content = JSON.parse(data);
        var me = sessionStorage.getItem("userId");
        if(me != content.fromUser && me == content.toUser){
            var str =  "有人评论了您：" + content.msg;
            $("#tip").text(str);
            $("#tip").fadeIn(1500).fadeOut(3000);
        }
    }
});
//接收私聊
goEasy.subscribe({
    channel: "newMessage",
    onMessage: function (message) {
        var data = message.content;
        var content = JSON.parse(data);
        var me = sessionStorage.getItem("userId");

        if(me == content.toUser && me != content.userId){
            var str = "您的好友" + content.from.nickname + "向您发送了私信 \n" + "\""+content.content+"\"";
            $("#tip").text(str);
            $("#tip").fadeIn(1500).fadeOut(3000);
        }
    }
});

//接收动态消息
goEasy.subscribe({
    channel: "newArticle",
    onMessage: function (message) {
        var data = message.content;
        var content = JSON.parse(data);
        var me = sessionStorage.getItem("userId");
        if(me != content.data.belongUser && me == content.data.pushUser) {
            var str = "您的好友发表了新动态";
            $("#tip").text(str);
            $("#tip").fadeIn(1500).fadeOut(3000);
        }
    }
});

//接收话题推送
goEasy.subscribe({
    channel: "newTopicArticle",
    onMessage: function (message) {
        var data = message.content;
        var content = JSON.parse(data);
        var me = sessionStorage.getItem("userId");
        console.log(content)
        if(me != content.data.belongUser && me == content.data.pushUser) {
            var str = "您关注的话题有人发表了新动态";
            $("#tip").text(str);
            $("#tip").fadeIn(1500).fadeOut(3000);
        }
    }
});
