package com.example.demo.common.core;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author :tanjm
 * Date:  2021/6/29
 * Desc:
 * @author tanjm
 */
public class CommonEntity implements Serializable {
    private static final long serialVersionUID = 2107419890977148627L;
    /**
     * 记录主键
     */
    protected Long id;
    /**
     * 创建人UserID
     */
    protected Long creatorId;
    protected String creatorName;
    /**
     * 创建时间
     */
    protected LocalDateTime createTime;
    /**
     * 最后修改人UserID
     */
    protected Long modifierId;
    protected String modifierName;
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

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
}
