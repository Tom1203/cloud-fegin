package cn.itcast.order.web;

import cn.itcast.order.service.OrderService;
import com.itheima.client.UserClient;
import com.itheima.pojo.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 虎哥
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private UserClient userClient;

    @PostMapping
    public ResponseModel queryOrderByUserId(@RequestBody Map<String, String> param) {
        // 根据id查询订单并返回
       // String orderId = param.get("orderId");

        ResponseModel responseModel = null;
        try {
            responseModel = userClient.sendDir(param);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.error("","调用失败");
        }
        log.info("推送柜面返回结果--→ {}",responseModel);
        return ResponseModel.ok("success", "已将该指令传递柜面系统");
    }
}
