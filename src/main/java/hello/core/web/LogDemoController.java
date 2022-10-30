package hello.core.web;


import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
//    private final MyLogger myLogger;
    //지금 myLogger에서 스프링 빈을 줄 수 없다
    //왜냐하면, 지금 이 경우는 scope 범위가 request이다
    //request는 요청이 '들어왔을 때' 스프링 빈 컨테이너에 등록이 된다
    //하지만 스프링 웹을 띄우기만 할 때에는 아직 요청이 '들어온 상태'가 아니다
    //그래서 MyLogger라는 빈이 아직 등록되어있지 않고, 그 결과 생성자 주입으로 받을 수가 없다!!
    // =>Provider를 사용한다.

    //두번째는 MyLogger에서 proxyMode = ScopedProxyMode.TARGET_CLASS 를 scope에 달아주면 된
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass());

        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";

    }
}
