function myReload() {  
    document.getElementById("CreateCheckCode").src = document  
            .getElementById("CreateCheckCode").src  
            + "?nocache=" + new Date().getTime();  
}  