package ru.itmo.loveconnect.controller;

import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    void foo(AuthenticatedPrincipal user) {}
}
