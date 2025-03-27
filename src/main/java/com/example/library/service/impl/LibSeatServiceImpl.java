package com.example.library.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.library.mapper.LibSeatMapper;
import com.example.library.domain.LibSeat;
import com.example.library.service.ILibSeatService;

/**
 * 座位Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@Service
public class LibSeatServiceImpl implements ILibSeatService
{
    @Autowired
    private LibSeatMapper libSeatMapper;

    /**
     * 查询座位
     *
     * @param id 座位主键
     * @return 座位
     */
    @Override
    public LibSeat selectLibSeatById(Long id)
    {
        return libSeatMapper.selectLibSeatById(id);
    }

    /**
     * 查询座位列表
     *
     * @param libSeat 座位
     * @return 座位
     */
    @Override
    public List<LibSeat> selectLibSeatList(LibSeat libSeat)
    {
        return libSeatMapper.selectLibSeatList(libSeat);
    }

    /**
     * 新增座位
     *
     * @param libSeat 座位
     * @return 结果
     */
    @Override
    public int insertLibSeat(LibSeat libSeat)
    {
        LibSeat old = libSeatMapper.selectLibSeatByCode(libSeat.getCode());
        if (old != null){
            return -32001;
        }
        libSeat.setCreateTime(new Date());
        return libSeatMapper.insertLibSeat(libSeat);
    }

    /**
     * 修改座位
     *
     * @param libSeat 座位
     * @return 结果
     */
    @Override
    public int updateLibSeat(LibSeat libSeat)
    {
        libSeat.setUpdateTime(new Date());
        return libSeatMapper.updateLibSeat(libSeat);
    }

    /**
     * 批量删除座位
     *
     * @param ids 需要删除的座位主键
     * @return 结果
     */
    @Override
    public int deleteLibSeatByIds(Long[] ids)
    {
        return libSeatMapper.deleteLibSeatByIds(ids);
    }

    /**
     * 删除座位信息
     *
     * @param id 座位主键
     * @return 结果
     */
    @Override
    public int deleteLibSeatById(Long id)
    {
        return libSeatMapper.deleteLibSeatById(id);
    }
}
