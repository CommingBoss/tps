var all, page, nowpage, pagemax, Nbegin; //所有的信息数，页面页码总数，目前的页码数,显示最大页码，省略后的起始
var information;
window.onload = function() {
	var login = document.getElementsByClassName("cd-user-modal")[0];
	login.onclick = function(e) {
		if(e.target === login) {
			this.className = "cd-user-modal";
		}
	}
	var i = 1; //标记第几个按钮
	Init();
	var infolist = document.getElementById("infolist"); //装pager的div
	var div = document.createElement("div"); //装所有格子的div
	div.className = "pager";
	infolist.appendChild(div);
	page = all / 10;
	page=parseInt(page);
	if(page % 10 !== 0) {
		page++;
	}
	if(nowpage !== 1) { //上一页
		var a = document.createElement("a");
		a.className = "prv";
		var span = document.createElement("span");
		span.innerHTML = "上一页";
		a.appendChild(span);
		div.appendChild(a);
	}

	if(page <= 10 || nowpage <= 7) {
		if (page>10) {
			page=10;
		}
		while(i <= page) {
			if(i === nowpage) {
				var strong = document.createElement("strong");
				var span = document.createElement("span");
				span.innerHTML = i;
				strong.appendChild(span);
				div.appendChild(strong);
			} else {
				var a = document.createElement("a");
				var span = document.createElement("span");
				span.innerHTML = i;
				a.appendChild(span);
				div.appendChild(a);
			}
			i++;
		}
	} else {
		pagemax = nowpage + 3;
		if(pagemax > page) {
			pagemax = page;
		}
		Nbegin = pagemax - 5;
		var a = document.createElement("a");
		var span = document.createElement("span");
		span.innerHTML = i;
		a.appendChild(span);
		div.appendChild(a);
		i++;
		a = document.createElement("a");
		var span = document.createElement("span");
		span.innerHTML = i;
		a.appendChild(span);
		div.appendChild(a);
		i++;
		a = document.createElement("a");
		var span = document.createElement("span");
		span.innerHTML = i;
		a.appendChild(span);
		div.appendChild(a);
		div.innerHTML+="...";
		i = Nbegin;
		while(i <= pagemax) {
			if(i === nowpage) {
				var strong = document.createElement("strong");
				var span = document.createElement("span");
				span.innerHTML = i;
				strong.appendChild(span);
				div.appendChild(strong);
			} else {
				var a = document.createElement("a");
				var span = document.createElement("span");
				span.innerHTML = i;
				a.appendChild(span);
				div.appendChild(a);
			}
			i++;
		}

	}

	if(nowpage !== page) { //下一页
		a = document.createElement("a");
		a.className = "next";
		span = document.createElement("span");
		span.innerHTML = "下一页";
		a.appendChild(span);
		div.appendChild(a);
	}
	
	var table=document.getElementsByClassName("tbimg")[0];
	var tbody=table.getElementsByTagName("tbody")[0];
	for (var i=0,len=information.length;i<len;i++) {
		var tr=document.createElement("tr");
		var td=document.createElement("div");
		td.className="img";
		var div=document.createElement("div");
		div.className="img_list";
		var span1=document.createElement("span");
		span1.className="img_picCount";
		var span2=document.createElement("span");
		span2.className="img_picCountOpacity";
		var span3=document.createElement("span");
		span3.innerHTML=information[i].picnum+'图';
		span1.appendChild(span2);
		span1.appendChild(span3);
		var a=document.createElement("a");
		a.href="";
		div.appendChild(span1);
		div.appendChild(a);
		td.appendChild(div);
		tr.appendChild(td);
		
		td=document.createElement("td");
		td.className="t qj-rentd";
		a=document.createElement("a");
		a.href="";
		a.innerHTML=information[i].jieshao;//对房屋的介绍
		td.appendChild(a);
		var i=document.createElement("i");
		i.className="clear";
		td.appendChild(i);
		var p=document.createElement("p");
		p.className="qj-renaddr";
		a=document.createElement("a");
		a.href="";                       //链接
		a.className="a_xq1";
		a.innerHTML=information[i].xiaoqu;//小区名称
		p.appendChild(a);
		a=document.createElement("a");
		a.href="";                    //链接
		a.innerHTML=information[i].xiaoquJ;//小区内的具体位置
		p.appendChild(a);
		span=document.createElement("span");
		span.innerHTML="/";
		p.appendChild(span);
		p.innerHTML+=information[i].data;//发布时间
		td.appendChild(p);
		tr.appendChild(td);
		
		
		td=document.createElement("td");
		var b=document.createElement("b");
		b.className="pri";
		b.innerHTML=information[i].price;//价格
		td.appendChild(b);
		td.innerHTML+="元/月";
		td.appendChild("<br>");
		span=document.createElement("span");
		span.className="showroom";
		span.innerHTML=information[i].wuxing;//房屋的类型
		td.appendChild(span);
		td.appendChild("<br>");
		tr.appendChild(td);
	}
}

function Init() { //初始化信息,在此初始化所有信息
	all = 10;
	nowpage =1;
}

function login() {
	var login = document.getElementsByClassName("cd-user-modal");
	login[0].className += " is-visible";
}

function userlogin() {
	var login = document.getElementsByClassName("cd-switcher")[0];
	var userlogin = login.childNodes[1].childNodes[1];
	var sign = login.childNodes[3].childNodes[1];
	userlogin.className = "selected";
	sign.className = "";
	document.getElementById("cd-login").className = "is-selected";
	document.getElementById("cd-signup").className = "";
}

function usersign() {
	var login = document.getElementsByClassName("cd-switcher")[0];
	var userlogin = login.childNodes[1].childNodes[1];
	var sign = login.childNodes[3].childNodes[1];
	userlogin.className = "";
	sign.className = "selected";
	document.getElementById("cd-login").className = "";
	document.getElementById("cd-signup").className = "is-selected";
}