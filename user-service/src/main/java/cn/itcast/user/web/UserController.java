package cn.itcast.user.web;

import cn.itcast.user.pojo.ResponseModel;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 虎哥
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id, HttpServletRequest request) {
        System.out.println("UserController.queryById");
        int localPort = request.getLocalPort();
        User user = userService.queryById(id);
        user.setId(Long.valueOf(localPort));
        return user;
    }



    @PostMapping("/user")
    public ResponseModel queryOrderByUserId(@RequestBody Map<String,String> param ) {
        try{
            System.out.println("调用成功参数是"+param);
            return ResponseModel.ok("","成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseModel.error("","失败");
        }
    }
}
