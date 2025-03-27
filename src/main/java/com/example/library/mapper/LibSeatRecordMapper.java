package com.example.library.mapper;

import java.util.List;
import com.example.library.domain.LibSeatRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 座位记录Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@Mapper
public interface LibSeatRecordMapper
{
    /**
     * 查询座位记录
     *
     * @param id 座位记录主键
     * @return 座位记录
     */
    public LibSeatRecord selectLibSeatRecordById(Long id);

    /**
     * 查询座位记录列表
     *
     * @param libSeatRecord 座位记录
     * @return 座位记录集合
     */
    public List<LibSeatRecord> selectLibSeatRecordList(LibSeatRecord libSeatRecord);

    /**
     * 新增座位记录
     *
     * @param libSeatRecord 座位记录
     * @return 结果
     */
    public int insertLibSeatRecord(LibSeatRecord libSeatRecord);

    /**
     * 修改座位记录
     *
     * @param libSeatRecord 座位记录
     * @return 结果
     */
    public int updateLibSeatRecord(LibSeatRecord libSeatRecord);

    /**
     * 删除座位记录
     *
     * @param id 座位记录主键
     * @return 结果
     */
    public int deleteLibSeatRecordById(Long id);

    /**
     * 批量删除座位记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLibSeatRecordByIds(Long[] ids);
}
