package com.example.library.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.library.mapper.LibBookMapper;
import com.example.library.domain.LibBook;
import com.example.library.service.ILibBookService;

/**
 * 图书Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@Service
public class LibBookServiceImpl implements ILibBookService
{
    @Autowired
    private LibBookMapper libBookMapper;

    /**
     * 查询图书
     *
     * @param id 图书主键
     * @return 图书
     */
    @Override
    public LibBook selectLibBookById(Long id)
    {
        return libBookMapper.selectLibBookById(id);
    }

    /**
     * 查询图书列表
     *
     * @param libBook 图书
     * @return 图书
     */
    @Override
    public List<LibBook> selectLibBookList(LibBook libBook)
    {
        return libBookMapper.selectLibBookList(libBook);
    }

    /**
     * 新增图书
     *
     * @param libBook 图书
     * @return 结果
     */
    @Override
    public int insertLibBook(LibBook libBook)
    {
        libBook.setCreateTime(new Date());
        return libBookMapper.insertLibBook(libBook);
    }

    /**
     * 修改图书
     *
     * @param libBook 图书
     * @return 结果
     */
    @Override
    public int updateLibBook(LibBook libBook)
    {
        libBook.setUpdateTime(new Date());
        return libBookMapper.updateLibBook(libBook);
    }

    /**
     * 批量删除图书
     *
     * @param ids 需要删除的图书主键
     * @return 结果
     */
    @Override
    public int deleteLibBookByIds(Long[] ids)
    {
        return libBookMapper.deleteLibBookByIds(ids);
    }

    /**
     * 删除图书信息
     *
     * @param id 图书主键
     * @return 结果
     */
    @Override
    public int deleteLibBookById(Long id)
    {
        return libBookMapper.deleteLibBookById(id);
    }
}
