package com.example.library.mapper;

import java.util.List;
import com.example.library.domain.LibBorrow;
import org.apache.ibatis.annotations.Mapper;

/**
 * 借阅Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@Mapper
public interface LibBorrowMapper
{
    /**
     * 查询借阅
     *
     * @param id 借阅主键
     * @return 借阅
     */
    public LibBorrow selectLibBorrowById(Long id);

    /**
     * 查询借阅列表
     *
     * @param libBorrow 借阅
     * @return 借阅集合
     */
    public List<LibBorrow> selectLibBorrowList(LibBorrow libBorrow);

    /**
     * 新增借阅
     *
     * @param libBorrow 借阅
     * @return 结果
     */
    public int insertLibBorrow(LibBorrow libBorrow);

    /**
     * 修改借阅
     *
     * @param libBorrow 借阅
     * @return 结果
     */
    public int updateLibBorrow(LibBorrow libBorrow);

    /**
     * 删除借阅
     *
     * @param id 借阅主键
     * @return 结果
     */
    public int deleteLibBorrowById(Long id);

    /**
     * 批量删除借阅
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLibBorrowByIds(Long[] ids);

    LibBorrow selectLibBorrowByUsername(String username, Long bookId);

}
