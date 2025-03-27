package com.example.library.service;

import java.util.List;
import com.example.library.domain.LibBorrow;

/**
 * 借阅Service接口
 *
 * @author ruoyi
 * @date 2025-03-26
 */
public interface ILibBorrowService
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
     * 批量删除借阅
     *
     * @param ids 需要删除的借阅主键集合
     * @return 结果
     */
    public int deleteLibBorrowByIds(Long[] ids);

    /**
     * 删除借阅信息
     *
     * @param id 借阅主键
     * @return 结果
     */
    public int deleteLibBorrowById(Long id);
}
