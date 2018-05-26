$(".hui").click(function(){
    if($(this).parent().next().css("display")=="none"){
        $(this).parent().next().css({"display":"block"});
        $(this).parent().parent().css({"paddingBottom":"4rem"});
    }else{
        $(this).parent().next().css({"display":"none"});
        $(this).parent().parent().css({"paddingBottom":"1rem"});
    }
})
function showChat(e){
    var target = $(e).parent().parent().parent().parent().parent();
    target.removeClass("active");
    target.removeClass("show");
    target.next().addClass("active show")
}
$("#backToPrivateList").click(function(){
    $("#nav-contact").removeClass('active show');
    $("#nav-profile").addClass("active show");
})