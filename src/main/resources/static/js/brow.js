/* $(document).ready(function() {
 var length,
  currentIndex = 0, //当前是第几张
  interval, //定时器，在start()函数中生成
  hasStarted = false, //是否已经开始轮播
  t = 3000; //轮播时间间隔
 length = $('.slider-panel').length;
 //将除了第一张图片隐藏
 $('.slider-panel:not(:first)').hide();
 //隐藏向前、向后翻按钮
 $('.slider-page').hide();

 //鼠标上悬时显示向前、向后翻按钮,停止滑动，鼠标离开时隐藏向前、向后翻按钮，开始滑动
 //hover方法传递两个函数，第一个是鼠标移入时的操作，第二个是鼠标移出时的操作
 $('.slider-panel, .slider-pre, .slider-next').hover(function() {
	  stop();
	  $('.slider-page').show();
	 }, 
	 function() {
	 $('.slider-page').hide();
	  start();
	 });

//bind方法让选中的jquery 对象与某个事件绑定在一起，后面传入的函数就是该事件触发时所执行的操作
//unbind方法是让选中的jquery 对象解除与某个事件的绑定。
//这里先解除后绑定是为了避免绑定之后再次绑定，以免造成事件点击一次而触发多次
$('.slider-pre').unbind('click');
$('.slider-pre').bind('click', function() {
	pre();
});
$('.slider-next').unbind('click');
$('.slider-next').bind('click', function() {
    next();
});

 /**
  * 从preIndex页翻到currentIndex页
  * preIndex 整数，翻页的起始页
  * currentIndex 整数，翻到的那页
  */
 /*function play(preIndex, currentIndex) {
 	//eq()方法会根据传入的值返回一个jquery对象,然后让该对象淡出就是fadeOut,
 	//然后选择该对象的父对象的子对象，这里的chilred()，会返回出所有的slider-panel，然后再匹配currentIndex这个页码
 	//然后淡入fadeIn
 	//这就完成了图片替换的这个逻辑
  $('.slider-panel').eq(preIndex)
  .fadeOut(500)
  .parent()
  .children()
  .eq(currentIndex)
  .fadeIn(1000);
 }
 /**
  * 向前翻页
  */
/* function pre() {
  var preIndex = currentIndex;
  currentIndex = (--currentIndex + length) % length;
  play(preIndex, currentIndex);
 }
 /**
  * 向后翻页
  */
 /*function next() {
 	//当前页加一与数组长度取模可获得新的页码
  var preIndex = currentIndex;
  currentIndex = ++currentIndex % length;
  play(preIndex, currentIndex);
 }
 /**
  * 开始轮播
  */
 /*function start() {
  if(!hasStarted) {
  hasStarted = true;
  //初始化定时器
  interval = setInterval(next, t);
  }
 }
 /**
  * 停止轮播
  */
 ?/*unction stop() {
  clearInterval(interval);
  hasStarted = false;
 }
 //开始轮播
 start();
 });*/*/*/*/

 $(document).ready(function() {
 	$('#myCarousel').carousel({
 		interval: 5000
 	}); //每隔5秒自动轮播 
 });