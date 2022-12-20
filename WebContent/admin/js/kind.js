function yanzheng(){
    var kind_name = document.getElementById("kind_name").value;
    if(kind_name == ""){
        alert("Tên loại không thể để trống");
        return false;
    }
    alert("Loại đã được thêm thành công!");
    return true;
}