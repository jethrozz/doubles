//发起话题
$("#topic_addTopic").click(function () {
    var title = $("#topic_title").val();
    var describe = $("#topic_describe").val();
    console.log("topic_addTopic is click")
    if(title == ""){
        alert("标题不能为空");
    }else{
        $.ajax({
            url:"/topic/addTopic",
            type:"post",
            async:true,
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data:{
                title:title,
                descirbe:describe
            },
            success: function (data,stauts,result) {
                var res = JSON.parse(data);
                if(res.status == 0){
                    alert("发布成功");
                    $("#addTopic").modal("toggle");
                }
            }
        });
    }
});

//最新话题 按时间逆序排序
function NewTopic() {
    $('#loading').modal('show');

    $.ajax({
        url:"/topic/getNewTopic",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res);
            if(res.status == 0){
                var topicList = res.data;
                pinjieTopic($("#newTopic"),topicList.list);
                $('#loading').modal('hide');
            }
        }
    });
}

//最热话题 按该话题下发表的动态数量排序
function HotTopic() {
    $("#newTopic").removeClass("active");
    $("#hotTopic").addClass("active");

    $('#loading').modal('show');
    $.ajax({
        url:"/topic/getHotTopic",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        success: function (data,stauts,result) {
            var res = JSON.parse(data);
            console.log(res.data);
            if(res.status == 0){
                var topicList = res.data;
                pinjieTopic($("#hotTopic"),topicList.list);
                $('#loading').modal('hide');

            }
        }
    });
}

function pinjieTopic(container,data) {
    container.empty();
    var htmlBegin = "<div class=\"card-deck\">";
    var end = "</div>";
    var html = "";
    var imgBegin = "<div class=\"card-text hct\"><div class=\"topic_img\">";

    //一个cardcheck里最多2个card
    //一个topic_img最多2个row
    //一个row最多3个img
    //从里到外拼接  //先拼接图片
    for(var i=0;i<data.length;i++){

        var k = i+1;
        var img = "";
        var j=1;
        html = html + "<div class=\"card\" style=\"border: 1px solid #F2F2F2;margin-top: 0rem;\"><div class=\"card-body\">" +"<h4 class=\"card-title\"><a href=\"../topic/gettopic/"+data[i].topic.topicId+"\">" +data[i].topic.title+"</a></h4>" + "<small class=\"joinPers\">"+data[i].topic.fanNumber+"人参加</small>" ;


        if(data[i].imgList != null){
            var size = Object.keys(data[i].imgList).length;
            $.map(data[i].imgList,function (value,key) {

                img += "<a href='../article/getArticle?articleId="+key+"'><img "+value+"  class=\"rounded-0\"></a>";
                if(j%3 == 0 || j == size){
                    img = "<div class=\"row\">" + img + end;
                }
                j++;
            });
        }

        html = html + imgBegin + img + end +end;
        html = html + end +end;
        //
        if(k == data.length){
            html = html +end;
            container.append(html);
            html = "";
        }else if(k % 2 == 1){
            html =  htmlBegin + html;
        }else if(k % 2 == 0){
            html = html +end;
            container.append(html);
            html = "";
        }
    }
}
