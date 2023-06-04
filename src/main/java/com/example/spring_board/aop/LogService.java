package com.example.spring_board.aop;


import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
//Component를 통해 Spring Bean객체를 만드는 것.(Bean객체는 싱글톤을 의미)
@Component
//로그 라이브러리인 Log4j 라이브러리 사용
@Slf4j
public class LogService {

//    Around 어노테이션을 통해 logging의 대상을 지정
    @Around("execution(* com.example.spring_board..controller..*.*(..))")
    public Object controllerLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        로그의 형태를 json으로 출력하기 위해 json 객체 생성
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("method name", proceedingJoinPoint.getSignature().getName());

//        사용자의 request정보는 HttpServletRequest객체 안에 담겨 있으므로, 해당 객체에서 추출.
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        jsonObject.put("CRUD name", req.getMethod());
        Enumeration<String> req_body = req.getParameterNames();
        JSONObject jsonObject_details = new JSONObject();
        while(req_body.hasMoreElements()){
            String body = req_body.nextElement(); // 값이 있는 한 하나씩 꺼냄
            jsonObject_details.put(body, req.getParameter(body));
        }
        jsonObject.put("user inputs", jsonObject_details);
//        log4 라이브러리를 통해 위에서 만든 jsonObject를 log로 출력
//        일반적으로 실무에서는 콘솔이 아니라, log를 파일로 영구저장되도록 관리한다.
//        그런데, 정상적인 request가지 모두 log로 남기게되면 파일시스템에 용량이 full차는 경우가 빈번
//       그래서 log.info 뿐만 아니라, log.trace, lo.debug, log.info, log.error등의 로그레벨이 존재한다.
//        log.info("request info" + jsonObject);
        return proceedingJoinPoint.proceed();

    }
}
