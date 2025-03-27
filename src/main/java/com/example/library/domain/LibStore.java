package com.example.library.domain;


import com.example.library.domain.base.BaseEntity;

/**
 * 出入库对象 lib_store
 *
 * @author ruoyi
 * @date 2025-03-26
 */
public class LibStore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private Long bookId;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    String bookName;

    /** 入库数量 */
    
    private Long inStoreNum;

    /** 删除标识 */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBookId(Long bookId)
    {
        this.bookId = bookId;
    }

    public Long getBookId()
    {
        return bookId;
    }
    public void setInStoreNum(Long inStoreNum)
    {
        this.inStoreNum = inStoreNum;
    }

    public Long getInStoreNum()
    {
        return inStoreNum;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

   
}
