
function yanzheng(){
    var yuanpassword = document.getElementById("yuanpassword").value;
    var newpassword = document.getElementById("newpassword").value;
    var password = document.getElementById("password").value;
    if(yuanpassword == "" || newpassword == "" || password == ""){
        alert("Không được để trống mật khẩu");
        return false;
    }else if(newpassword != password){
        alert("Không khớp mật khẩu");
        return false;
    }
    return true;
}
function yuanPasswordIsOk(error){
    if(error == "oloPasswordError"){
        alert("Sai mật khẩu , vui lòng nhập đúng!");
    }
    else if(error == "newPassWord=oldPassWord"){
        alert("Trùng mật khẩu cũ , vui lòng nhập mật khẩu mới!");
    }
    else if(error == "systemError"){
        alert("Lỗi hệ thống");
    }
}
