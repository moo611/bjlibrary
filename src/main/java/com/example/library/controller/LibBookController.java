package com.example.library.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.library.domain.base.AjaxResult;
import com.example.library.domain.base.R;
import com.example.library.domain.req.LibBookListReq;
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

import com.example.library.domain.LibBook;
import com.example.library.service.ILibBookService;


/**
 * 图书Controller
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@RestController
@RequestMapping("/book")
public class LibBookController extends BaseController
{
    @Autowired
    private ILibBookService libBookService;

    /**
     * 查询图书列表
     */
    
    @GetMapping("/list")
    public R list(LibBookListReq libBookListReq)
    {
        PageHelper.startPage(libBookListReq.getPageNum(), libBookListReq.getPageSize());
        LibBook libBook = new LibBook();
        BeanUtils.copyProperties(libBookListReq, libBook);

        List<LibBook> libBooks = libBookService.selectLibBookList(libBook);
        if (libBooks.size() > 0) {
            PageInfo<LibBook> pageInfo = new PageInfo<>(libBooks);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<LibBook>(Collections.emptyList()));
    }



    /**
     * 获取图书详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(libBookService.selectLibBookById(id));
    }

    /**
     * 新增图书
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody LibBook libBook)
    {
        return toAjax(libBookService.insertLibBook(libBook));
    }

    /**
     * 修改图书
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody LibBook libBook)
    {
        return toAjax(libBookService.updateLibBook(libBook));
    }

    /**
     * 删除图书
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(libBookService.deleteLibBookByIds(ids));
    }
}
