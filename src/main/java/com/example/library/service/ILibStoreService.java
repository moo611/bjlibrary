package com.example.library.service;

import java.util.List;
import com.example.library.domain.LibStore;

/**
 * 出入库Service接口
 *
 * @author ruoyi
 * @date 2025-03-26
 */
public interface ILibStoreService
{
    /**
     * 查询出入库
     *
     * @param id 出入库主键
     * @return 出入库
     */
    public LibStore selectLibStoreById(Long id);

    /**
     * 查询出入库列表
     *
     * @param libStore 出入库
     * @return 出入库集合
     */
    public List<LibStore> selectLibStoreList(LibStore libStore);

    /**
     * 新增出入库
     *
     * @param libStore 出入库
     * @return 结果
     */
    public int insertLibStore(LibStore libStore);

    /**
     * 修改出入库
     *
     * @param libStore 出入库
     * @return 结果
     */
    public int updateLibStore(LibStore libStore);

    /**
     * 批量删除出入库
     *
     * @param ids 需要删除的出入库主键集合
     * @return 结果
     */
    public int deleteLibStoreByIds(Long[] ids);

    /**
     * 删除出入库信息
     *
     * @param id 出入库主键
     * @return 结果
     */
    public int deleteLibStoreById(Long id);
}
