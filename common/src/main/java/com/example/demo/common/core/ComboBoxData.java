package com.example.demo.common.core;

/**
 * Author :tanjm
 * Date:  2021/6/24
 * Desc:
 *
 * @author tanjm
 */
public class ComboBoxData<V, T> {
    private V value;
    private T text;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public T getText() {
        return text;
    }

    public void setText(T text) {
        this.text = text;
    }
}
