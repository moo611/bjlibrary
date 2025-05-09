package com.example.library.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.library.domain.LibSeat;
import com.example.library.domain.base.AjaxResult;
import com.example.library.domain.base.R;
import com.example.library.domain.req.LibSeatListReq;
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

import com.example.library.domain.LibSeat;
import com.example.library.service.ILibSeatService;


/**
 * 座位Controller
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@RestController
@RequestMapping("/seat")
public class LibSeatController extends BaseController
{
    @Autowired
    private ILibSeatService libSeatService;

    /**
     * 查询座位列表
     */
    
    @GetMapping("/list")
    public R list(LibSeatListReq libSeatListReq )
    {
        PageHelper.startPage(libSeatListReq.getPageNum(), libSeatListReq.getPageSize());
        LibSeat libSeat = new LibSeat();
        BeanUtils.copyProperties(libSeatListReq, libSeat);

        List<LibSeat> libSeats = libSeatService.selectLibSeatList(libSeat);
        if (libSeats.size() > 0) {
            PageInfo<LibSeat> pageInfo = new PageInfo<>(libSeats);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<LibSeat>(Collections.emptyList()));
    }



    /**
     * 获取座位详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(libSeatService.selectLibSeatById(id));
    }

    /**
     * 新增座位
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody LibSeat libSeat)
    {
        int rows = libSeatService.insertLibSeat(libSeat);
        if (rows == -32001){
            return AjaxResult.error("该座位号已存在");
        }
        return toAjax(rows);
    }

    /**
     * 修改座位
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody LibSeat libSeat)
    {
        return toAjax(libSeatService.updateLibSeat(libSeat));
    }

    /**
     * 删除座位
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(libSeatService.deleteLibSeatByIds(ids));
    }
}
