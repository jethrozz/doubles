
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
            console.log(data);
            var res = JSON.parse(data);
            var user = res.data;
            console.log(res);
            var id =user.userId;
            sessionStorage.setItem("userId", id);
            if(res.status == 0){
               window.location.href = "../index"
            }else{
                //alert("用户名或密码错误")
            }
        }
    });
}
