package com.ohgiraffers.section02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

    public SessionListenerTest() {
        System.out.println("context가 로드될 때 인스턴스를 생성함");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 세션이 생성될 때 동작한다.
        System.out.println("create session");
        System.out.println("생성된 session id : " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session destroyed! ");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session attribute added");
        System.out.println("session에서 추가된 attr : " + event.getName() + " , " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session attribute removed!");
        System.out.println("session에서 제거된 attr : " + event.getName() + " , " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        /*
        attributeReplaced 메소드는 속성이 수정 될 때 실행 되는 메소드이다.
        * event : 매개변수는 attribute 속성이 수정 될 때 수정되기 이전에 값을 session 에서 찾아서 보여준다.
        * */
        System.out.println("session Attribute replaced");
        System.out.println("session에서 수정할 attr : " + event.getName() + " , " + event.getValue());
    }
}
