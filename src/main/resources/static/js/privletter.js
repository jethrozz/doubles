
//取消
$(".call_off").bind("click",function(){
	// $(location).attr('href','homepage.html');
    //返回上一页
	history.go(-1);
});

function sendMsg(id) {
    if($("#letter-input").val() != ""){
        var text = $.trim($("#letter-input").val());
    	$.ajax({
            url:"../chatRecord/sendMsg",
            type:POST,
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data:{
                toUser:id,
                content:text,
            },
            success:function(data,result,stauts){
                var res = JSON.parse(data);
                console.log(res);
            }
        })
	}
}
