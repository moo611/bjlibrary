package com.example.library.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.library.domain.LibStore;
import com.example.library.domain.base.AjaxResult;
import com.example.library.domain.base.R;
import com.example.library.domain.req.LibStoreListReq;
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

import com.example.library.domain.LibStore;
import com.example.library.service.ILibStoreService;


/**
 * 出入库Controller
 *
 * @author ruoyi
 * @date 2025-03-26
 */
@RestController
@RequestMapping("/store")
public class LibStoreController extends BaseController
{
    @Autowired
    private ILibStoreService libStoreService;

    /**
     * 查询出入库列表
     */
    
    @GetMapping("/list")
    public R list(LibStoreListReq libStoreListReq)
    {
        PageHelper.startPage(libStoreListReq.getPageNum(), libStoreListReq.getPageSize());
        LibStore libStore = new LibStore();
        BeanUtils.copyProperties(libStoreListReq, libStore);

        List<LibStore> libStores = libStoreService.selectLibStoreList(libStore);
        if (libStores.size() > 0) {
            PageInfo<LibStore> pageInfo = new PageInfo<>(libStores);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<LibStore>(Collections.emptyList()));
    }

 

    /**
     * 获取出入库详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(libStoreService.selectLibStoreById(id));
    }

    /**
     * 新增出入库
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody LibStore libStore)
    {
        return toAjax(libStoreService.insertLibStore(libStore));
    }

    /**
     * 修改出入库
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody LibStore libStore)
    {
        return toAjax(libStoreService.updateLibStore(libStore));
    }

    /**
     * 删除出入库
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(libStoreService.deleteLibStoreByIds(ids));
    }
}
