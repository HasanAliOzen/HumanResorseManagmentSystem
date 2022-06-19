package com.travula.hrms.service;

import com.travula.hrms.core.utilities.results.Result;

public interface SysPersonalService {
    Result enableEmployer(Long personalId,Long employerId);
}
