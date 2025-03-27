package com.example.library.mapper;

import java.util.List;
import com.example.library.domain.LibSeat;
import org.apache.ibatis.annotations.Mapper;

/**
 * 座位Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@Mapper
public interface LibSeatMapper
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
     * 删除座位
     *
     * @param id 座位主键
     * @return 结果
     */
    public int deleteLibSeatById(Long id);

    /**
     * 批量删除座位
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLibSeatByIds(Long[] ids);

    LibSeat selectLibSeatByCode(String code);

}
