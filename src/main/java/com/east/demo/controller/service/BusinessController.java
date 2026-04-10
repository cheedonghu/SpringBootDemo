package com.east.demo.controller.service;

import cn.hutool.json.JSONObject;
import com.east.demo.model.dto.base.resp.BaseResp;
import com.east.demo.service.commonrecord.business.check.CheckService;
import com.east.demo.service.commonrecord.business.check.checksouce.CheckSource;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 普通功能的记录demo
 *
 * @author: east
 * @date: 2023/9/13
 */
@Api(tags = "业务记录")
@RestController
@RequestMapping(path = "/business")
public class BusinessController {
    private final CheckService checkService;

    public BusinessController(CheckService checkService) {
        this.checkService = checkService;
    }


    @PostMapping(value = "/check")
    public BaseResp<JSONObject> demo(@RequestParam String source) {

        checkService.check(CheckSource.valueOf(source));
        return BaseResp.ok(null);
    }


}
