window.onload = function() {
	var position=document.getElementById("please");
	var choose=document.getElementById("Choose");
	/*document.onclick=function(){
		choose.style.display="none";
	}*/
	position.onclick=function(){
		setTimeout(
			"var choose=document.getElementById('Choose');choose.style.display='block';",1);
	}
	document.onclick=function(){
			choose.style.display="none";
	}
	var lis=document.getElementById("ul").getElementsByTagName('li');
	for(var li in lis){
		lis[li].onmouseover=function(){
			this.className='sel';
		}
		lis[li].onmouseout=function(){
			this.className="";
		}
		lis[li].onclick=function(){
			position.getElementsByTagName("span")[0].innerHTML=this.innerHTML;
		}
	}
	var divs=document.getElementsByName("HouseAllocation")[0].getElementsByTagName('div');
	for(var i in divs)
	{
		if(divs[i].tabIndex===17)
		{
			divs[i].style.cursor="pointer";
			divs[i].onclick=function(){
				if(this.className==="checkbox focus"){
					this.className="checkbox";
				}
				else{
					this.className="checkbox focus";
				}
			}
		}
		else{
			
		}
	}
}

function fabu(){
	var information={};
	information.name=document.getElementById("xiaoqu").value;
	information.position={};
	information.position.quyu=document.getElementById("please").getElementsByTagName('span')[0].innerHTML;
	information.position.weizhi=document.getElementById("dizhi").value;
	information.huxin={};
	information.huxin.shi=document.getElementById("huxingshi").value;
	information.huxin.ting=document.getElementById("huxingting").value;
	information.huxin.wei=document.getElementById("huxingwei").value;
	information.huxin.area=document.getElementById("area").value;
	information.Floor={};
	information.Floor.ceng=document.getElementById("Floor").value;
	information.Floor.zongceng=document.getElementById("zonglouceng").value;
	information.Price=document.getElementById("MinPrice").value;
	information.Tiltle=document.getElementById("Title").value;
	information.text=document.getElementById("edui1_iframeholder").innerHTML;
	information.lianxiren=document.getElementById("goblianxiren").value;
	information.phone=document.getElementById("Phone").value;
	information.peizhi=[];
	var divs=document.getElementsByName("HouseAllocation")[0].getElementsByTagName('div');
	for(var i in divs)
	{
		if(divs[i].className==="checkbox focus"){
			information.peizhi.push(divs[i].getElementsByTagName('label')[0].innerHTML);
		}
	}
	
	console.log(information);
}
