/*
 * 手机号正则表达式
 */
function isPhoneNo(phone) {
    var pattern = /^1[34578]\d{9}$/;
    return pattern.test(phone);
}

$(function(){
    //聚焦失焦input
    $('#nhTelephone').focus(function(){
        if($(this).val().length==0){
            $(this).parent().next("div").text("你可以使用该手机登陆和找回密码");
        }
    })
    $('#nhPassword').focus(function(){
        if($(this).val().length==0){
            $(this).parent().next("div").text("建议使用字母、数字和符号两种以上的组合，6-20个字符");
        }
    })
    $('#rePassword').focus(function(){
        if($(this).val().length==0){
            $(this).parent().next("div").text("请再次输入密码");
        }
    })

    //input各种判断
    //手机号
    $('#nhTelephone').blur(function(){
        if($(this).val().length==0){
            $(this).parent().next("div").text("");
            $(this).parent().next("div").css("color",'#ccc');
        }else if(isPhoneNo($(this).val()) == false){
            $(this).parent().next("div").text("手机号格式不正确");
            $(this).parent().next("div").css("color",'red');
        }else{
            $(this).parent().next("div").text("");
        }
    })
    //密码
    $('#nhPassword').blur(function(){
        if($(this).val().length==0){
            $(this).parent().next("div").text("");
            $(this).parent().next("div").css("color",'#ccc');
        }else if($(this).val().length>0 && $(this).val().length<6){
            $(this).parent().next("div").text("长度只能在6-20个字符之间");
            $(this).parent().next("div").css("color",'red');
        }else{
            $(this).parent().next("div").text("");
        }
    })
    //确认密码
    $('#rePassword').blur(function(){
        if($(this).val().length==0){
            $(this).parent().next("div").text("");
            $(this).parent().next("div").css("color",'#ccc');
        }else if($(this).val()!=$('#nhPassword').val()){
            $(this).parent().next("div").text("两次密码不匹配");
            $(this).parent().next("div").css("color",'red');
        }else{
            $(this).parent().next("div").text("");
        }
    })
})

function submitClick() {
    if($('#nhTelephone').val().length==0) {
        $('#nhTelephone').focus();
        $('#nhTelephone').parent().next(".tips").text("此处不能为空");
        $('#nhTelephone').parent().next(".tips").css("color",'red');
        return false;
    }
    if($('#nhPassword').val().length==0) {
        $('#nhPassword').focus();
        $('#nhPassword').parent().next(".tips").text("此处不能为空");
        $('#nhPassword').parent().next(".tips").css("color",'red');
        return false;
    } else if($('#nhPassword').val().length>0 && $('#nhPassword').val().length<6) {
        $('#nhPassword').focus();
        $('#nhPassword').parent().next(".tips").text("长度只能在6-20个字符之间");
        $('#nhPassword').parent().next(".tips").css("color",'red');
        return false;
    }
    if($('#rePassword').val().length==0) {
        $('#rePassword').focus();
        $('#rePassword').parent().next(".tips").text("此处不能为空");
        $('#rePassword').parent().next(".tips").css("color",'red');
        return false;
    } else if($('#rePassword').val()!=$('#nhPassword').val()) {
        $('#rePassword').focus();
        $('#rePassword').parent().next(".tips").text("两次密码不匹配");
        $('#rePassword').parent().next(".tips").css("color",'red');
        return false;
    }
    //协议
    if($("#xieyi")[0].checked) {

    } else {
        $("#xieyi").next().next().next(".tips").text("请勾选协议");
        $("#xieyi").next().next().next(".tips").css("color", 'red');
        return false;
    }
}

function loginClick() {
    if($('#nhTelephone').val().length==0) {
        $('#nhTelephone').focus();
        $('#nhTelephone').parent().next(".tips").text("此处不能为空");
        $('#nhTelephone').parent().next(".tips").css("color",'red');
        return false;
    }
    if($('#nhPassword').val().length==0) {
        $('#nhPassword').focus();
        $('#nhPassword').parent().next(".tips").text("此处不能为空");
        $('#nhPassword').parent().next(".tips").css("color",'red');
        return false;
    } else if($('#nhPassword').val().length>0 && $('#nhPassword').val().length<6) {
        $('#nhPassword').focus();
        $('#nhPassword').parent().next(".tips").text("长度只能在6-20个字符之间");
        $('#nhPassword').parent().next(".tips").css("color",'red');
        return false;
    }
}