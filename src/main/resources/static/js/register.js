//$("form").submit(function(e){
//	
//$("#mymodal").modal("toggle");
//});
var uid = "";

$("#myBtn").click(function (e) {
    console.log(1)
    if($("#userName").val() != ""){
        if($("#nickName").val() != ""){
            if($("#userPW").val() != ""){
                if($("#userBirthday").val() != ""){
                    $.ajax({
                        url: "./userregist",
                        type: "post",
                        async:true,
                        data: {
                            username:$("#userName").val(),
                            nickname:$("#nickName").val(),
                            password:$("#userPW").val(),
                            userSex: $("input[name='userSex']:checked").val(),
                            birthday:$("#userBirthday").val()
                        },
                        success: function (data,stauts,result) {
                            var res = JSON.parse(data);
                            console.log(res);
                            if(res.stauts == 0){
                                uid = res.msg;
                                $("#mymodal").modal("toggle");
                            }else{
                                alert("注册失败，请重试");
                            }
                        }
                    });
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
    var checkBoxValue = "";
    test.each(function () {
        checkBoxValue += $(this).val() + "_";
    })
    checkBoxValue = checkBoxValue.substring(0, checkBoxValue.length - 1);
    return checkBoxValue;
}

