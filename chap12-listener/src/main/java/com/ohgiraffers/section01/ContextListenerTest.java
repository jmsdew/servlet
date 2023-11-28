package com.ohgiraffers.section01;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

    /*
    * 리스너는 특정 이벤트 행위가 동작할 때 컨테이너에 의해 호출되는 메소드를 인터페이스에 정의해 두었다가
    * 이를 상속 받아 구현한 메소드가 특정 이벤트 발생에 대해 필요한 로직을 작성하는데, 크게 3가지 범주의 이벤트로 분류한다.
    * 1. concat( -> 톰캣 컨테이너 자체 리스너 연결)
    *   1-1 ServletContextListener : 웹 애플리케이션의 시작, 종료에 대한 이벤트 리스너
    *   1-2 ServletContextAttributeListener : Context에 attribute를 추가, 제거, 수정에 대한 이벤트 리스너
    * 2. session ( -> request 관련 이벤트)
    *   2-1 HttpSessionListener : http 세션의 시작, 종료에 대한 이벤트 리스너
    *   2-2 HttpSessionAttributeListener : HttpSession 에 Attribute 추가, 제거, 수정에 대한 이벤트 리스너
    * 3. request (-> request 관련 이벤트)
    *   3-1 ServletRequestListener : ServletRequest 생성과 소멸에 대한 이벤트 리스너
    *   3-2 ServletRequestAttributeListener : ServletRequest에 Attribute 를 추가, 제거, 수정하는 것에 대한 이벤트 리스너
    * */
    
    
    /*
    * context ----------  무엇인가를 저장하고 있는 공간
    * Attribute ---------- 속성
    * 
    * */


    public ContextListenerTest() {
        // context가 생성될 때 변화를 감지하는 Listener 인스턴스가 함께 생성된다.            
        System.out.println("context listener 인스턴스 생성");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {

        // context의 attribute 가 add 되는 시점에 동작한다.
        System.out.println("context attribute added");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {

        // context의 attribute 가 제거되는 시점에 동작한다.
        System.out.println("context attribute removed");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

        // context의 attribute 가 변경되는 시점에 동작한다.
        System.out.println("context attribute replaced");
    }

    
    // context 와 관련된 메소드
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // context가 최초 생성될 때 생성자 호출 이후 동작하는 메소드이다.
        System.out.println("context가 최초 생성되는 경우 실행");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // context가 소멸될 때 동작하는 메소드이다.
        System.out.println("context가 소멸되는 시점에 실행");
    }
}
