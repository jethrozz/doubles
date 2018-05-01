
//$("form").submit(function(e){
//	
//$("#mymodal").modal("toggle");
//});
var uid = "";
$("#myBtn").click(function(e){
	console.log(1)

   $.ajax({
    	url:"demo_test.txt",
    	type:POST,
    	data:{}
    	success:function(data,result){
    		var d = JSON.parse(data);
    		console.log(d);
    		uid = d.uid;
       	$("#mymodal").modal("toggle");
    	}});
  
})

