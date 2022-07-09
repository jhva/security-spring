package com.sp.fc.web.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController

public class HomeController {


    @RequestMapping("/")
    public String index() {
        return "홈페이지";
    }

    @RequestMapping("/auth")
    public Authentication auth() {
        return SecurityContextHolder.getContext()
                .getAuthentication();
    }
    @RequestMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public SecurityMessage user() {
        return SecurityMessage.builder().auth(SecurityContextHolder.getContext().getAuthentication()).message("user정보").build();
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public SecurityMessage admin() {
        return SecurityMessage.builder().auth(SecurityContextHolder.getContext().getAuthentication()).message("관리자정보").build();

    }

}
