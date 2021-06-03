package com.example.demo.config;

import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.ParserException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;

//웹소켓 구현체
@Component
public class SocketHandler extends TextWebSocketHandler {

    HashMap<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 맵

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        //메시지 발송
        String msg = message.getPayload();
        for(String key : sessionMap.keySet()){
            WebSocketSession wss = sessionMap.get(key);
            try{
                wss.sendMessage(new TextMessage(msg));
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
        //map의 put이 뭔지 찾기
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //소켓 종료되면 동작
        sessionMap.remove(session.getId());
        super.afterConnectionClosed(session, status);
    }

    @Override
    private static JSONObject JsonToObjectParser(String jsonStr){
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try{
            obj = (JSONObject) parser.parse(jsonStr);
        }catch (ParserException e){
            e.printStackTrace();
        }
        return obj;

    }

}
