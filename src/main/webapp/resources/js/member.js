console.log("****** member.js ******");

var memberService =(function(){

    function get(member_id, callback, error){

        $.get("/admin/"+ member_id + ".json", function(result){
                    if(callback){
                        callback(result);
                    }

                }).fail(function(xhr, status, err){
                    if(error){
                        error();
                    }
                });
    }

  return { get : get };

})();