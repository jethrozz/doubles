//$("form").submit(function(e){
//	
//$("#mymodal").modal("toggle");
//});
var uid = "";
$("#myBtn").click(function (e) {
    console.log(1)
     $.ajax({
         url: "./userregist",
         type: POST,
         data: {
             user:{
                 username:1,
                 nickname:2,
                 password:3,
                 userSex:4,
                 birthday:5
             }
         },
         success: function (data, result) {
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

