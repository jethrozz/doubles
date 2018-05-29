//点赞
$(function() {
    $('.fave').on('click', function() {
        if($(this).hasClass("active")){
            //有active 点击表示取消点赞
            likeOrUnlike($(this),$(this).next().val(),1)
        }else{
            //无active 点击表示点赞
            likeOrUnlike($(this),$(this).next().val(),0)
        }

    })
})
function likeOrUnlike(container,objectId,opt) {

    $.ajax({
        url:"/article/addArtLike",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            type:opt,
            articleId:objectId
        },
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                container.toggleClass("active");
                var box = container.parent().next().children(".like-number");
                var number = parseInt(box.text());
                if(opt == 0){
                    number = number+1;
                }else{
                    number = number-1;
                }
                box.text(number);

            }
        }
    });
}