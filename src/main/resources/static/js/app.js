$(document).ready(function(){
	//表单验证：帐号必须是纯数字并且不大于14位且不能为空，密码不能为空
	$("form :input").blur(function(){
		var parent = $(this).parent();
		if($(this).is('#userid')){
			var reg = new RegExp("^[0-9]*$");
			if(this.value == ""){
				$(this).addClass('warning');
				$(".warn1").show();
			}
/*			else if(!reg.test(this.value)){
				$(this).addClass('warning');
				$(".warn3").show();
    	}*/
/*    	else if (this.value.length <=4 || this.value.length >= 11) {
    		$(this).addClass('warning');
				$(".warn3").show();
    	}*/
		}
		if($(this).is('#userpass')){
			if(this.value == ""){
				$(this).addClass('warning');
				$(".warn2").show();
			}
		}
	})
	$("form :input").focus(function(){
		var parent = $(this).parent();
		if($(this).is('#userid')){
				$(this).removeClass('warning');
				$(".warn1").hide();
				$(".warn3").hide();
		}
		if($(this).is('#userpass')){
			$(this).removeClass('warning');
			$(".warn2").hide();
		}
	})
	$(".login").bind('click',function(){
		//登录按钮  如果用户名和密码不为空  就用AJAX提交
		/*$(".user_error").fadeIn(1000).fadeOut(1500);*/
		var username = $("#userid").val();
		var pass = $("#userpass").val();
		if(username != "" && pass != ""){
			$.post("./userlogin",{
                username:username,
                password:pass
				},function(data,textStatus){
					//返回验证信息，如果验证成功，直接在服务端进行跳转；
					//验证失败就直接返回信息，
                console.log(data);
                var res = JSON.parse(data);
                var user = res.data;
                console.log(res);

                if(res.status == 0){
                    var id =user.userId;
                    sessionStorage.setItem("userId", id);
                    window.location.href = "/index"
                }else{
                    $(".user_error").fadeIn(1000).fadeOut(1500);
                }
				});
		}
	});

  });

