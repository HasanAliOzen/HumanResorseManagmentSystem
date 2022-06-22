package com.travula.hrms.controller;

import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("enable-Email")
    public Result enableEmail(@RequestParam String email, @RequestParam int verificationCode){
        return this.userService.enableEmail(email,verificationCode);
    }
}
