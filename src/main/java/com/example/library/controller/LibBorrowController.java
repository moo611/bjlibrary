package com.example.library.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.library.domain.LibBorrow;
import com.example.library.domain.base.AjaxResult;
import com.example.library.domain.base.R;
import com.example.library.domain.req.LibBorrowListReq;
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

import com.example.library.domain.LibBorrow;
import com.example.library.service.ILibBorrowService;


/**
 * 借阅Controller
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@RestController
@RequestMapping("/borrow")
public class LibBorrowController extends BaseController
{
    @Autowired
    private ILibBorrowService libBorrowService;

    /**
     * 查询借阅列表
     */
    
    @GetMapping("/list")
    public R list(LibBorrowListReq libBorrowListReq)
    {
        PageHelper.startPage(libBorrowListReq.getPageNum(), libBorrowListReq.getPageSize());
        LibBorrow libBorrow = new LibBorrow();
        BeanUtils.copyProperties(libBorrowListReq, libBorrow);

        List<LibBorrow> libBorrows = libBorrowService.selectLibBorrowList(libBorrow);
        if (libBorrows.size() > 0) {
            PageInfo<LibBorrow> pageInfo = new PageInfo<>(libBorrows);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<LibBorrow>(Collections.emptyList()));
    }

  

    /**
     * 获取借阅详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(libBorrowService.selectLibBorrowById(id));
    }

    /**
     * 新增借阅
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody LibBorrow libBorrow)
    {
        int rows = libBorrowService.insertLibBorrow(libBorrow);
        if (rows==-32001) {
            return AjaxResult.error("您已经借阅过了");
        }
        if (rows==-32002) {
            return AjaxResult.error("库存不足");
        }
        return toAjax(rows);
    }

    /**
     * 修改借阅
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody LibBorrow libBorrow)
    {
        return toAjax(libBorrowService.updateLibBorrow(libBorrow));
    }

    /**
     * 删除借阅
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(libBorrowService.deleteLibBorrowByIds(ids));
    }
}
