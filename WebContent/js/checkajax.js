function checkUserPhone() {
    var userPhoneExist = 0;
    var userPhone = document.getElementById("userPhone");
    /*同步验证数据库中是否已经存在该用户名*/
    userPhoneExist = checkUserPhoneExist();
    if(userPhoneExist == 1){	//已存在
        //如果用户名已经存在，提示用户用户名不可用，样式validation-failed让输入框变色
    	userPhone.setAttribute("title","用户名已被占用");
    	userPhone.setAttribute("class","reqd validation-failed");
    }else{		//尚未注册
    	userPhone.setAttribute("title","");
    	userPhone.setAttribute("class","reqd");
    }
    return;
}

function checkUserPhoneExist(){
    var check = 0;
    var ajax = GetXMLHttpRequestObj();

    //将phone发送给servlet处理
    var urlString = "../CheckUserPhoneExistServerlet?user[phone]="+document.getElementById('userPhone').value;
    //var urlString = "./checkUserNameExistServerlet.jsp?user[name]="+document.getElementById('user_name').value;
    
    //等待用户名检查完成
    ajax.open("get", urlString, false);
    ajax.send(null);

    ajax.onreadystatechange = (function(){
      if (ajax.readyState == 4 && ajax.status == 200){
        //ajax.responseText是服务器的返回值，0：用户名可用；
    	  //							1：用户名已被占用，

       //只需要在检查的页面或servlet试用out.print(XXX)即可将结果写入ajax.responseText。             

       //responseText中有很多空格，需要处理掉才能正确判断返回的结果

        if(ajax.responseText.trim() == "0"){
        	check = 0;
        } else {
        	check = 1;
        }
      }
    })();
    
    return check;
    }


function GetXMLHttpRequestObj()
{
  var ajax=false;
   try{
    ajax = new ActiveXObject("Msxml2.XMLHTTP");
   }
   catch (e){
     try{
      ajax = new ActiveXObject("Microsoft.XMLHTTP");
     }catch (E){
      ajax = false;
     }
   }
   if (!ajax && typeof XMLHttpRequest!='undefined')   {
    ajax = new XMLHttpRequest();
   }
   return ajax;
}
