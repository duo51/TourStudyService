function checkPhone(){
    var phone = document.getElementById('phone').value;
    if(!(/^1[34578]\d{9}$/.test(phone))){
        alert("手机号码有误，请重填");
        document.getElementById('phone').value="";
        return false;
    }
}