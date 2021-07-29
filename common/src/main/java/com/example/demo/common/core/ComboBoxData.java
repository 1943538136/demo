package com.example.demo.common.core;

import java.io.Serializable;

/**
 * Author :tanjm
 * Date:  2021/6/24
 * Desc:
 *
 * @author tanjm
 */
public class ComboBoxData<V, T>  implements Serializable {
    private static final long serialVersionUID = 8794411099975972694L;
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
