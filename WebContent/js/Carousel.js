var timer=null;

var NowImageNumber=0;
var NextImageNumber=0;


StartPlay();


function StartPlay()
{
	timer = setInterval(function(){
		NextImageNumber++;
		if(NextImageNumber>3)
		{
			NextImageNumber=0;
		}
		ScrollPlay();
		NowImageNumber=NextImageNumber;
		
	},2000);
}


function ScrollPlay()
{
	$("#List li").eq(NextImageNumber).addClass("FillSquare").siblings().removeClass("FillSquare");

	if(NowImageNumber<NextImageNumber)
	{

		$('#ImgBox img').eq(NowImageNumber).stop(true,true).animate({"left":"-1000px"});

	    $("#ImgBox img").eq(NextImageNumber).css("left","900px").stop(true,true).animate({"left":"0"});
	}

	else if(NowImageNumber>NextImageNumber)
	{

		$('#ImgBox img').eq(NowImageNumber).stop(true,true).animate({"left":"900px"});

	    $("#ImgBox img").eq(NextImageNumber).css("left","-1000px").stop(true,true).animate({"left":"0"});
	}
}

$("#List li").mouseover(function()
{

	clearInterval(timer);
	
	NextImageNumber=$(this).index();
	ScrollPlay();
	NowImageNumber=NextImageNumber;
}).mouseout(function()
{
	StartPlay();
});
