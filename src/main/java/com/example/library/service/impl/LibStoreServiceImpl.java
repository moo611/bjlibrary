package com.example.library.service.impl;

import java.util.Date;
import java.util.List;

import com.example.library.domain.LibBook;
import com.example.library.mapper.LibBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.library.mapper.LibStoreMapper;
import com.example.library.domain.LibStore;
import com.example.library.service.ILibStoreService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 出入库Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@Service
public class LibStoreServiceImpl implements ILibStoreService {
    @Autowired
    private LibStoreMapper libStoreMapper;
    @Autowired
    private LibBookMapper libBookMapper;

    /**
     * 查询出入库
     *
     * @param id 出入库主键
     * @return 出入库
     */
    @Override
    public LibStore selectLibStoreById(Long id) {
        return libStoreMapper.selectLibStoreById(id);
    }

    /**
     * 查询出入库列表
     *
     * @param libStore 出入库
     * @return 出入库
     */
    @Override
    public List<LibStore> selectLibStoreList(LibStore libStore) {
        return libStoreMapper.selectLibStoreList(libStore);
    }

    /**
     * 新增出入库
     *
     * @param libStore 出入库
     * @return 结果
     */
    @Override
    @Transactional
    public int insertLibStore(LibStore libStore) {
        libStore.setCreateTime(new Date());
        int rows = libStoreMapper.insertLibStore(libStore);

        LibBook libBook = libBookMapper.selectLibBookById(libStore.getBookId());
        int curStore = libBook.getStoreNum();
        curStore+=libStore.getInStoreNum();
        libBook.setStoreNum(curStore);
        libBookMapper.updateLibBook(libBook);

        return rows;
    }

    /**
     * 修改出入库
     *
     * @param libStore 出入库
     * @return 结果
     */
    @Override
    public int updateLibStore(LibStore libStore) {
        libStore.setUpdateTime(new Date());
        return libStoreMapper.updateLibStore(libStore);
    }

    /**
     * 批量删除出入库
     *
     * @param ids 需要删除的出入库主键
     * @return 结果
     */
    @Override
    public int deleteLibStoreByIds(Long[] ids) {
        return libStoreMapper.deleteLibStoreByIds(ids);
    }

    /**
     * 删除出入库信息
     *
     * @param id 出入库主键
     * @return 结果
     */
    @Override
    public int deleteLibStoreById(Long id) {
        return libStoreMapper.deleteLibStoreById(id);
    }
}
