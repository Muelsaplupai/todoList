package edu.seu.todo_list_service_springboot.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "待办事项DTO")
@Data
public class TodoDTO {
    @Schema(description = "待办事项内容")
    private String content;
}
