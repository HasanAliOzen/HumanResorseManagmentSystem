package com.travula.hrms.controller;

import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.service.SysPersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller/sys-personal/")
@RequiredArgsConstructor
public class SysPersonalController {
    private final SysPersonalService sysPersonalService;

    @PostMapping("enable-Employer")
    public Result enableEmployer(@RequestParam Long personalId,@RequestParam Long employerId){
        return this.sysPersonalService.enableEmployer(personalId,employerId);
    }
}
