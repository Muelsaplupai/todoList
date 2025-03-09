package edu.seu.todo_list_service_springboot.service;


import edu.seu.todo_list_service_springboot.entity.dto.TodoDTO;
import edu.seu.todo_list_service_springboot.entity.po.TodoPO;
import edu.seu.todo_list_service_springboot.entity.vo.TodoVO;

import java.util.List;

public interface TodoService {

    List<TodoVO> getTodos();

    TodoVO createTodo(TodoDTO todoDTO);

    Boolean deleteTodo(Integer todoId);
}

