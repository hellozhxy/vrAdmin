package com.vr.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 俊
 *
 */
public class VideoCategory implements Serializable{
	
	private static final long serialVersionUID = -8019757940010424886L;

	private Long id;

    private String categoryName;

    private Integer status;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}