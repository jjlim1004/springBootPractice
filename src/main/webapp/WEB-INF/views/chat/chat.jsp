  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
	<title>Chating</title>
	<style>
			*{
    			margin:0;
    			padding:0;
    		}
    		.container{
    			width: 500px;
    			margin: 0 auto;
    			padding: 25px
    		}
    		.container h1{
    			text-align: left;
    			padding: 5px 5px 5px 15px;
    			color: #FFBB00;
    			border-left: 3px solid #FFBB00;
    			margin-bottom: 20px;
    		}
    		.chating{
    			background-color: #000;
    			width: 500px;
    			height: 500px;
    			overflow: auto;
    		}
    		.chating .me{
    			color: #F6F6F6;
    			text-align: right;
    		}
    		.chating .others{
    			color: #FFE400;
    			text-align: left;
    		}
    		input{
    			width: 330px;
    			height: 25px;
    		}
    		#yourMsg{
    			display: none;
    		}
	</style>
</head>

<script type="text/javascript">
    var ws;

    function wsOpen(){
        ws = new WebSocket("ws://" + location.host + "/chating");       //socketHandler
        wsEvt();
    }

    function wsEvt(){
            ws.onopen = function(data){
                //소켓이 열리면 초기화 세팅하기 (이벤트 소스와의 연결이 열릴 때 이벤트 발생 )
            }

            ws.onmessage = function(data){  //  (이벤트 메세지 수신 이벤트)
                    var msg = data.data;
                       if(msg != null && msg.trim() !=''){
                            var d = JSON.parse(msg);
                            if(d.type =="firstId"){   //Id - 타입이 firstId면 초기에 설정된 값이면
                                    var si = d.sessionId != null ? d.sessionId : "";
                                    if(si !=''){
                                        $("#sessionId").val(si); //input hidden의 sessionId에 값을 세팅
                                    }

                            }else if(d.type == "message"){   //message
                                    if(d.sessionId == $("#sessionId").val()){ //초기 세팅된 값이랑 지금 메세지를 보낸 사람이 같다면 나
                                            $("#chating").append("<p class='me'>나 : "+ d.msg +"</p>"); //msg - 사용자: 메세지내용

                                    }else{      //초기 세팅된 값이랑 메세지를 보낸 사람이 다르면 다른 사람람
                                            $("#chating").append("<p class='others'>"+ d.userName + " : " + d.msg +"</p>"); //msg - 사용자: 메세지내용
                                    }
                            }else{
                                     console.log("unknown type");
                            }

                       }
            }

            document.addEventListener("keypress", function(e){      // addEventListener - 특정 이벤트 발생시 특정 함수를 실행시킨다.
                    if(e.keyCode == 13){        //enter key
                        send();     //send 메소드 호출
                    }
            });
    }

    function chatName(){
        var userName = $("#userName").val();
        if(userName == null || userName.trim() == ""){
            alert("사용자 이름을 입력해 주세요.");
            $("#userName").focus();
        }else{
            wsOpen();           //socketHandler 호출
            $("#yourName").hide();
            $("#yourMsg").show();
        }
    }

    function send(){
        var option ={
            type: "message",    //메세지를 보낼때 타입 - message
            sessionId: $("#sessionId").val(),
            userName: $("#userName").val(),
            msg: $("#chatting").val()
        }
        ws.send(JSON.stringify(option));
        console.log(JSON.stringify(option));
        $("#chatting").val("");

    }

</script>

<body>
	<div id="container" class="container">
		<h1>STock Talk!</h1>
		<input type="hidden" id="sessionId" value="">

		<div id="chating" class="chating">

		</div>

		<div id="yourName">
			<table class="inputTable">
				<tr>
					<th>사용자명</th>
					<th><input type="text" name="userName" id="userName"></th>
					<th><button onclick="chatName()" id="startBtn">이름 등록</button></th>
				</tr>
			</table>
		</div>

		<div id="yourMsg">
			<table class="inputTable">
				<tr>
					<th>메시지</th>
					<th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
					<th><button onclick="send()" id="sendBtn">보내기</button></th>
				</tr>
			</table>
		</div>
	</div>

</body>

</html>