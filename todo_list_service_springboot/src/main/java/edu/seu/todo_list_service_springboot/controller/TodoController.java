package edu.seu.todo_list_service_springboot.controller;

import edu.seu.todo_list_service_springboot.entity.dto.TodoDTO;
import edu.seu.todo_list_service_springboot.entity.vo.TodoVO;
import edu.seu.todo_list_service_springboot.service.TodoService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Schema(description = "待办事项控制器")
@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @Schema(description = "获取待办事项列表")
    @GetMapping
    public List<TodoVO> getTodos() {
        return todoService.getTodos();
    }

    @Schema(description = "创建待办事项")
    @PostMapping
    public TodoVO createTodo(@RequestBody TodoDTO todoDTO) {
        return todoService.createTodo(todoDTO);
    }

    @Schema(description = "删除待办事项")
    @DeleteMapping("/{id}")
    public Map<String, String> deleteTodo(@PathVariable Integer id) {
        boolean deleted = todoService.deleteTodo(id);
        return deleted ? Map.of("message", "Todo deleted") : Map.of("error", "Todo not found");
    }
}

