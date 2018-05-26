function getMyArticle(userId) {

    window.location.href = "../article/getMyArticle?userId="+userId;

    // $('#loading').modal('show');
    // var userId = sessionStorage.getItem("userId");
    // $.ajax({
    //     url:"../article/getArticleList",
    //     type:"post",
    //     async:true,
    //     contentType : "application/x-www-form-urlencoded; charset=UTF-8",
    //             data:{
    //                 userId:userId
    //             },
    //     success: function (data,stauts,result) {
    //         var res = JSON.parse(data);
    //
    //         if(res.status == 0){
    //             articleText($("#user-article-content-text"),res.data.list.list)
    //             $('#loading').modal('hide');
    //         }
    //     }
    // });
}





















function articleText(container,data) {
    container.empty();
    var htmlBegin = "<div class=\"card article-card \">";
    var end = "</div>";
    var html = "";

    for(var i=0; i<data.length; i++){
        html = html + htmlBegin;
        html = html + "<a href=\"../article/getArticle?articleId="+data[i].articleId+"\" class=\"article-link\"><div class=\"card-body\">";
        html = html + "<p class=\"card-text\">"+data[i].content+"</p><div class=\"my-underline\"></div>"
        html = html + "<div class=\"little-tag\">"
        //拼接话题
        for(var j=0;j<data[i].artilceTopics.length;j++){
            html = html + "<a href=\"../"+data[i].artilceTopics[j].topic.topicId+"\">#"+data[i].artilceTopics.topic.title+"</a>";
            if(j != data[i].article.artilceTopics.length){
                html = html + ","
            }
        }
        html = html + end;
        html = html + "<div class=\"little-tip\"><ul><li><a href=\"javascript:void(0);\" onclick=\"deletArtciel('"+data[i].articleId+"')\">删除</a></li><li><a href=\"javascript:void(0);\" onclick=\"subComment(this)\">评论</a></li>" +
            "<li><span><i class=\"iconfont icon-icons- my-icon-size\"></i> "+data[i].collectNumber+"</span></li>\n" +
            "<li><span class=\"article-time\">"+data[i].createTime+"</span></li></ul>\n";
        html = html + end +"</a>";

        //拼接评论
        html = html + "<div class=\"my-shadow\"></div><div id=\"article-comment\"><form class=\"mt-3 \"><div class=\"row\"><div class=\"col-9 col-lg-10 col-sm-9\"><input type=\"text\"  class=\"form-control reply-input\" placeholder=\"发表评论...\"></div><div class=\"col col-lg col-sm\"><button type=\"button\" id=\"btn-reply-input\" class=\"btn btn-primary \">发表评论</button>" +
            "<input value=\""+data[i].user.userId+"\" type=\"hidden\" name=\"toUser\" />" +
            "<input value=\""+data[i].articleId+"\" type=\"hidden\" name=\"objectId\" />" +
            "</div></div></form>";

        html = html + "<div id=\"comment-list\"><ul class=\"list-group my-comment-ul list-group-flush\">";

        for(var k=0;k<data[i].commentsList.length;k++){
            var comment = data[i].commentsList[k];
            if(comment.type == 0){
                html = html + " <li class=\"list-group-item\"><div class=\"user-comment\"><div class=\"user-comment-img comment-img\"><img src=\""+comment.user.userimg+"\" width=\"20px\" height=\"20px\" /></div>";
                html = html + "<div class=\"comment-content\"><input name=\"user_id\" value=\""+comment.user.userId+"\" type=\"hidden\">\n" +
                    "<div class=\"\">\n" +
                    "<a href=\"../article/getMyArticle?userId=\""+comment.user.userId+">"+comment.user.nickname+"</a>"+comment.commentContent+"</div></div><div class=\"btn-reply\"><a href=\"javascript:void(0);\" onclick=\"reply(this)\">回复</a>";
                html = html + end + end +"</li>";
            }else{
                html = html + "<li class=\"list-group-item\"><div class=\"user-comment\"><div class=\"user-comment-img comment-img\"><img src=\""+comment.user.userimg+"\" width=\"20px\" height=\"20px\" /></div>";
                html = html + "<div class=\"comment-content\"><input name=\"user_id\" value=\""+comment.user.userId+"\" type=\"hidden\"><div ><a href=href=\"../article/getMyArticle?userId="+comment.user.userId+"\">"+comment.user.nickname+"</a>&nbsp回复&nbsp<a href=\"../article/getMyArticle?userId="+comment.to.userId+"\">"+comment.to.nickname+"</a> "+comment.commentContent+"";
                html = html + end + end + "<div class=\"btn-reply\"><a href=\"javascript:void(0);\" onclick=\"reply(this)\" >回复</a><input type=\"hidden\" value=\"\" name=\"replyTo\"/></div>";
                html = html + end + "</li>";
            }
        }
        html = html + "</ul>" +  end + end + end;
    }

    container.append(html);
}