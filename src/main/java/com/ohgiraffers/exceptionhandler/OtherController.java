package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @GetMapping("/other-controller-null")
    public String nullPointerExceptionTest() {
        String str = null;
        System.out.println(str.charAt(0));    // 의도적으로 NillPointerException 발생 시킴
        return "/";
        // 500번 error -> 사용자에게 노출하는 것은 좋지 않기 때문에 개발자가 정의한 화면이 나오도록 하는걸 권한다.
    }

    @GetMapping("/other-controller-user")
    public String userExceptionTest() throws MemberRegistException {
        boolean check = true;
        if(check) throw new MemberRegistException("당신 같은 사람은 회원으로 받을 수 없습니다!");
        return "/";
    }

    @GetMapping("/other-controller-array")
    public String otherArrayExceptionTest() {
        double[] array = new double[0];
        System.out.println(array[0]);
        return "/";
        // ArrayIndexOutOfBoundsException
    }
}
