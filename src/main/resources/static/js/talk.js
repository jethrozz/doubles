function sendMsg(id) {
    if($("#letter-input").val() != ""){
        var text = $.trim($("#letter-input").val());
        $.ajax({
            url:"../sendMsg",
            type:"post",
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data:{
                toUser:id,
                content:text,

            },
            success:function(data,result,stauts){
                var res = JSON.parse(data);
                if(res.status == 0){
                    console.log(res.data)
                    var html = "            <div class=\"mine\">\n" +
                        "                <img src=\""+res.data.from.userimg+"\" alt=\"\">\n" +
                        "                <div class=\"frimess\">\n" +
                        "                    <p>"+res.data.content+"</p>\n" +
                        "                    <span>"+getNowFormatDate()+"</span>\n" +
                        "                </div>\n" +
                        "            </div>";
                    $("#talk .community").prepend(html);
                    $("#letter-input").val("");
                }
            }
        })
    }
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}