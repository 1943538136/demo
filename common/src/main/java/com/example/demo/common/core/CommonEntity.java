package com.example.demo.common.core;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author :tanjm
 * Date:  2021/6/29
 * Desc:
 */
public class CommonEntity implements Serializable {
    /**
     * 记录主键
     */
    protected Long id;
    /**
     * 创建人UserID
     */
    protected Long creator;
    /**
     * 创建时间
     */
    protected LocalDateTime createTime;
    /**
     * 最后修改人UserID
     */
    protected Long modifier;
    /**
     *最后修改时间
     */
    protected LocalDateTime modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
}
