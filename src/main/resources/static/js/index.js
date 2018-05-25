
var isClick = false;
/*
 * 取消关注
 * 关注
 * 
 * */
var isClick = false;
var firstText = "";
$(".fllow_btn").bind("mouseenter",function(){
	isClick = false;
	firstText = $(this).text();
	if($(this).text() == "已关注"){
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
			url:"url",
			type:POST,
			data:{},
			success:function(data,result,stauts){
				
			}
		})*/
	}else if($(this).text() == "取消关注"){
		$(this).text("关注")
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

/*鼠标移入检查
	关注显示:取消关注
	没有关注:显示关注
鼠标移出检查
	是否点击发送请求
	是:移出的时候不变
	否:移出的时候变
*/



$(".messages").bind("click",function(){
	$('#myLeft').hide();
	$("#myRight").removeClass("col-lg-9").addClass("col-lg-12");
	$("#myRight").css("padding-left","200px");
	$("#myRight").css("padding-right","200px");
});
$(".settings").bind("click",function(){
	$('#myLeft').hide();
	$("#myRight").removeClass("col-lg-9").addClass("col-lg-12");
});

$(".home_btn").bind("click",function(){
	
	if($('#myLeft').is(":hidden")){
		$('#myLeft').show();
		$("#myRight").removeClass("col-lg-12").addClass("col-lg-9");
	}
	
});

$("#myTab4").bind("click",function(){
	
	
		$(".home_btn").removeClass("active");
		console.log('645');
	
});

$(".home_btn").bind("click",function(){
	
	
});
function subComment(e) {
    var commentBox = $(e).parent().parent().parent().parent().next();
    if(commentBox.is(':hidden')){
        commentBox.show(300);
        commentBox.next().show(300);
    }else{
        commentBox.hide(300);
        commentBox.next().hide(300);
    }
}

// //回复相关js
// var reply_to_id = "";//被回复者id
//
// function reply(e) {
//     reply_to_id = $(e).parent().prev().children("input").val();
//     var text = $(e).parent().prev().children("div").children("a")[0];
//     var reply_input = $(e).parent().parent().parent().parent().parent().prev().children().children().children("input");
//     var str = "回复 " +text.innerText+"：";
//
//     reply_input.val("");
//     reply_input.val(str);
//     reply_input.focus();
// }
//
//
// $("#btn-reply-input").bind("click",function () {
//     if($("#reply-input").val() !=  ""){
//         var reply = $("#reply-input").val();
//         var i = reply.indexOf("：")
//         reply = reply.substring(i+1,reply.length);
//         console.log(reply);
//         console.log(reply_to_id);
//         if(reply != ""){
//             //发出ajax请求
//         }
// 	}else{
//         var toUser = $(this).next().val();
//         var text = $().val();
//         var object = $(this).next().next().val();
// 	}
//
//
//
//
// });
//
// function addComment(id,username,type,content,imgsrc) {
//     //拼接html语句做渲染
//     var str = "<li class='list-group-item'><div class='user-comment'><div class='user-comment-img comment-img'> <img src='"+
//         imgsrc+
//         "'width=\"20px\" height=\"20px\" /></div><div class=\"comment-content\"><input name='user_id' value='"+id+"' type=\"hidden\">"+
//         "<div ><a href='#'>"+username+"</a>&nbsp"+ content +"</div></div><div class='btn-reply'>"+
//         "<a href=\"javascript:void(0);\" onclick=\"reply(this)\">回复</a></div></div></li>"
//     return str;
// }
/*                <div class="card article-card myCard mt-3">
                    <div id="user-article-content-img" class="mt-3 ml-3">
                        @if(article.isTransmit != 2){ @}
                        <img src="${article.oldUser.userimg}" class="float-left " width="50px" height="50px">
                        <a href="../article/getMyArticle?userId=${article.oldUser.userId}"><strong class="float-left mt-3 ml-3"> ${article.oldUser.nickname}</strong></a>
                        @}else{ @}
                            <img src="${article.oldUser.userimg}" class="float-left " width="50px" height="50px">
                        <a href="../article/getMyArticle?userId=${article.nowUser.userId}"><strong class="float-left mt-3 ml-3">${article.nowUser.nickname}</strong></a>
                            <small class="float-left mt-3 ml-3">转发</small>
                        <a href="../article/getMyArticle?userId=${article.oldUser.userId}"><strong class="float-left mt-3 ml-3"> ${article.oldUser.nickname}</strong></a>
                        @ }@}
                    </div>


                    <a href="../article/getArticle?articleId=${article.article.articleId}" class="article-link">
                        <div class="card-body">
                            <p class="card-text">${article.article.content}</p>
                            <div class="my-underline"></div>
                            <div class="little-tag">
                            @for(tag in article.article.artilceTopics){ @}
                                  @if(!tagLP.last){ @}
                                        <a href="../${tag.topicId}">#${tag.topic.title}</a>,
                                    @}else{ @}
                                        <a href="../${tag.topicId}">#${tag.topic.title}</a>
                                   @ }@}
                              @  }@}
                            </div>
                            <div class="little-tip">
                                <ul>
                                    @if(article.oldUser.userId == session.user.userId){ @}
                                        <li>
                                            <a href="javascript:void(0);" onclick="deletArtciel('${article.article.articleId}')">删除</a>
                                        </li>
                                    @}@}
                                    <li>
                                        <a href="javascript:void(0);" onclick="subComment(this)">评论</a>
                                    </li>
                                    <li><span><i class="iconfont icon-icons- my-icon-size"></i> ${article.article.collectNumber}</span></li>
                                    <li><span class="article-time"> ${article.article.createTime,dateFormat="yyyy-MM-dd hh:mm:ss"}</span></li>
                                </ul>
                            </div>
                        </div>
                    </a>
                    <div class="my-shadow"></div>
                    <div id="article-comment">
                        <form class="mt-3 ">
                            <div class="row">
                                <div class="col-7 col-lg-9 col-sm-7 mb-3">
                                    <input type="text" class="form-control reply-input" placeholder="发表评论">

                                </div>
                                <div class="col col-lg col-sm">
                                    <button type="button" class="btn btn-primary " id="btn-reply-input" onclick="addArticleComment(this)">发表评论</button>
                                    <input value="${article.article.user.userId}" type="hidden" name="toUser" />
                                    <input value="${article.article.articleId}" type="hidden" name="objectId" />
                                </div>
                            </div>
                        </form>
                        <div id="comment-list">
                            <ul class="list-group my-comment-ul list-group-flush">
                            @for(comment in article.article.commentsList){ @}
                                @if(comment.type == 0){ @}
                                    <li class="list-group-item">
                                        <div class="user-comment">
                                            <div class="user-comment-img comment-img">
                                                <img src="${comment.user.userimg}" width="20px" height="20px" />
                                            </div>
                                            <div class="comment-content user-comment-text ">
                                                <input name="${comment.user.userId}" value="id" type="hidden">
                                                <div class=""><a href="../article/getMyArticle?userId=${comment.user.userId}">
                                                    ${comment.user.nickname}</a>
                                                    ${comment.commentContent}
                                                </div>
                                            </div>
                                            <div class="btn-reply">
                                                <a href="javascript:void(0);" onclick="reply(this)">回复</a>

                                            </div>
                                        </div>
                                    </li>
                                @}else{@}
                                    <li class="list-group-item">
                                        <div class="user-comment">
                                            <div class="user-comment-img comment-img">
                                                <img src="${comment.user.userimg}" width="20px" height="20px" />
                                            </div>
                                            <div class="comment-content  user-comment-text">
                                                <input name="${comment.user.userId}" value="id" type="hidden">
                                                <div >
                                                    <a href="../article/getMyArticle?userId=${comment.user.userId}">
                                                        ${comment.user.nickname}</a>
                                                    &nbsp回复&nbsp<a href="../article/getMyArticle?userId=${comment.to.userId}">
                                                    ${comment.to.nickname}</a>
                                                    ${comment.commentContent}
                                                </div>
                                            </div>
                                            <div class="btn-reply">
                                                <a href="javascript:void(0);" onclick="reply(this)">回复</a>
                                                <input type="hidden" value="${comment.user.userId}" name="replyTo"/>
                                            </div>
                                        </div>
                                    </li>
                                @}@}
                                @}@}

                            </ul>
                        </div>
                    </div>
                </div>*/
function getIndex() {
	
}