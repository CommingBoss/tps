var imgs; //存储图片;
var likeflag = 0;
var inter = [];
var inters = []; //存放记时器
//定义看了又看
var interL = [];
var intersL = []; //存放记时器
imgs = ['img/fang-list-sprites.png', 'img/list_fangimg.png', 'img/fang-list-sprites.png', 'img/list_fangimg.png', 'img/fang-list-sprites.png', 'img/list_fangimg.png', 'img/fang-list-sprites.png', 'img/list_fangimg.png']
var nowChoose = 0; //当前选中的小图片
window.onload = function() {
		var myInformation = document.getElementById("topbar_my58menu");
		myInformation.onmouseover = function() {
			myInformation.className += " hover";
		}
		myInformation.onmouseout = function() {
			myInformation.className = "haschild";
		}
		var putImg = document.getElementById("putImage");
		var AllImg = document.createElement("div");
		AllImg.className = "house-primary-pic fl primarypic pr";
		putImg.appendChild(AllImg);
		var bigImg = document.createElement("div");
		bigImg.id = "bigImg";
		AllImg.appendChild(bigImg);
		var img = document.createElement("img");
		img.id = "smainPic";
		img.src = imgs[0];
		bigImg.appendChild(img);
		var span = document.createElement("span");
		span.id = "sImgNu";
		span.innerText = "1/" + imgs.length;
		span.className = "leftNu f12 white tc pa";
		bigImg.appendChild(span);

		var tableDiv = document.createElement("div");
		tableDiv.className = "primarypicList pr";
		AllImg.appendChild(tableDiv);

		var ul = document.createElement("ul");
		ul.id = "leftImg";
		ul.className = "gallery_demo_unstyled w1000";
		tableDiv.appendChild(ul);

		var li, img;
		for(var i = 1, len = imgs.length; i <= len; i++) {
			li = document.createElement("li");
			li.id = "xtu_" + i;
			if(i === 1) {
				li.className = "actives";
			}
			img = document.createElement("img");
			img.src = imgs[i - 1];
			li.appendChild(img);
			ul.appendChild(li);
		}

		var span = document.createElement("span");
		span.className = "slbtspan";
		span.style.cursor = "pointer";
		span.addEventListener("click", toLeft, false);
		var a = document.createElement("a");
		a.id = "slbt";
		a.className = "bgimg picLeft";
		span.appendChild(a);
		tableDiv.appendChild(span);

		span = document.createElement("span");
		span.className = "srbtspan";
		span.style.cursor = "pointer";
		span.addEventListener("click", toRight);
		a = document.createElement("a");
		a.id = "srbt";
		a.className = "bgimg picRight";
		span.appendChild(a);
		tableDiv.appendChild(span);

		//初始化猜你喜欢
		var like = document.getElementsByClassName("recommend-house-a");
		for(var i = 0, len = like.length; i < len; i++) {
			like[i].getElementsByTagName("ul")[0].style.bottom = -62 + 'px';
		}
		YouLike();

		var login = document.getElementsByClassName("cd-user-modal")[0];
		login.onclick = function(e) {
			if(e.target === login) {
				this.className = "cd-user-modal";
			}
		}
		
		//初始化看了又看
		var look=document.getElementsByClassName("cnxh-recommend-house-a");
		for (var i=0,len=look.length;i<len;i++) {
			look[i].getElementsByTagName("ul")[0].style.bottom=-58+'px';
		}
		
		LookLook();
		
}
	//判断保存图片的div是否需要移动
function judge() {
	if(nowChoose > 1 && nowChoose < imgs.length - 1) {
		move();
	}
}
//点击向左按钮
function toLeft() {
	if(nowChoose !== 0) {
		nowChoose--;
		judge();
		var ul = document.getElementById("leftImg");
		var lis = ul.getElementsByTagName("li");
		for(var i = 0, len = lis.length; i < len; i++) {
			lis[i].className = "";
		}
		var li = document.getElementById("xtu_" + (nowChoose + 1));
		li.className = "actives"
		changeBigImg();

	}
}

