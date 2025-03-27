package com.example.library.controller;

import com.example.library.config.auth.JwtUtil;
import com.example.library.config.auth.MyUserDetailsService;
import com.example.library.config.auth.UserUtil;
import com.example.library.domain.LibUser;
import com.example.library.domain.base.AjaxResult;
import com.example.library.domain.base.R;
import com.example.library.domain.req.LoginReq;
import com.example.library.domain.req.LibUserListReq;
import com.example.library.service.ILibUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


/**
 * 用户Controller
 *
 * @author ruoyi
 * @date 2024-10-19
 */
@RestController
@RequestMapping("/user")
public class LibUserController extends BaseController {
    @Autowired
    private ILibUserService libUserService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    @ApiOperation("登录")
    public AjaxResult login(@RequestBody LoginReq loginReq) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword())
            );
        }catch (Exception e){
            return AjaxResult.error("用户名或密码错误");
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginReq.getUsername());
        return AjaxResult.success("ok",jwtUtil.generateToken(userDetails.getUsername()));

    }


    /**
     * 查询用户列表
     */

    @GetMapping("/list")
    public R list(LibUserListReq libUserListReq) {
        PageHelper.startPage(libUserListReq.getPageNum(), libUserListReq.getPageSize());
        LibUser libUser = new LibUser();
        BeanUtils.copyProperties(libUserListReq, libUser);

        List<LibUser> libUsers = libUserService.selectLibUserList(libUser);
        if (libUsers.size() > 0) {
            PageInfo<LibUser> pageInfo = new PageInfo<>(libUsers);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<LibUser>(Collections.emptyList()));
    }


    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(libUserService.selectLibUserById(id));
    }

    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/info")
    @ApiOperation("获取用户详细信息")
    public AjaxResult getInfo()
    {
        String username = UserUtil.getCurrentUsername();
        return success(libUserService.selectRtUserByUsername(username));
    }

    /**
     * 新增用户
     */


    @PostMapping
    public AjaxResult add(@RequestBody LibUser libUser) {

        int res = libUserService.insertLibUser(libUser);
        if (res == -32001){
            return AjaxResult.error("用户名已存在");
        }
        return toAjax(res);


    }

    /**
     * 修改用户
     */


    @PutMapping
    public AjaxResult edit(@RequestBody LibUser libUser) {
        int res = libUserService.updateLibUser(libUser);
        if (res == -32001){
            return AjaxResult.error("用户名已存在");
        }
        return toAjax(res);
    }

    /**
     * 删除用户
     */


    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(libUserService.deleteLibUserByIds(ids));
    }
}
