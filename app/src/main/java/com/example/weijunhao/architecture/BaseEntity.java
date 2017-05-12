package com.example.weijunhao.architecture;

/**
 * Created by WEI JUNHAO on 2017/5/12.
 */

public class BaseEntity<E> {

    /**
     * desc : OK
     * status : 1000
     * data : {}
     */

    private String desc;
    private int status;
    private E data;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}
