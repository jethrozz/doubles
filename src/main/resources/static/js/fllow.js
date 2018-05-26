
function showFollow() {
    $('#loading').modal('show');
    var userId = sessionStorage.getItem("userId");

    $.ajax({
        url:"../users/getFollowList",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            userId:userId
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                followUserText($("#fllow"),res.data);
                $('#loading').modal('hide');
            }
        }
    });
}

function showFans() {
    $('#loading').modal('show');
    var userId = sessionStorage.getItem("userId");

    $.ajax({
        url:"../users/getFansList",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            userId:userId
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                followUserText($("#fans"),res.data);
                $('#loading').modal('hide');
            }
        }
    });
}


//拼接html 字符串
function followUserText(container,pageList) {
    container.empty();
    var strBegin = "<div class=\"card-deck\" > ";

    var strEnd = "</div>"
    //一个card-deck中放三个
    var htmlStr = strBegin;
    //var size = pageList.list.length;
    var j = 0;
    for(i=0;i<pageList.list.length;i++){
        var k = i+1;
        j++;
        htmlStr += pingjie(pageList.list[i].nickname,pageList.list[i].userimg,pageList.list[i].userinfo);
        if(j == pageList.list.length || k%3 == 0){
            htmlStr += strEnd;
            container.append(htmlStr);
            htmlStr = strBegin;
        }

    }
}
function pingjie(nickname,imgurl,info) {
    if(info =="" || info == null){
        info = "这个人很懒，什么都没有留下。"
    }
    return "<div class=\"card\"><img class=\"card-img-top\" src='"+imgurl+"' alt=\"Card image cap\"> <div class=\"card-body\"><p class=\"card-title nickname\" >" +nickname+"<button type=\"button\" class=\"btn btn-secondary btn-sm fllow_btn\">已关注</button></p><hr /><p class=\"card-text\">"+info+"</p></div></div>";
}
