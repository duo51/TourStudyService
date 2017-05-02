function reloadImage(imgurl){
	var getimagecode=document.getElementById("CreateCheckCode");
	getimagecode.src= imgurl + "?id=" + Math.random();
	}