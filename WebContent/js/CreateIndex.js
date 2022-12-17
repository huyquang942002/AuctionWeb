
$.ajaxSetup({async:false});

var JsonList=[];
var JsonListStamp=[];
GetJson(JsonList);
GetJsonStamp(JsonListStamp);
function GetJsonData(id,type,price,introduce,picture,date,state){
	this.id=id;
	this.type=type;
	this.price=price;
	this.introduce=introduce;
	this.picture=picture;
	this.date=date;
	this.state=state;
}
function GetJson(List) {
	
	$.getJSON("CommodityServlet?type=book", function(result) {
		var json = eval(result);
		for (var i = 0; i < json.length; i++) {
			var data=new GetJsonData(json[i].id,json[i].type,
					json[i].price,json[i].introduce,
					json[i].picture,json[i].date,json[i].state);
			List.push(data);
			JsonList=List;
		}
	})
};

function GetJsonStamp(List) {
	
	$.getJSON("CommodityServlet?type=stamp", function(result) {
		
		var json = eval(result);
		for (var i = 0; i < json.length; i++) {
			var data=new GetJsonData(json[i].id,json[i].type,
					json[i].price,json[i].introduce,
					json[i].picture,json[i].date,json[i].state);
			List.push(data);
			GetJsonStamp=List;
		}
	})
};

function timeStampDate(id,time){
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    document.getElementById(id).innerHTML="Hết hạn:"+year + " " + month + " " + date+" "+" "+hour+":"+minute+":"+second;
}

var AddBookBox = document.getElementById("bookBox");
var AddStampBox = document.getElementById("stampBox");
AddBookDiv();
AddStampDiv();
function AddBookDiv() {

	var count=1;
	var commodityId=1;
	$.each(JsonList,function(i,element){

		if (this.state==2) {
			return true;
		}
		if (count==5) {
			return false;
		}
		count++;
		var newA=document.createElement("a");
		commodityId=i+1;
		newA.href="AuctionServlet?type=book&id="+this.id;
		var newDiv=document.createElement("div");

		var newImg=document.createElement("img");
		newImg.src=this.picture;
		var newIntroduce=document.createElement("p");
		newIntroduce.innerText=this.introduce;

		var newCountTime=document.createElement("p");
		var nowTime = new Date();

		var TotalMS = this.date.time+259200000;

		newCountTime.id=i;
		newCountTime.style.position="absolute";
		newCountTime.style.bottom="2px";

		AddBookBox.appendChild(newA);

		newA.appendChild(newImg);
		newA.appendChild(newIntroduce);

		newA.appendChild(newCountTime);
		
		timeStampDate(i,TotalMS);
	})

}
function AddStampDiv() {

	var count=1;
	var commodityId=1;
	$.each(JsonListStamp,function(i,element){
		if (this.state==2) {
			return true;
		}
		if (count==5) {
			return false;
		}

		count++;
		var newA=document.createElement("a");
		commodityId=i+1;
		newA.href="AuctionServlet?type=stamp&id="+this.id;

		var newDiv=document.createElement("div");

		var newImg=document.createElement("img");
		newImg.src=this.picture;

		var newIntroduce=document.createElement("p");
		newIntroduce.innerText=this.introduce;

		var newCountTime=document.createElement("p");
		var TotalMS = this.date.time+259200000;

		newCountTime.id=i;
		newCountTime.style.position="absolute";
		newCountTime.style.bottom="2px";
		AddStampBox.appendChild(newA);
		newA.appendChild(newImg);
		newA.appendChild(newIntroduce);
		newA.appendChild(newCountTime);
		timeStampDate(i,TotalMS);
	})
//	}
}
