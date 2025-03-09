package edu.seu.todo_list_service_springboot.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "待办事项PO")
@Data
@TableName("todo")  // 指定表名
public class TodoPO {

    @Schema(description = "待办事项ID")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @Schema(description = "待办事项内容")
    private String content;
}


