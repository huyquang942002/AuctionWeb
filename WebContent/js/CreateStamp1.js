
$.ajaxSetup({async:false});
var JsonList=[];
var total;
GetJson(JsonList);
function GetJsonData(id,name,type,price,introduce,picture,date,state){
	this.id=id;
	this.type=type;
	this.price=price;
	this.name=name;
	this.introduce=introduce;
	this.picture=picture;
	this.date=date;
	this.state=state;
}
function GetJson(List) {
	
	$.getJSON("CommodityServlet?type=stamp", function(result) {
		
		var json = eval(result);
		for (var i = 0; i < json.length; i++) {
			var data=new GetJsonData(json[i].id,json[i].name,json[i].type,
					json[i].price,json[i].introduce,
					json[i].picture,json[i].date,json[i].state);
			List.push(data);
			
			JsonList=List;
			total=i;
		}
		total+=1;
	})
};

function timeStampDate(time){
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "/" + month + "/" + date+" "+hour+":"+minute+":"+second;
}

function toDays(ss) {
	var s=parseInt(ss % 60); 
	var mi=parseInt((ss - s) / 60 % 60);
	var h=parseInt(((ss - s) / 60 - mi) / 60 % 24); 
	var d=parseInt((((ss - s) / 60 - mi) / 60 - h) / 24) 
	return "Còn lại:"+d+"Ngày"+h+"Giờ"+mi+"Phút"+s+"Giây";
}

function RunS(id,TotalS) {
	setInterval(function() {
		TotalS--;
		document.getElementById(id).innerHTML=toDays(TotalS);
	}
	, 1000);
}

var AddWatchBox2 = document.getElementById("watchBox2");

AddWatchDiv();
function AddWatchDiv() {
	var commodityId=1;
	$.each(JsonList,function(i,element){
		if (this.state==2) {
			return true;
		}
		var newA=document.createElement("a");
		commodityId=i+1;
		newA.href="AuctionServlet?type=stamp&id="+this.id;

		var newDiv=document.createElement("div");
		var newImg=document.createElement("img");
		newImg.src=this.picture;
		var newIntroduce=document.createElement("p");
		newIntroduce.innerText=this.introduce;
		var newCountDown=document.createElement("p");
		var nowTime = new Date();
		var TotalMS = this.date.time+259200000-nowTime.getTime();
		newCountDown.id=i;
		newCountDown.style.position="absolute";
		newCountDown.style.bottom="2px";
		AddWatchBox2.appendChild(newA);
		newA.appendChild(newImg);
		newA.appendChild(newIntroduce);
		newA.appendChild(newCountDown);
		RunS(i,TotalMS/1000);
	})
}
