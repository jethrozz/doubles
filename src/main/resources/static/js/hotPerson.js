function getHotPerson() {
    $('#loading').modal('show');
    $.ajax({
        url:"../users/hotPerson",
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
        url:"../users/hotPersonTopic",
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
        var html = "<div class=\"card hot_person_card\"><div class=\"card-body\"><div class=\"card-header hot_person_header\"><a href=\"../article/getMyArticle?userId="+list[i].user.userId+"\"><img src=\""+list[i].user.userimg+"\"  class=\"rounded-circle\"><span class=\"hot_nickname\">"+list[i].user.nickname+"</span></a>";
        if(list[i].isFriend == 1){
            html += "<button type=\"button\" class=\"btn btn-secondary btn-sm fllow_btn1\" >关注</button>"
        }else if(list[i].isFriend == 0){
            html += "<button type=\"button\" class=\"btn btn-secondary btn-sm fllow_btn1\" >已关注</button>"
        }else if(list[i].isFriend == 2){
            html += "<button type=\"button\" class=\"btn btn-secondary btn-sm fllow_btn1\" >相互关注</button>"
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

$(".fllow_btn1").mouseover(function(){
    console.log("mouseover");
    hotPersonfirstText = $(this).text();
    hotPersonisClick = false;
    if($(this).text() == '已关注' || $(this).text() == '相互关注'){
        $(this).text("取消关注");
    }
});

$(".fllow_btn1").mouseout(function(){
    console.log("mouseleave");
    if(!hotPersonisClick) {
        $(this).text();
    }
});
$(".fllow_btn1").click(function () {
    console.log("click");
    hotPersonisClick = true;
    var isFriend = 1;
    var friend = $(this).next().val();
    if($(this).text() == '取消关注'){
        isFriend = 1;
    }else if($(this).text() == "关注"){
        isFriend = 0;
    }
    $.ajax({
        url:"../users/followOrUnfollowUser",
        type:POST,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            friendId:friend,
            isFriend:isFriend,
            userId:sessionStorage.getItem("userId")
        },
        success:function(data,result,stauts){
            var res = JSON.parse(data);
            console.log(res);
        }
    })
});