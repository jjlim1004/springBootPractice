console.log("****** member.js ******");

var memberService =(function(){

    function get(member_id, callback, error){

        $.get("/admin/"+ member_id, function(result){
                    if(callback){
                        callback(result);
                    }

                }).fail(function(xhr, status, err){
                    if(error){
                        error();
                    }
                });
    }

    function update(member, callback, error){

        console.log("MNO:" + member.member_id);

        $.ajax({
            type : 'PUT',
            url : '/admin/' + member.member_id,
            data : JSON.stringify(member),
            contentType : "application/json; charset=utf-8",
            success : function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error : function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }

 return {
    get : get,
    update : update
 };

})();
