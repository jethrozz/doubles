var innerTopic_followText = "";
var innerTopic_followisClick = false;
$(document).on("mouseover",'.friend_btn',function(){
    innerTopic_followText = $(this).text();
    if(innerTopic_followText == "已关注" || innerTopic_followText == "相互关注"){
        $(this).text("取消关注");
    }
}).on("click",".friend_btn",function () {
    var userId = sessionStorage.getItem("userId");
    var friendId = $(this).next().val();
    if($(this).text() == "取消关注"){
        innerTopic_followisClick = true;
        followUser(userId,friendId,1,$(this),"关注");
    }else if($(this).text() == "关注"){
        innerTopic_followisClick = true;
        followUser(userId,friendId,0,$(this),"已关注");
    }
}).on("mouseout",".friend_btn",function () {
    if(!innerTopic_followisClick){
        $(this).text(innerTopic_followText);
    }
    innerTopic_followisClick = false;
});

// $(".friend_btn").mouseover(function () {
//     console.log($(this).text());
//     innerTopic_followText = $(this).text();
//     if(innerTopic_followText == "已关注" || innerTopic_followText == "相互关注"){
//         $(this).text("取消关注");
//     }
// });
// $(".friend_btn").click(function () {
//     var userId = sessionStorage.getItem("userId");
//     var friendId = $(this).next().val();
//     if($(this).text() == "取消关注"){
//         innerTopic_followisClick = true;
//         followUser(userId,friendId,1,$(this),"关注");
//     }else if($(this).text() == "关注"){
//         innerTopic_followisClick = true;
//         followUser(userId,friendId,0,$(this),"已关注");
//     }
// });
// $(".friend_btn").mouseout(function () {
//     console.log($(this).text());
//     if(!innerTopic_followisClick){
//         $(this).text(innerTopic_followText);
//     }
//     innerTopic_followisClick = false;
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