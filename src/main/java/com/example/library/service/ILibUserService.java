package com.example.library.service;

import com.example.library.domain.LibUser;

import java.util.List;

/**
 * 用户Service接口
 *
 * @author ruoyi
 * @date 2024-10-19
 */
public interface ILibUserService
{
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    public LibUser selectLibUserById(Long id);

    /**
     * 查询用户列表
     *
     * @param libUser 用户
     * @return 用户集合
     */
    public List<LibUser> selectLibUserList(LibUser libUser);

    /**
     * 新增用户
     *
     * @param libUser 用户
     * @return 结果
     */
    public int insertLibUser(LibUser libUser);

    /**
     * 修改用户
     *
     * @param libUser 用户
     * @return 结果
     */
    public int updateLibUser(LibUser libUser);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteLibUserByIds(Long[] ids);

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteLibUserById(Long id);

    LibUser selectRtUserByUsername(String username);
}
