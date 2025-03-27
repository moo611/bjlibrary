package com.example.library.mapper;

import java.util.List;
import com.example.library.domain.LibStore;
import org.apache.ibatis.annotations.Mapper;

/**
 * 出入库Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@Mapper
public interface LibStoreMapper
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
     * 删除出入库
     *
     * @param id 出入库主键
     * @return 结果
     */
    public int deleteLibStoreById(Long id);

    /**
     * 批量删除出入库
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLibStoreByIds(Long[] ids);
}
