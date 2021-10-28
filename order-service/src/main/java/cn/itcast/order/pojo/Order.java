package cn.itcast.order.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author 虎哥
 */
@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    @JsonIgnore
    private Long userId;
    private User user;
}