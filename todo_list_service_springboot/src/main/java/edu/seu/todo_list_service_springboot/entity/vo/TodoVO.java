package edu.seu.todo_list_service_springboot.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "待办事项VO")
@Data
public class TodoVO {

    @Schema(description = "待办事项ID")
    private Integer id;

    @Schema(description = "待办事项内容")
    private String content;
}
