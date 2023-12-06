package com.italycalibur.mall.tiny.jpa.core.modules;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * @author italycalibur
 * @since 2023/12/6
 */
@RestController
@Tag(name = "TestController", description = "测试接口")
@RequestMapping("/test")
public class TestController {

    @Operation(summary = "返回字符串")
    @ApiOperationSupport(order = 1)
    @RequestMapping(method = RequestMethod.POST)
    public String sayHello(@RequestParam String text) {
        return text;
    }
}
