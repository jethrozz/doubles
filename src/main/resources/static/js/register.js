
//$("form").submit(function(e){
//	
//$("#mymodal").modal("toggle");
//});
var uid = "";

$("#userName").blur(function (e) {
    if($("#userName").val() != ""){
        $.ajax({
            url:"./checkName",
            type: "post",
            async:true,
            data: {
                username:$("#userName").val()
            },
            success: function (data,status,result) {
                console.log(result);
                var res = JSON.parse(data);
                if(res.stauts != 0){
                    var str = "该用户名已存在";
                    $("#tip").text(str);
                    $("#tip").fadeIn(1500).fadeOut(1500);
                    $("#userName").focus();
                }
            }
        })
    }
});
$("#myBtn").click(function (e) {
    if($("#userName").val() != ""){
        if($("#nickName").val() != ""){
            if($("#userPW").val() != ""){
                if($("#userBirthday").val() != ""){
                    $("#mymodal").modal("toggle");
                }else{
                    $("#userBirthday").focus();
                    alert("生日不能为空");
                }
            }else{
                $("#userPW").focus();
                alert("密码不能为空");
            }
        }else{
            $("#nickName").focus();
            alert("昵称不能为空");
        }
    }else{
        $("#userName").focus();
        alert("用户名不能为空");
    }
})
function getTheCheckBoxValue() {
    var test = $("input[name='userlike']:checked");
    console.log(test);
    var checkBoxValue = "";
    test.each(function () {
        checkBoxValue += $(this).val() + "||";
    })
    checkBoxValue = checkBoxValue.substring(0, checkBoxValue.length - 2);

    return checkBoxValue;
}
function sublike() {
    var like = getTheCheckBoxValue();
                      $.ajax({
                        url: "./userregist",
                        type: "post",
                        async:true,
                        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                        data: {
                            username:$("#userName").val(),
                            nickname:$("#nickName").val(),
                            password:$("#userPW").val(),
                            usersex: $("input[name='userSex']:checked").val(),
                            birthday:$("#userBirthday").val(),
                            usermail:$("#userEmail").val(),
                            userlike:like
                        },
                        success: function (data,stauts,result) {
                            var res = JSON.parse(data);
                            if(res.status == 0){
                                var user = res.data;
                                var id =user.userId;
                                sessionStorage.setItem("userId", id);
                                window.location.href = "/index";
                            }else{
                                alert("注册失败，请重试");
                            }
                        }
                    });
}
