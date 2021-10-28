package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 虎哥
 */
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private RestTemplate template;



    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // TODO 2.查询用户
        String url = "http://userServer/user/" + order.getUserId();
        System.out.println("url = " + url);
        User user = template.getForObject(url, User.class);
        // 3.封装user信息

        order.setUser(user);
        // 4.返回
        return order;
    }
}
