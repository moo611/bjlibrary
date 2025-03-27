package com.example.library.service.impl;

import java.util.Date;
import java.util.List;

import com.example.library.domain.LibSeat;
import com.example.library.mapper.LibSeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.library.mapper.LibSeatRecordMapper;
import com.example.library.domain.LibSeatRecord;
import com.example.library.service.ILibSeatRecordService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 座位记录Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@Service
public class LibSeatRecordServiceImpl implements ILibSeatRecordService
{
    @Autowired
    private LibSeatRecordMapper libSeatRecordMapper;
    @Autowired
    private LibSeatMapper libSeatMapper;

    /**
     * 查询座位记录
     *
     * @param id 座位记录主键
     * @return 座位记录
     */
    @Override
    public LibSeatRecord selectLibSeatRecordById(Long id)
    {
        return libSeatRecordMapper.selectLibSeatRecordById(id);
    }

    /**
     * 查询座位记录列表
     *
     * @param libSeatRecord 座位记录
     * @return 座位记录
     */
    @Override
    public List<LibSeatRecord> selectLibSeatRecordList(LibSeatRecord libSeatRecord)
    {
        return libSeatRecordMapper.selectLibSeatRecordList(libSeatRecord);
    }

    /**
     * 新增座位记录
     *
     * @param libSeatRecord 座位记录
     * @return 结果
     */
    @Override
    @Transactional
    public int insertLibSeatRecord(LibSeatRecord libSeatRecord)
    {

        LibSeat libSeat = libSeatMapper.selectLibSeatByCode(libSeatRecord.getCode());
        if (libSeat.getStatus().equals("1")){
            return -32001;
        }

        libSeat.setStatus("1");
        libSeatMapper.updateLibSeat(libSeat);

        libSeatRecord.setCreateTime(new Date());
        return libSeatRecordMapper.insertLibSeatRecord(libSeatRecord);
    }

    /**
     * 修改座位记录
     *
     * @param libSeatRecord 座位记录
     * @return 结果
     */
    @Override
    @Transactional
    public int updateLibSeatRecord(LibSeatRecord libSeatRecord)
    {

        libSeatRecord.setUpdateTime(new Date());
        return libSeatRecordMapper.updateLibSeatRecord(libSeatRecord);
    }

    /**
     * 批量删除座位记录
     *
     * @param ids 需要删除的座位记录主键
     * @return 结果
     */
    @Override
    public int deleteLibSeatRecordByIds(Long[] ids)
    {
        return libSeatRecordMapper.deleteLibSeatRecordByIds(ids);
    }

    /**
     * 删除座位记录信息
     *
     * @param id 座位记录主键
     * @return 结果
     */
    @Override
    public int deleteLibSeatRecordById(Long id)
    {
        return libSeatRecordMapper.deleteLibSeatRecordById(id);
    }

    @Override
    @Transactional
    public int back(LibSeatRecord libSeatRecord) {

        LibSeat libSeat = libSeatMapper.selectLibSeatByCode(libSeatRecord.getCode());
        libSeat.setStatus("0");
        libSeatMapper.updateLibSeat(libSeat);

        return libSeatRecordMapper.deleteLibSeatRecordById(libSeatRecord.getId());
    }
}
