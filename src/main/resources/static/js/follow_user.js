$(".fllow_btn").bind("mouseenter",function(){
    isClick = false;
    firstText = $(this).text();
    if($(this).text() == "已关注" || $(this).text() == "相互关注"){
        $(this).text("取消关注");
    }
}).bind("click",function(){
    if($(this).text() == "关注"){
        $(this).text("已关注");
        isClick = true;
        /*
        var fllow_btn_parent = $(this).parent().parent().parent();
        console.log(fllow_btn_parent);
        fllow_btn_parent[0].remove()
        */
        /*$.ajax({
            url:"../users/followOrUnfollowUser",
            type:POST,
            data:{
                friendId:friendId,
                isFriend:1
            },
            success:function(data,result,stauts){

            }
        })*/
    }else if($(this).text() == "取消关注"){
        //$(this).text("关注")
        isClick = true;
        /*$.ajax({
            url:"url",
            type:POST,
            data:{},
            success:function(data,result,stauts){

            }
        })*/
    }
}).bind("mouseleave",function(){
    if(!isClick){
        $(this).text(firstText);
    }
})