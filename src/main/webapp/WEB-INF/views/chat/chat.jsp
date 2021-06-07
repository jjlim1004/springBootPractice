  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
 <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" rel="stylesheet"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
	<title>Chating</title>
	<style>
             * {
               box-sizing: border-box;
             }

             body {
               background-color: #edeff2;
               font-family: "Calibri", "Roboto", sans-serif;
             }

             .chat_window {
               position: absolute;
               width: calc(100% - 20px);
               max-width: 800px;
               height: 500px;
               border-radius: 10px;
               background-color: #fff;
               left: 50%;
               top: 50%;
               transform: translateX(-50%) translateY(-50%);
               box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
               background-color: #f8f8f8;
               overflow: hidden;
             }

             .top_menu {
               background-color: #fff;
               width: 100%;
               padding: 20px 0 15px;
               box-shadow: 0 1px 30px rgba(0, 0, 0, 0.1);
             }

             .top_menu .buttons {
               margin: 3px 0 0 20px;
               position: absolute;
             }

             .top_menu .buttons .button {
               width: 16px;
               height: 16px;
               border-radius: 50%;
               display: inline-block;
               margin-right: 10px;
               position: relative;
             }

             .top_menu .buttons .button.close {
               background-color: #f5886e;
             }

             .top_menu .buttons .button.minimize {
               background-color: #fdbf68;
             }

             .top_menu .buttons .button.maximize {
               background-color: #a3d063;
             }

             .top_menu .title {
               text-align: center;
               color: #bcbdc0;
               font-size: 20px;
             }

             .messages {
               position: relative;
               list-style: none;
               padding: 20px 10px 0 10px;
               margin: 0;
               height: 347px;
               overflow: scroll;
             }

             .messages .message {
               clear: both;
               overflow: hidden;
               margin-bottom: 20px;
               transition: all 0.5s linear;
               opacity: 0;
             }

             .messages .message.left .avatar {
               background-color: #f5886e;
               float: left;
             }

             .messages .message.left .text_wrapper {
               background-color: #ffe6cb;
               margin-left: 20px;
             }

             .messages .message.left .text_wrapper::after, .messages .message.left .text_wrapper::before {
               right: 100%;
               border-right-color: #ffe6cb;
             }

             .messages .message.left .text {
               color: #c48843;
             }

             .messages .message.right .avatar {
               background-color: #fdbf68;
               float: right;
             }

             .messages .message.right .text_wrapper {
               background-color: #c7eafc;
               margin-right: 20px;
               float: right;
             }

             .messages .message.right .text_wrapper::after, .messages .message.right .text_wrapper::before {
               left: 100%;
               border-left-color: #c7eafc;
             }

             .messages .message.right .text {
               color: #45829b;
             }

             .messages .message.appeared {
               opacity: 1;
             }

             .messages .message .avatar {
               width: 60px;
               height: 60px;
               border-radius: 50%;
               display: inline-block;
             }

             .messages .message .text_wrapper {
               display: inline-block;
               padding: 20px;
               border-radius: 6px;
               width: calc(100% - 85px);
               min-width: 100px;
               position: relative;
             }

             .messages .message .text_wrapper::after, .messages .message .text_wrapper:before {
               top: 18px;
               border: solid transparent;
               content: " ";
               height: 0;
               width: 0;
               position: absolute;
               pointer-events: none;
             }

             .messages .message .text_wrapper::after {
               border-width: 13px;
               margin-top: 0px;
             }

             .messages .message .text_wrapper::before {
               border-width: 15px;
               margin-top: -2px;
             }

             .messages .message .text_wrapper .text {
               font-size: 18px;
               font-weight: 300;
             }

             .bottom_wrapper {
               position: relative;
               width: 100%;
               background-color: #fff;
               padding: 20px 20px;
               position: absolute;
               bottom: 0;
             }

             .bottom_wrapper .message_input_wrapper {
               display: inline-block;
               height: 50px;
               border-radius: 25px;
               border: 1px solid #bcbdc0;
               width: calc(100% - 160px);
               position: relative;
               padding: 0 20px;
             }

             .bottom_wrapper .message_input_wrapper .message_input {
               border: none;
               height: 100%;
               box-sizing: border-box;
               width: calc(100% - 40px);
               position: absolute;
               outline-width: 0;
               color: gray;
             }

             .bottom_wrapper .send_message {
               width: 140px;
               height: 50px;
               display: inline-block;
               border-radius: 50px;
               background-color: #a3d063;
               border: 2px solid #a3d063;
               color: #fff;
               cursor: pointer;
               transition: all 0.2s linear;
               text-align: center;
               float: right;
             }

             .bottom_wrapper .send_message:hover {
               color: #a3d063;
               background-color: #fff;
             }

             .bottom_wrapper .send_message .text {
               font-size: 18px;
               font-weight: 300;
               display: inline-block;
               line-height: 48px;
             }


             .received_withd_msg p {
                  background: #C7EAFC none repeat scroll 0 0;
                  border-radius: 3px;
                  color: #458298;
                  font-size: 18px;
                  margin: 15px;
                  padding: 5px 10px 5px 12px;
                  width: 100%;
            }

            .received_withd_msg {
                width: 57%;
                clear:both;
            }


             .sent_msg p {
                  background: #FFE6CB none repeat scroll 0 0;
                  border-radius: 3px;
                  font-size: 16px;
                  margin: 15px;
                  color:#C48843;
                  padding: 5px 10px 5px 12px;
                  width:100%;
            }


            .sent_msg {
                  padding: 0 10 0 0px;
                  clear:both;
                  float: right;
                  width: 46%;
            }

            #yourMsg{
                display: none;
            }
	</style>
