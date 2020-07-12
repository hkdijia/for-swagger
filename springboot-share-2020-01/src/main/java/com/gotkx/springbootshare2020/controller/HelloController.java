package com.gotkx.springbootshare2020.controller;

import com.gotkx.springbootshare2020.entiy.JsonResult;
import com.gotkx.springbootshare2020.entiy.User;
import com.gotkx.springbootshare2020.response.PageSetUserResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    public String hello(){
        return "hello gotkx";
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加用户信息")
    public JsonResult<User> insertUser(@RequestBody @ApiParam(value = "用户信息") User user) {
        User resUser = new User();
        BeanUtils.copyProperties(user,resUser);
        JsonResult<User> result = new JsonResult<>(resUser);
        // 处理添加逻辑
        System.out.println(result);
        return result;
    }


    /**
     *  当返回值是一个Object 对应为一个类，容易解决
     */
    @GetMapping("/getObject/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = User.class)
    })
    public Object getObject(
            @PathVariable @ApiParam(value = "用户唯一标识") Long id) {
        // 模拟数据库中根据id获取User信息
        User user = new User(10L, "didid", "123456");
        System.out.println(user);
        return user;
    }


    /**
     * 当返回值是一个Object 对应为一个List<User>集合
     * @param id
     * @return
     */
    @GetMapping("/getListObject{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = User[].class)
    })
    public Object getListObject(
             @ApiParam(value = "用户唯一标识",required=true) @PathVariable Long id) {
        // 模拟数据库中根据id获取User信息
        User user = new User(id, "dididi", "123456");
        User user_2 = new User(id, "黄凯", "654321");
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user_2);
        System.out.println(list);
        return list;
    }


    /**
     * 当返回值是一个Object 对应为一个Map<>集合
     * 常见于分页，如  Map里面包含记录数和记录详情
     * @param id
     * @return
     */
    @GetMapping("/getMapObject{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = PageSetUserResponse.class)
    })
    public Map<String,Object> getMapObject(
            @ApiParam(value = "用户唯一标识",required=true) @PathVariable Long id) {
        // 模拟数据库中根据id获取User信息
        User user = new User(id, "dididi", "123456");
        User user_2 = new User(id, "黄凯", "654321");

        ArrayList<User> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        list.add(user);
        list.add(user_2);
        map.put("contents",list);
        map.put("total",2);
        System.out.println(map);
        return map;
    }




}
