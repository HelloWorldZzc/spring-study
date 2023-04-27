package com.study.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("book")
public class book {
    @TableId(type = IdType.AUTO)
    private int id;
    @TableField("type")
    private String type;
    @TableField("name")
    private String name;
    @TableField("description")
    private String description;

}
