
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


function getIndex() {
    $('#loading').modal('show');
	$.ajax({
        url:"../getIndex",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
/*        data:{
            userId:userId
        },*/
        success: function (data,stauts,result) {
            var res = JSON.parse(data);

            if(res.status == 0){
                // followUserText($("#fllow"),res.data);
                // //$("#mymodal").modal("toggle");
                indexText($("#user-article-content-text"),res.data.list.list)
				$('#loading').modal('hide');
            }
        }
    });
}

function indexText(container,data) {
	container.empty();
	var me = sessionStorage.getItem("userId");
	var htmlBegin = "<div class=\"card article-card myCard mt-3\"><div id=\"user-article-content-img\" class=\"mt-3 ml-3\">"
	var end = "</div>";
	var html = "";
	for(var i=0;i<data.length;i++){
		//拼接正文部分
		html = html + htmlBegin;

		if(data[i].isTransmit != 2){
			if(me == data[i].oldUser.userId){
                html = html +"<img src=\""+data[i].oldUser.userimg+"\" class=\"float-left \" width=\"50px\" height=\"50px\"><strong class=\"float-left mt-3 ml-3\"> "+"我"+"</strong>";
			}else{
                html = html +"<img src=\""+data[i].oldUser.userimg+"\" class=\"float-left \" width=\"50px\" height=\"50px\"><a href=\"../article/getMyArticle?userId="+data[i].oldUser.userId+"\"><strong class=\"float-left mt-3 ml-3\"> "+data[i].oldUser.nickname+"</strong></a>";
			}
		}else{
			if(me == data[i].nowUser.userId){
                html = html + "<img src=\""+data[i].nowUser.userimg+"\" class=\"float-left \" width=\"50px\" height=\"50px\"><strong class=\"float-left mt-3 ml-3\">"+"我"+"</strong><small class=\"float-left mt-3 ml-3\">转发</small><a href=\"../article/getMyArticle?userId="+data[i].oldUser.userId+"\"><strong class=\"float-left mt-3 ml-3\">"+data[i].oldUser.nickname+"</strong></a>";
			}else{
                html = html + "<img src=\""+data[i].nowUser.userimg+"\" class=\"float-left \" width=\"50px\" height=\"50px\"><a href=\"../article/getMyArticle?userId="+data[i].nowUser.userId+"\"><strong class=\"float-left mt-3 ml-3\">"+data[i].nowUser.nickname+"</strong></a><small class=\"float-left mt-3 ml-3\">转发</small><a href=\"../article/getMyArticle?userId="+data[i].oldUser.userId+"\"><strong class=\"float-left mt-3 ml-3\">"+data[i].oldUser.nickname+"</strong></a>";
			}
		}
		html = html + end;
		html = html + "<a href=\"/article/getArticle?articleId="+data[i].article.articleId+"\" class=\"article-link\">";
		html = html + " <div class=\"card-body\"><p class=\"card-text\">"+data[i].article.content+"</p><div class=\"my-underline\"></div><div class=\"little-tag\">";

		//拼接话题标签
		for(var j=0;j<data[i].article.artilceTopics.length;j++){
        	html = html +"<a href=\"/topic/gettopic/"+data[i].article.artilceTopics[j].topic.topicId+"\">#"+data[i].article.artilceTopics[j].topic.title+"</a>";
        	if(j != data[i].article.artilceTopics.length){
                html = html + ",";
			}
		}
		html = html + end;
		html = html + "<div class=\"little-tip\"><ul>";

		if(data[i].isTransmit != 2){
			if(me == data[i].oldUser.userId){
				html = html + "<li><a href=\"javascript:void(0);\" onclick=\"deletArtciel('"+data[i].article.articleId+"')\">删除</a></li>";
			}
		}else{
            if(me == data[i].nowUser.userId){
                html = html + "<li><a href=\"javascript:void(0);\" onclick=\"deletArtciel('"+data[i].article.articleId+"')\">删除</a></li>";
            }
		}
		html = html + "<li><a href=\"javascript:void(0);\" onclick=\"subComment(this)\">评论</a></li> <li> <ul>";
		if(data[i].isLike){
		  html = html + "<li><a href=\"javascript:void(0);\"><div  class=\"fave active\"></div></a></li>";
		}else{
          html = html + "<li><a href=\"javascript:void(0);\"><div  class=\"fave\"></div></a></li>";
		}


		html = html +"<li><div class=\"like-number\"> "+data[i].article.collectNumber+" </div></li></ul></li><li><span class=\"article-time\"> "+data[i].article.createTime+"</span></li></ul>"
		html = html + end + end + "</a>";
		//正文部分拼接结束
		//拼接评论部分

		html = html + "<div class=\"my-shadow\"></div><div id=\"article-comment\"><form class=\"mt-3 \"><div class=\"row\"><div class=\"col-7 col-lg-9 col-sm-7 mb-3\"><input type=\"text\" class=\"form-control reply-input\" placeholder=\"发表评论\"></div><div class=\"col col-lg col-sm\">" +
            "<button type=\"button\" class=\"btn btn-primary \" id=\"btn-reply-input\" onclick=\"addArticleComment(this)\">发表评论</button>" +
            "<input value=\""+data[i].article.user.userId+"\" type=\"hidden\" name=\"toUser\" />" +
            "<input value=\""+data[i].article.articleId+"\" type=\"hidden\" name=\"objectId\" /></div></div></form>";

		html = html + "<div id=\"comment-list\"><ul class=\"list-group my-comment-ul list-group-flush\">";

		for(var k = 0;k<data[i].article.commentsList.length;k++){
			var comment = data[i].article.commentsList[k];
			if(comment.type == 0){
                html = html + "<li class=\"list-group-item\"><div class=\"user-comment\"><div class=\"user-comment-img comment-img\">" +
                    "<img src=\""+comment.user.userimg+"\" width=\"20px\" height=\"20px\" />\n" +
                    "</div><div class=\"comment-content user-comment-text \">" +
                    "<input name=\"user_id\" value=\""+comment.user.userId+"\" type=\"hidden\">\n" +
                    "<div class=\"\"><a href=\"../article/getMyArticle?userId="+comment.user.userId+"\">" +
                    ""+comment.user.nickname+"</a>"+comment.commentContent+"</div></div><div class=\"btn-reply\"><a href=\"javascript:void(0);\" onclick=\"reply(this)\">回复</a></div></div></li>";
			}else{
				html = html + "<li class=\"list-group-item\"><div class=\"user-comment\"><div class=\"user-comment-img comment-img\"><img src=\""+comment.user.userimg+"\" width=\"20px\" height=\"20px\" /></div>" +
                    "<div class=\"comment-content  user-comment-text\"><input name=\"user_id\" value=\""+comment.user.userId+"\" type=\"hidden\"><div >" +
                    "<a href=\"../article/getMyArticle?userId="+comment.user.userId+"\">"+comment.user.nickname+"</a>&nbsp回复&nbsp<a href=\"../article/getMyArticle?userId="+comment.to.userId+"\">\n" +
                    ""+comment.to.nickname+"</a>\n" +
                    ""+comment.commentContent+"</div></div><div class=\"btn-reply\"><a href=\"javascript:void(0);\" onclick=\"reply(this)\">回复</a><input type=\"hidden\" value=\""+comment.user.userId+"\" name=\"replyTo\"/></div></div></li>";
			}

		}
		html = html + "</ul>" + end + end + end;

	}

	container.append(html);
}