package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.itheima.client.UserClient;
import com.itheima.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 虎哥
 */
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // TODO 2.查询用户
        User user = userClient.findById(order.getUserId());

        order.setUser(user);
        // 4.返回
        return order;
    }
}
