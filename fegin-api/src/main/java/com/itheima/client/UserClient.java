package com.itheima.client;

import com.itheima.pojo.ResponseModel;
import com.itheima.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(value = "userServer" /*调用方服务名*/)
//@FeignClient(value = "userServer", configuration = DefaultFeignConfiguration.class) // 接口生效
public interface UserClient {

    @PostMapping("/user/user"/*调用方路径*/)
    ResponseModel sendDir(Map<String,String> param );
}
