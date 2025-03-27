package com.example.library.domain;


import com.example.library.domain.base.BaseEntity;

/**
 * 座位对象 lib_seat
 *
 * @author ruoyi
 * @date 2025-03-26
 */
public class LibSeat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 座位号 */
    
    private String code;

    /** 0、空闲1、占用 */
    
    private String status;

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
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
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
