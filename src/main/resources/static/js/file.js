// $(".card-text").bind("click",function(){
// 	$(location).attr('href','hpdynamic.html')
// })

$("#getDate").on("change",function () {
   if($(this).val() != ""){
       var objectId = $(this).next().val();
       $.ajax({
           url:"/users/getAlbumImgJson",
           type: "post",
           async:true,
           data: {
               date:$(this).val(),
               userId:objectId
           },
           success: function (data,status,result) {
               var res = JSON.parse(data);
               console.log(res);
               $("#album").empty();
               var html = "";
               for(i = 0;i<res.data.length;i++){
                   html += "<div class=\"card bg-light\" ><div class=\"card-header\">"+res.data[i].albumTime+" 图集</div><div class=\"card-body\"><div class=\"card-text\">";
                   for(j=0;j<res.data[i].albumList.length;j++){
                       html += "<a href=\"../article/getArticle?articleId="+res.data[i].albumList[j].articleId+"\" >"+res.data[i].albumList[j].imgSrc+"</a>";
                   }
                    html += "</div></div></div>";
               }
4
               $("#album").append(html);
           }
       })
   }
});

function backIndex(){
    window.location.href = "../index";
}