//点击向右按钮
function toRight() {
	if(nowChoose < imgs.length - 1) {
		nowChoose++;
		judge();
		var ul = document.getElementById("leftImg");
		var lis = ul.getElementsByTagName("li");
		for(var i = 0, len = lis.length; i < len; i++) {
			lis[i].className = "";
		}
		var li = document.getElementById("xtu_" + (nowChoose + 1));
		li.className = "actives"
		changeBigImg();
	}

}
//移动的动画效果
function move() {
	var div = document.getElementById("leftImg");
	var _nowChoose = nowChoose;
	if(_nowChoose < 2) {
		_nowChoose = 2;
	}
	if(_nowChoose >= imgs.length - 2) {
		_nowChoose = imgs.length - 2
	}
	if(parseInt(div.offsetLeft) !== (-125 * (_nowChoose - 2))) {
		if((parseInt(div.offsetLeft)) > -125 * (_nowChoose - 2)) {
			div.style.left = parseInt(div.offsetLeft) - 5 + 'px';
		} else {
			div.style.left = parseInt(div.offsetLeft) + 5 + 'px';
		}
		setTimeout("move()", 20);
	}

}

function changeBigImg() {
	var big = document.getElementById("smainPic");
	big.setAttribute('src', imgs[nowChoose]);
	var span = document.getElementById("sImgNu");
	span.innerText = nowChoose + 1 + "/" + imgs.length;
}
//猜你喜欢
function YouLike() {
	var like = document.getElementsByClassName("recommend-house-a");
	for(var i = 0, len = like.length; i < len; i++) {
		like[i].onmouseover = function() {
			var no = this.getAttribute('data-index');
			clearInterval(inter[no]);
			var ul = this.getElementsByTagName("ul")[0];
			if(parseInt(ul.style.bottom) < 0) {
				inters[no] = setInterval(function() {
					ul.style.bottom = parseInt(ul.style.bottom) + 2 + 'px';
					if(parseInt(ul.style.bottom) >= 0) {
						ul.style.bottom = 0;
						clearInterval(inters[no]);
					}
				}, 20);
			}
		}
		like[i].onmouseout = function() {
			var This = this;
			var no = this.getAttribute('data-index');
			clearInterval(inters[no]); //神来之笔	
			var ul = This.getElementsByTagName("ul")[0];
			if(parseInt(ul.style.bottom) > -62) {
				inter[no] = setInterval(function() {
					ul.style.bottom = parseInt(ul.style.bottom) - 2 + 'px';
					if(parseInt(ul.style.bottom) <= -62) {
						ul.style.bottom = -62 + 'px';
						clearInterval(inter[no]);
					}
				}, 20);
			}
		}
	}
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

//看了又看
function LookLook(){
	var look = document.getElementsByClassName("cnxh-recommend-house-a");
	for(var i = 0, len = look.length; i < len; i++) {
		look[i].onmouseover = function() {
			var no = this.getAttribute('data-index');
			clearInterval(interL[no]);
			var ul = this.getElementsByTagName("ul")[0];
			if(parseInt(ul.style.bottom) < 0) {
				intersL[no] = setInterval(function() {
					ul.style.bottom = parseInt(ul.style.bottom) + 2 + 'px';
					if(parseInt(ul.style.bottom) >= 0) {
						ul.style.bottom = 0;
						clearInterval(intersL[no]);
					}
				}, 20);
			}
		}
		look[i].onmouseout = function() {
			var This = this;
			var no = this.getAttribute('data-index');
			clearInterval(intersL[no]); //神来之笔	
			var ul = This.getElementsByTagName("ul")[0];
			if(parseInt(ul.style.bottom) > -58) {
				interL[no] = setInterval(function() {
					ul.style.bottom = parseInt(ul.style.bottom) - 2 + 'px';
					if(parseInt(ul.style.bottom) <= -62) {
						ul.style.bottom = -58 + 'px';
						clearInterval(interL[no]);
					}
				}, 20);
			}
		}
	}
}
