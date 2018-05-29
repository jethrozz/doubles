function getHotPerson() {
    $('#loading').modal('show');
    $.ajax({
        url:"/users/hotPerson",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                var personList = res.data;
                pingjieHotPerson(personList);
                $('#loading').modal('hide')
            }
        }
    });
}

function getHotPersonTopic(topicId) {
    $('#loading').modal('show');
    $.ajax({
        url:"/users/hotPersonTopic",
        type:"post",
        async:true,
        data:{
            topicId:topicId
        },
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            if(res.status == 0){
                var personList = res.data;
                pingjieHotPerson(personList);
                $('#loading').modal('hide');
            }
        }
    });
}

function pingjieHotPerson(list) {
    $("#settings").children().children(".col-lg-9").empty();
    $("#settings").children().children(".col-lg-9");
    for(i=0;i<list.length;i++){
        if(list[i].user.username == "admin" && list[i].user.nickname == "admin" ){
            continue;
        }

        var html = "<div class=\"card hot_person_card\"><div class=\"card-body\"><div class=\"card-header hot_person_header\"><a href=\"../article/getMyArticle?userId="+list[i].user.userId+"\"><img src=\""+list[i].user.userimg+"\"  class=\"rounded-circle\"><span class=\"hot_nickname\">"+list[i].user.nickname+"</span></a>";
        if(list[i].isFriend == 1){
            html += "<button type=\"button\" class=\"btn btn-secondary btn-sm fllow_btn1 \" >关注</button>"
        }else if(list[i].isFriend == 0){
            html += "<button type=\"button\" class=\"btn btn-secondary btn-sm fllow_btn1 \" >已关注</button>"
        }else if(list[i].isFriend == 2){
            html += "<button type=\"button\" class=\"btn btn-secondary btn-sm fllow_btn1 \" >相互关注</button>"
        }
        html += "<input type='hidden' name='hotPersonId' value='"+list[i].user.userId+"'/></div><div class=\"card-text\"><div class=\"hot_person_img\"><div class=\"row\">";
        $.map(list[i].imgList,function (value,key) {
            html += "<a href='../article/getArticle?articleId="+key+"'><img "+value+"  class=\"rounded-0\"></a>";
        });
        html += "</div></div></div></div></div>";
        $("#settings").children().children(".col-lg-9").append(html);
    }
}
var hotPersonfirstText = "";
var hotPersonisClick = false;

$(document).on("mouseover",'.fllow_btn1',function(){
        hotPersonfirstText = $(this).text();
        if(hotPersonfirstText == "已关注" || hotPersonfirstText == "相互关注"){
            $(this).text("取消关注");
        }
    }).on("click",".fllow_btn1",function () {
    var userId = sessionStorage.getItem("userId");
    var friendId = $(this).next().val();
    if($(this).text() == "取消关注"){
        hotPersonisClick = true;
        followUser(userId,friendId,1,$(this),"关注");
    }else if($(this).text() == "关注"){
        hotPersonisClick = true;
        followUser(userId,friendId,0,$(this),"已关注");
    }
}).on("mouseout",".fllow_btn1",function () {
    console.log($(this).text());
    if(!hotPersonisClick){
        $(this).text(hotPersonfirstText);
    }
    hotPersonisClick = false;
});

// $(".fllow_btn1").mouseover(function () {
//     hotPersonfirstText = $(this).text();
//     if(hotPersonfirstText == "已关注" || hotPersonfirstText == "相互关注"){
//         $(this).text("取消关注");
//     }
// });
// $(".fllow_btn1").click(function () {
//     var userId = sessionStorage.getItem("userId");
//     var friendId = $(this).next().val();
//     if($(this).text() == "取消关注"){
//         hotPersonisClick = true;
//         followUser(userId,friendId,1,$(this),"关注");
//     }else if($(this).text() == "关注"){
//         hotPersonisClick = true;
//         followUser(userId,friendId,0,$(this),"已关注");
//     }
// });
// $(".fllow_btn1").mouseout(function () {
//     console.log($(this).text());
//     if(!hotPersonisClick){
//         $(this).text(hotPersonfirstText);
//     }
//     hotPersonisClick = false;
// })
function followUser(userId,friendId,type,container,text) {
    $.ajax({
        url:"/users/followOrUnfollowUser",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            userId:userId,
            friendId:friendId,
            isFriend:type
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                container.text(text);
                var box = $(":input[name='friendId']");
                box.each(function(){
                    if($(this).val() == friendId){
                        $(this).prev().text(text);
                    }
                });
            }
        }
    });
}