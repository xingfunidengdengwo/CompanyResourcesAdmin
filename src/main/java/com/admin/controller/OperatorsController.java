package com.admin.controller;

import com.admin.bean.Email;
import com.admin.bean.Operators;
import com.admin.common.CommonResult;
import com.admin.config.Config;
import com.admin.service.IOperatorsService;
import com.admin.service.impl.MsgService;
import com.admin.util.JWTUtil;
import com.admin.util.Page;
import com.admin.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@CrossOrigin
public class OperatorsController {

    @Autowired
    IOperatorsService operatorsService;
    //生成邮箱验证码
    Random random = new Random();
    String Vcode = String.valueOf(random.nextInt(9000) + 1000);
    @Autowired
    private Email email;
    @Autowired
    private MsgService msgService;

    //增加
    @PostMapping("operators")
    public CommonResult addOperators(@RequestBody Operators operators) {
        int result = operatorsService.addOperators(operators);
        if (result == 1) {
            operators = operatorsService.getOperatorsByID(operators.getId());
            return CommonResult.success(200, "注册成功", operators);
        } else {
            return CommonResult.success(400, "注册失败");
        }
    }

    //分页模糊查询
    @GetMapping("operators")
    public CommonResult getOperators(Operators operators, Page page) {
        List<Operators> list = operatorsService.getOperators(operators, page);
        int count = operatorsService.getCount(operators);
        HashMap map = new HashMap();
        map.put("list", list);
        map.put("count", count);
        return CommonResult.success(map);
    }

    //修改
    @PutMapping("operators")
    public CommonResult editOperators(@RequestBody Operators operators) {
        int count = operatorsService.editOperators(operators);
        operators = operatorsService.getOperatorsByID(operators.getId());
        if (count != 0) {
            return CommonResult.success(operators);
        } else {
            return CommonResult.fail(400, "原密码错误", operators);
        }
    }

    //删除
    @DeleteMapping("operators/{id}")
    public CommonResult delOperators(@PathVariable int id) {
        int count = operatorsService.delOperators(id);
        if (count > 0) {
            return CommonResult.success();
        } else {
            return CommonResult.fail();
        }
    }

    @PostMapping("dologin")
    public CommonResult doLogin(@RequestBody Operators operators) {
        Map<String, Object> token = operatorsService.doLogin(operators);

        if (token == null) {
            return CommonResult.fail(403, "登录失败");
        } else {
            return CommonResult.success(200, "登录成功", token);
        }
    }

    @GetMapping("checktoken")
    public CommonResult checkToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && JWTUtil.verifyToken(token)) {
            System.out.println("浏览器持有token   " + token);
            return CommonResult.success(200, "持有token");
        }
        return CommonResult.fail(400, "token不存在或不合法");
    }

    @PostMapping("operatorsimg/{id}")
    public CommonResult operatorsImg(@RequestParam("file") MultipartFile file, @PathVariable int id) {
        System.out.println("file----" + id);
        System.out.println(file);
        //存储文件
        String newName = UploadFileUtil.uploadfile(file);
        //将文件 地址存入数据库
        //返回上传文件的地址 or 返回上传头像的员工数据
        return CommonResult.success(Config.STATIC_PATH + newName);
    }

    @PutMapping("operatorsimg")
    public CommonResult operatorsimg(Operators operators) {
        System.out.println(operators.getId());
        System.out.println(operators.getImg());

        int count = operatorsService.operatorsImg(operators);
        return CommonResult.success(count);
    }

    //验证输入的邮箱验证码是否正确
    @PutMapping("validatecode")
    public CommonResult validatecode(@RequestBody Operators operators) {
        System.out.println(operators.getEmailVcode().equals(Vcode));

        if (operators.getEmailVcode().equals(Vcode)) {
            boolean f = operatorsService.updatePassword(operators);

            return CommonResult.success(operators);
        } else {
            return CommonResult.fail(400, "邮箱验证码不正确");
        }
    }

    //发送邮箱验证码消息
    @PostMapping("sendmsg")
    public CommonResult sendMsg(@RequestBody Operators operators) {
        operators = operatorsService.getOperatorsByName(operators.getName());
        if (operators != null) {
            email.setTo(operators.getEmail());
            msgService.sendMsg(Vcode);
            return CommonResult.success(operators);
        } else {
            return CommonResult.fail(400, "用户不存在");
        }
    }
}
