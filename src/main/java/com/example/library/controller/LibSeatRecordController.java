package com.example.library.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.library.domain.LibSeatRecord;
import com.example.library.domain.base.AjaxResult;
import com.example.library.domain.base.R;
import com.example.library.domain.req.LibSeatRecordListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.LibSeatRecord;
import com.example.library.service.ILibSeatRecordService;


/**
 * 座位记录Controller
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@RestController
@RequestMapping("/record")
public class LibSeatRecordController extends BaseController
{
    @Autowired
    private ILibSeatRecordService libSeatRecordService;

    /**
     * 查询座位记录列表
     */
   
    @GetMapping("/list")
    public R list(LibSeatRecordListReq libSeatRecordListReq)
    {
        PageHelper.startPage(libSeatRecordListReq.getPageNum(), libSeatRecordListReq.getPageSize());
        LibSeatRecord libSeatRecord = new LibSeatRecord();
        BeanUtils.copyProperties(libSeatRecordListReq, libSeatRecord);

        List<LibSeatRecord> libSeatRecords = libSeatRecordService.selectLibSeatRecordList(libSeatRecord);
        if (libSeatRecords.size() > 0) {
            PageInfo<LibSeatRecord> pageInfo = new PageInfo<>(libSeatRecords);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<LibSeatRecord>(Collections.emptyList()));
    }

  

    /**
     * 获取座位记录详细信息
     */
   
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(libSeatRecordService.selectLibSeatRecordById(id));
    }

    /**
     * 新增座位记录
     */
   
   
    @PostMapping
    public AjaxResult add(@RequestBody LibSeatRecord libSeatRecord)
    {
        int rows = libSeatRecordService.insertLibSeatRecord(libSeatRecord);
        if (rows == -32001){
            return AjaxResult.error("该座位被占用");
        }
        return toAjax(rows);
    }

    @PostMapping("/back")
    public AjaxResult back(@RequestBody LibSeatRecord libSeatRecord){
        return toAjax(libSeatRecordService.back(libSeatRecord));
    }

    /**
     * 修改座位记录
     */
   
   
    @PutMapping
    public AjaxResult edit(@RequestBody LibSeatRecord libSeatRecord)
    {
        return toAjax(libSeatRecordService.updateLibSeatRecord(libSeatRecord));
    }

    /**
     * 删除座位记录
     */
   
   
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(libSeatRecordService.deleteLibSeatRecordByIds(ids));
    }
}
