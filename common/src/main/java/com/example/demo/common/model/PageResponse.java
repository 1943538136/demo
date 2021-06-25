package com.example.demo.common.model;

import java.util.List;

/**
 * Author :tanjm
 * Date:  2021/6/22
 * Desc:
 * @author tanjm
 */
public class PageResponse<T> {
    private Integer current;
    private Integer size;
    private Integer total;
    private List<T> records;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
