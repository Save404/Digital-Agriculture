//Salt
var password_salt = "z0fdf7f8g9o1";
//展示loading
function showLoading(){
    var idx = layer.msg('处理中...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px', time:100000}) ;
    return idx;
}