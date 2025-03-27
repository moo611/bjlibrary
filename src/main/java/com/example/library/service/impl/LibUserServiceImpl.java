package com.example.library.service.impl;

import com.example.library.domain.LibUser;
import com.example.library.mapper.LibUserMapper;
import com.example.library.service.ILibUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-19
 */
@Service
public class LibUserServiceImpl implements ILibUserService
{
    @Autowired
    private LibUserMapper libUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;  // 注入 PasswordEncode
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public LibUser selectLibUserById(Long id)
    {
        return libUserMapper.selectLibUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param libUser 用户
     * @return 用户
     */
    @Override
    public List<LibUser> selectLibUserList(LibUser libUser)
    {
        return libUserMapper.selectLibUserList(libUser);
    }

    /**
     * 新增用户
     *
     * @param libUser 用户
     * @return 结果
     */
    @Override
    public int insertLibUser(LibUser libUser)
    {
        LibUser old = libUserMapper.selectLibUserByUsername(libUser.getUsername());
        if (old != null){
            return -32001;
        }
        String encodedPassword = passwordEncoder.encode(libUser.getPassword());
        libUser.setPassword(encodedPassword);
        libUser.setCreateTime(new Date());

        return libUserMapper.insertLibUser(libUser);
    }

    /**
     * 修改用户
     *
     * @param libUser 用户
     * @return 结果
     */
    @Override
    public int updateLibUser(LibUser libUser)
    {

        LibUser old = libUserMapper.selectLibUserByUsername(libUser.getUsername());
        if (!old.getId().equals(libUser.getId())){
            return -32001;
        }

        libUser.setUpdateTime(new Date());
        return libUserMapper.updateLibUser(libUser);
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteLibUserByIds(Long[] ids)
    {
        return libUserMapper.deleteLibUserByIds(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteLibUserById(Long id)
    {
        return libUserMapper.deleteLibUserById(id);
    }

    @Override
    public LibUser selectRtUserByUsername(String username) {
        return libUserMapper.selectLibUserByUsername(username);
    }
}
