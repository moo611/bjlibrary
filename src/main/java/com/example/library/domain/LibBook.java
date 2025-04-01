package com.example.library.domain;


import com.example.library.domain.base.BaseEntity;

/**
 * 图书对象 lib_book
 *
 * @author ruoyi
 * @date 2025-03-26
 */
public class LibBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 名称 */
    
    private String name;

    /** 类别 */
    
    private String category;

    /** 作者 */
    
    private String author;

    /** 内容 */
    
    private String content;

    /** 库存 */
    
    private Integer storeNum;

    /** $column.columnComment */
    
    private String imageUrl;

    /** 删除标识 */
    private String delFlag;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private Double price;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setStoreNum(Integer storeNum)
    {
        this.storeNum = storeNum;
    }

    public Integer getStoreNum()
    {
        return storeNum;
    }
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
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
