$(function(){
    $("#testJson").click(function(){
        var url = this.href;
        var args = {};
        $.post(url, args, function(data){
            for(var i = 0; i < data.length; i++){
                var id = data[i].id;
                var lastName = data[i].lastName;

                alert(id + ": " + lastName);
            }
        });
        return false;
    });
});

