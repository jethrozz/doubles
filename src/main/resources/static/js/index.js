
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

//评论部分的js
function subComment(e) {
	console.log(e)
	var commentBox = $(e).parent().parent().parent().parent().next();
    if(commentBox.is(':hidden')){
        commentBox.show(300);
        commentBox.next().show(300);
    }else{
        commentBox.hide(300);
        commentBox.next().hide(300);

    }
}
//回复相关js
var reply_to_id = "";//被回复者id

function reply(e) {
    reply_to_id = $(e).parent().prev().children("input").val();
	var text = $(e).parent().prev().children("div").children("a");
    console.log(text.text());
	console.log(reply_to_id);
	var str = "回复 " +text.text()+"：";
	$("#reply-input").val(str);
    $("#reply-input").focus();
}

$("#btn-reply-input").bind("click",function () {
	var reply = $("#reply-input").val();
	var i = reply.indexOf("：")
	reply = reply.substring(i+1,reply.length);
	console.log(reply);
	console.log(reply_to_id);
	if(reply != ""){
		//发出ajax请求
	}
});

function addComment(id,username,type,content,imgsrc) {
	//拼接html语句做渲染
	var str = "<li class='list-group-item'><div class='user-comment'><div class='user-comment-img comment-img'> <img src='"+
		imgsrc+
		"'width=\"20px\" height=\"20px\" /></div><div class=\"comment-content\"><input name='user_id' value='"+id+"' type=\"hidden\">"+
        "<div ><a href='#'>"+username我有一头没毛驴+"</a>&nbsp"+ content +"</div></div><div class='btn-reply'>"+
		"<a href=\"javascript:void(0);\" onclick=\"reply(this)\">回复</a></div></div></li>"
	return str;
}
/*鼠标移入检查
	关注显示:取消关注
	没有关注:显示关注
鼠标移出检查
	是否点击发送请求
	是:移出的时候不变
	否:移出的时候变
*/
/*
* 评论点击事件
* */