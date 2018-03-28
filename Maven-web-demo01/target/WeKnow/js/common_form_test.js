// 全局变量a和b，分别获取用户框和密码框的value值
var a = document.getElementsByTagName("input")[0].value;
var b = document.getElementsByTagName("input")[1].value;

//用户框失去焦点后验证value值
function oBlur_1() {
    if (!a) { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
    } else { //用户框value值不为空
        document.getElementById("remind_1").innerHTML = "";
        document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
    }
}

//密码框失去焦点后验证value值
function oBlur_2() {
    if (!b) { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
    } else { //密码框value值不为空
        document.getElementById("remind_2").innerHTML = "";
        document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_3").style.marginTop = 19 + "px";
    }
}

//密码框失去焦点后验证value值
function oBlur_ok() {
    if (!$('#pass2').val()) { //密码框value值为空
        document.getElementById("remind_3").innerHTML = "请再次输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
    } else { //密码框value值不为空
        document.getElementById("remind_2").innerHTML = "";
        document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_3").style.marginTop = 19 + "px";
        
        if($('#pass1').val()!=$('#pass2').val()){
        	document.getElementById("remind_3").innerHTML = "两次密码不一致！！";
        	console.log('xxxxxxx');
        }
    }
}

//邮箱验证框失去焦点后验证value值
function oBlur_Mailvr() {
    if (!$('#input_6').val()) { //邮箱验证框value值为空
        document.getElementById("remind_6").innerHTML = "请输入邮箱验证码！";
        document.getElementById("change_margin_5").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_6").style.marginTop = 2 + "px";
    } else { //邮箱验证框value值不为空
        document.getElementById("remind_6").innerHTML = "";
        document.getElementById("change_margin_5").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_6").style.marginTop = 19 + "px";
    }
}

//邮箱失去焦点后验证value值
function oBlur_Mail() {
    if (!$('#input_5').val()) { //邮箱框value值为空
        document.getElementById("remind_5").innerHTML = "请输入邮箱！";
        document.getElementById("change_margin_5").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_6").style.marginTop = 2 + "px";
    } else { //邮箱框value值不为空
        document.getElementById("remind_6").innerHTML = "";
        document.getElementById("change_margin_5").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_6").style.marginTop = 19 + "px";
        
        var mail = $('#input_5').val();
        if (mail != '') {//判断
           var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
           if (!reg.test(mail)) {
        	   document.getElementById("remind_5").innerHTML = "邮箱格式不正确，请重新填写!";
              return false;
         }
       }
        
    }
}

//用户框获得焦点的隐藏提醒
function oFocus_1() {
    document.getElementById("remind_1").innerHTML = "";
    document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
}

//密码框获得焦点的隐藏提醒
function oFocus_2() {
    document.getElementById("remind_2").innerHTML = "";
    document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_3").style.marginTop = 19 + "px";
}

//
function oFocus_ok() {
    /*document.getElementById("remind_2").innerHTML = "";
    document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_3").style.marginTop = 19 + "px";*/
}

//
function oFocus_Mail() {
   /* document.getElementById("remind_5").innerHTML = "";
    document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_3").style.marginTop = 19 + "px";*/
}

//密码框获得焦点的隐藏提醒
function oFocus_Mailvr() {
    /*document.getElementById("remind_6").innerHTML = "";
    document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_3").style.marginTop = 19 + "px";*/
}

//若输入框为空，阻止表单的提交
function submitTest() {
    if (!a && !b) { //用户框value值和密码框value值都为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false; //只有返回true表单才会提交
    } else if (!a) { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        return false;
    } else if (!b) { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false;
    }
}

$("#regmail").click(function(){
	  $.ajax({
		  type:'post',
		  url:'../verifyMail.action',
		  dataType: "json",
		  cache: false,
		  contentType: "application/x-www-form-urlencoded; charset=utf-8",
		  data: {mailUrl:$("#input_5").val()},
		  success:function(data){
			  
		  }
	  });
	});


$("#change_margin_6").click(function(){
	  $.ajax({
		  type:'post',
		  url:'../signUp.action',
		  dataType: "json",
		  cache: false,
		  contentType: "application/x-www-form-urlencoded; charset=utf-8",
		  data: {mailUrl:$("#input_5").val(),userName:a,uPass:b},
		  success:function(data){
			  alter(data);
		  }
	  });
	});