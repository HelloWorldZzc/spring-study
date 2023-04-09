package com.example.mybatisplus_plug.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("mybatis_plus_product")
public class product {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("price")
    private int price;
    @Version
    public int version;
}
