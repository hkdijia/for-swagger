package com.gotkx.springbootshare2020.response;

import com.gotkx.springbootshare2020.entiy.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "PageSetUserResponse  分页列表结果集", description = "")
public class PageSetUserResponse implements Serializable {

    @ApiModelProperty("总数")
    private String total;

    @ApiModelProperty("记录内容")
    private List<User> contents;

    @Override
    public String toString() {
        return "PageSetUserResponse{" +
                "total='" + total + '\'' +
                ", contents=" + contents +
                '}';
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<User> getContents() {
        return contents;
    }

    public void setContents(List<User> contents) {
        this.contents = contents;
    }
}
