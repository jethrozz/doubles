
$("#btn-lg").click(function(){
	if("" != $("#userName").val()){
		if("" != $("#userPW").val()){
			login($("#userName").val(),$("#userPW").val());
		}else{
			alert("密码不能为空");
			$("#userPW").focus();
		}
	}else{
		alert("用户名不能为空");
		$("#userName").focus();
	}
})


function login(user,pwd){
	$.ajax({
		type:"post",
		url:"./userlogin",
		async:true,
		data:{
			username:user,
			password:pwd
		},
		success:function(data,stauts,result){
			var res = JSON.parse(data);
			console.log(res)
			if(res.stauts == 0){
				window.location.href = "../index"
			}
		}
	});
}
