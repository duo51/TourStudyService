function getSelecInfo(){
	var prov = document.getElementById("prov");
	var city = document.getElementById("city");
	var address;
	if(prov.value != "请选择" && city.value=="请选择"){
		address.value = prov.value;
	}
	if(prov.value != "请选择" && city.value != "请选择"){
		address.value = prov.value + city.value;
	}
	if(prov.value == "请选择"){
		address.value="没有选择城市";
	}
	return address.value;
}