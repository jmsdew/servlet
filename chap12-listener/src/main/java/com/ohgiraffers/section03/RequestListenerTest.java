package com.ohgiraffers.section03;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {
    public RequestListenerTest() {
        System.out.println("request 인스턴스 생성");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("사용자의 요청이 소멸 될 때 호출된다.");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // 사용자의 요청이 생성 될 때 생성된다.
        System.out.println("request init");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        // request 에 attribute 가 추가될 때 호출된다.
        System.out.println("request Attribute added!~");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        // attribute 가 제거 될 때 호출된다.
        System.out.println("request attribute removed");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        // attribute 가 수정 될 때 호출된다.
        System.out.println("request attribute replaced");
    }
}
