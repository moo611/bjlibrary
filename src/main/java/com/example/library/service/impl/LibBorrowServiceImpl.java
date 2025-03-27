package com.example.library.service.impl;

import java.util.Date;
import java.util.List;

import com.example.library.domain.LibBook;
import com.example.library.mapper.LibBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.library.mapper.LibBorrowMapper;
import com.example.library.domain.LibBorrow;
import com.example.library.service.ILibBorrowService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 借阅Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@Service
public class LibBorrowServiceImpl implements ILibBorrowService {
    @Autowired
    private LibBorrowMapper libBorrowMapper;
    @Autowired
    private LibBookMapper libBookMapper;

    /**
     * 查询借阅
     *
     * @param id 借阅主键
     * @return 借阅
     */
    @Override
    public LibBorrow selectLibBorrowById(Long id) {
        return libBorrowMapper.selectLibBorrowById(id);
    }

    /**
     * 查询借阅列表
     *
     * @param libBorrow 借阅
     * @return 借阅
     */
    @Override
    public List<LibBorrow> selectLibBorrowList(LibBorrow libBorrow) {
        return libBorrowMapper.selectLibBorrowList(libBorrow);
    }

    /**
     * 新增借阅
     *
     * @param libBorrow 借阅
     * @return 结果
     */
    @Override
    @Transactional
    public int insertLibBorrow(LibBorrow libBorrow) {

        LibBorrow old = libBorrowMapper.selectLibBorrowByUsername(libBorrow.getUsername(), libBorrow.getBookId());
        if (old != null) {
            return -32001;
        }
        //查看、更新库存
        LibBook libBook = libBookMapper.selectLibBookById(libBorrow.getBookId());
        int curNum = libBook.getStoreNum();
        if (curNum == 0) {
            return -32002;
        }
        curNum--;
        libBook.setStoreNum(curNum);
        libBookMapper.updateLibBook(libBook);

        libBorrow.setCreateTime(new Date());
        return libBorrowMapper.insertLibBorrow(libBorrow);
    }

    /**
     * 修改借阅
     *
     * @param libBorrow 借阅
     * @return 结果
     */
    @Override
    @Transactional
    public int updateLibBorrow(LibBorrow libBorrow) {

        LibBook libBook = libBookMapper.selectLibBookById(libBorrow.getBookId());
        int curNum = libBook.getStoreNum();
        curNum++;
        libBook.setStoreNum(curNum);
        libBookMapper.updateLibBook(libBook);

        libBorrow.setUpdateTime(new Date());
        return libBorrowMapper.updateLibBorrow(libBorrow);
    }

    /**
     * 批量删除借阅
     *
     * @param ids 需要删除的借阅主键
     * @return 结果
     */
    @Override
    public int deleteLibBorrowByIds(Long[] ids) {
        return libBorrowMapper.deleteLibBorrowByIds(ids);
    }

    /**
     * 删除借阅信息
     *
     * @param id 借阅主键
     * @return 结果
     */
    @Override
    public int deleteLibBorrowById(Long id) {
        return libBorrowMapper.deleteLibBorrowById(id);
    }
}
