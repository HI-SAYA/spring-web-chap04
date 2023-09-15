package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @ControllerAdvice 어노테이션이 적용 된 클래스의 @ExceptionHandler는 전역적으로 기능한다. */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {
        System.out.println("global 레벨의 exception 처리");
        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model, MemberRegistException exception) {
        System.out.println("global 레벨의 exception 처리");
        model.addAttribute("exception", exception);
        return "error/memberRegist";
    }


    /* 모든 Exception 핸들링 */
    /* 상위 타입의 Exception을 통해 Handler를 작성하면 하위 타입의 Exception을 모두 처리할 수 있다. */
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception exception) {
        return "error/default";
    }
}