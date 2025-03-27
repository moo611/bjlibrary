package com.example.library.mapper;

import com.example.library.domain.LibUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户Mapper接口
 *
 * @author ruoyi
 * @date 2024-10-19
 */
@Mapper
public interface LibUserMapper
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
     * 删除用户
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteLibUserById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLibUserByIds(Long[] ids);

    LibUser selectLibUserByUsername(String username);

}
