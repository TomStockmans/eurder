package be.tomstockmans.eurder.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class PrivateController {
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String test(){
        return "this is a test";
    }
}
