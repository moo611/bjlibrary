package com.example.library.mapper;

import java.util.List;
import com.example.library.domain.LibBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * 图书Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@Mapper
public interface LibBookMapper
{
    /**
     * 查询图书
     *
     * @param id 图书主键
     * @return 图书
     */
    public LibBook selectLibBookById(Long id);

    /**
     * 查询图书列表
     *
     * @param libBook 图书
     * @return 图书集合
     */
    public List<LibBook> selectLibBookList(LibBook libBook);

    /**
     * 新增图书
     *
     * @param libBook 图书
     * @return 结果
     */
    public int insertLibBook(LibBook libBook);

    /**
     * 修改图书
     *
     * @param libBook 图书
     * @return 结果
     */
    public int updateLibBook(LibBook libBook);

    /**
     * 删除图书
     *
     * @param id 图书主键
     * @return 结果
     */
    public int deleteLibBookById(Long id);

    /**
     * 批量删除图书
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLibBookByIds(Long[] ids);
}
