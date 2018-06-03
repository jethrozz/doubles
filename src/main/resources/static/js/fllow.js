
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
                followUserText($("#fllow"),res.data);showFollow
                $('#loading').modal('hide');
            }
        }
    });
}

function showFans() {
    $('#loading').modal('show');
    var userId = sessionStorage.getItem("userId");

    $.ajax({
        url:"/users/getFansList",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            userId:userId
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);

            if(res.status == 0){
                followUserText($("#fans"),res.data);
                $('#loading').modal('hide');
            }
        }
    });
}


//拼接html 字符串
function followUserText(container,pageList) {
    console.log(pageList);
    container.empty();
    var strBegin = "<div class=\"card-deck\" > ";

    var strEnd = "</div>"
    //一个card-deck中放三个
    var htmlStr = strBegin;
    //var size = pageList.list.length;
    var j = 0;
    var p=0;
    for(i=0;i<pageList.list.length;i++){
        var k = i+1;
        j++;

        htmlStr += pingjie(pageList.list[i],pageList.list[i].user.userinfo);

        if(j == pageList.list.length || k%3 == 0){
            htmlStr += strEnd;
            container.append(htmlStr);
            htmlStr = strBegin;
        }/* else if(k%3==1&&j == pageList.list.length&&p==0){
            container.css("width","250px","float","right")
            htmlStr += strEnd;
            container.append(htmlStr);
            htmlStr = strBegin;

        }else if(k%3==1&&j == pageList.list.length) {
            container.parent().css("width","250px","float","right")
            htmlStr += strEnd;
            container.append(htmlStr);
            htmlStr = strBegin;
        } else if(k%3==2&&j == pageList.list.length&p==0){
            container.css("width","600px","float","right");
            htmlStr += strEnd;
            container.append(htmlStr);
            htmlStr = strBegin;
        } else if(k%3==2&&j == pageList.list.length){
            container.parent().css("width","600px","float","right");
            htmlStr += strEnd;
            container.append(htmlStr);
            htmlStr = strBegin;
        }*/


    }

}
function pingjie(data,info) {
    if(info =="" || info == null){
        info = "这个人很懒，什么都没有留下。"
    }
    var html = "<div class=\"card\"><img class=\"card-img-top\" src='"+data.user.userimg+"' alt=\"Card image cap\"> <div class=\"card-body\"><p class=\"card-title nickname\" ><a href='/article/getMyArticle?userId="+data.user.userId+"'>" +data.user.nickname+"</a>";

        if(data.isFriend == 2){
            html = html + "<button type=\"button\" class=\"btn btn-secondary btn-sm fllow_btn friend_btn\">相互关注</button>";
            html = html + "<input type=\"hidden\" name=\"friendId\" value=\""+data.user.userId+"\">";
        }else if(data.isFriend == 1){
            html = html + "<button type=\"button\" class=\"btn btn-secondary btn-sm fllow_btn friend_btn\">关注</button>";
            html = html + "<input type=\"hidden\" name=\"friendId\" value=\""+data.user.userId+"\">";
        }else if(data.isFriend == 0){
            html = html + "<button type=\"button\" class=\"btn btn-secondary btn-sm fllow_btn friend_btn\">已关注</button>";
            html = html + "<input type=\"hidden\" name=\"friendId\" value=\""+data.user.userId+"\">";
        }

        html = html + "</p><hr /><p class=\"card-text\">"+data.user.userinfo+"</p></div></div>";
    return html;
}