</head>

<body>
<div class="chat_window">
		<div class="top_menu">
			<div class="title">${roomName}</div>
		</div>
		<input type="hidden" id="sessionId" value="">
		<input type="hidden" id="roomNo" value="${roomNo}">

        <div id="chating" class="messages">



         </div>

                <div id="yourName">
                    <div class="bottom_wrapper clearfix">
                        <div class="message_input_wrapper">
                            <input type="text"class="message_input" name="userName" id="userName" placeholder="Type your ID here...">
                        </div>
                        <div class="send_message">
                            <div class="icon"></div>
                            <div class="text" onclick="chatName()" class="text">Next</div>
                        </div>
                    </div>
                </div>

            <div id="yourMsg">
			    <div class="bottom_wrapper clearfix">
				    <div class="message_input_wrapper">
                            <input id="chatting" class="message_input" placeholder="Type your message here...">
                    </div>
                    <div class="send_message">
                        <div class="icon"></div>
                        <div class="text" onclick="send()">Send</div>

                    </div>
	            </div>
	        </div>
   </div>

<script type="text/javascript">

    var ws;

    function wsOpen(){
        ws = new WebSocket("ws://" + location.host + "/chating/" +$("#roomNo").val());       //socketHandler
        wsEvt();
        console.log("name" + `${roomName}`);
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
                                            var msgDiv = document.getElementById("chating");

                                            var output="";

                                            output += "<p>나 : "+d.msg+"</p>";

                                            var mDiv = document.createElement("div");
                                            mDiv.setAttribute("class", "sent_msg");
                                            mDiv.innerHTML=output;
                                            msgDiv.appendChild(mDiv);


                                    }else{      //초기 세팅된 값이랑 메세지를 보낸 사람이 다르면 다른 사람
                                           var msgDiv = document.getElementById("chating");

                                           var output="";

                                           output += "<p>"+ d.userName + " : " + d.msg +"</p>";

                                           var rDiv = document.createElement("div");
                                           rDiv.setAttribute("class", "received_withd_msg");
                                           rDiv.innerHTML=output;
                                           msgDiv.appendChild(rDiv);

                                    }
                            }else{
                                     console.warn("unknown type");
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
            roomNo: $("#roomNo").val(),
            sessionId: $("#sessionId").val(),
            userName: $("#userName").val(),
            msg: $("#chatting").val()
        }
        ws.send(JSON.stringify(option));
        console.log(JSON.stringify(option));
        $("#chatting").val("");
    }
</script>



</body>

</html>