package com.example.demo.config;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;



//웹소켓 구현체
@Component
public class SocketHandler extends TextWebSocketHandler {

    HashMap<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 맵

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        //메시지 발송
        String msg = message.getPayload(); //문자열
        JSONObject obj = jsonToObjectParser(msg); //jsonToObjectParser 호출 (jsonObject로 파싱처리를 해주는 함수)
        for(String key : sessionMap.keySet()){
            WebSocketSession wss = sessionMap.get(key);
            try{
                wss.sendMessage(new TextMessage(obj.toJSONString())); //JSONObject값을 받아서 강제 문자열 형태로 보내줌
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //소켓 연결되면 동작
        super.afterConnectionEstablished(session);
        sessionMap.put(session.getId(), session);
        JSONObject obj = new JSONObject();
        obj.put("type", "firstId");   //생성된 세션을 저장하면 '발신 메세지'의 타입은 getId로 명시 후 (클라이언트단에서 type으로 메세지와 초기 설정값 구분)
        obj.put("sessionId", session.getId());  //생성된 세션 ID값을 클라이언트단으로 발송한다.
        session.sendMessage(new TextMessage(obj.toJSONString()));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //소켓 종료되면 동작
        sessionMap.remove(session.getId());
        super.afterConnectionClosed(session, status);
    }

    //json 파일이 들어오면 파싱을 해주는 함수 JsonToObjectParser 추가
    private static JSONObject jsonToObjectParser(String jsonStr) { //json 형태의 문자열을 파라미터로 받아서
        JSONParser parser = new JSONParser(); //simpleJson의 파서를 활용해서
        JSONObject obj = null;  //jsonObject로 파싱처리를 해주는 함수이다.
        try {
            obj = (JSONObject) parser.parse(jsonStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
