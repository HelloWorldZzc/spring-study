package com.example.p26_mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data //lombok注解能快速生成javabean 与此相同的还有@NoArgsConstructor @Setter data是最全的
@TableName("user_mybatis_plus")//指定是某个表的，不然默认访问数据库中类名的表
public class user {
    //表明此为字段对应表中的主键，默认主键为雪花算法生成，使用type改成递增
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "name")
    private String name;
    private Integer age;
    private String email;
}
