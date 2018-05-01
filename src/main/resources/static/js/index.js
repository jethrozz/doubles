
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