package com.example.library.service;

import java.util.List;
import com.example.library.domain.LibSeat;

/**
 * 座位Service接口
 *
 * @author ruoyi
 * @date 2025-03-26
 */
public interface ILibSeatService
{
    /**
     * 查询座位
     *
     * @param id 座位主键
     * @return 座位
     */
    public LibSeat selectLibSeatById(Long id);

    /**
     * 查询座位列表
     *
     * @param libSeat 座位
     * @return 座位集合
     */
    public List<LibSeat> selectLibSeatList(LibSeat libSeat);

    /**
     * 新增座位
     *
     * @param libSeat 座位
     * @return 结果
     */
    public int insertLibSeat(LibSeat libSeat);

    /**
     * 修改座位
     *
     * @param libSeat 座位
     * @return 结果
     */
    public int updateLibSeat(LibSeat libSeat);

    /**
     * 批量删除座位
     *
     * @param ids 需要删除的座位主键集合
     * @return 结果
     */
    public int deleteLibSeatByIds(Long[] ids);

    /**
     * 删除座位信息
     *
     * @param id 座位主键
     * @return 结果
     */
    public int deleteLibSeatById(Long id);
}
