package edu.seu.todo_list_service_springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.seu.todo_list_service_springboot.entity.dto.TodoDTO;
import edu.seu.todo_list_service_springboot.entity.po.TodoPO;
import edu.seu.todo_list_service_springboot.entity.vo.TodoVO;
import edu.seu.todo_list_service_springboot.mapper.TodoMapper;
import edu.seu.todo_list_service_springboot.service.TodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl extends ServiceImpl<TodoMapper, TodoPO> implements TodoService {

    @Override
    public List<TodoVO> getTodos() {
        List<TodoPO> todoPOList = list();
        List<TodoVO> todoVOList = new ArrayList<>();
        for (TodoPO todoPO : todoPOList) {
            TodoVO todoVO = new TodoVO();
            BeanUtils.copyProperties(todoPO, todoVO);
            todoVOList.add(todoVO);
        }
        return todoVOList;
    }

    @Override
    public TodoVO createTodo(TodoDTO todoDTO) {
        TodoPO todoPO = new TodoPO();
        todoPO.setContent(todoDTO.getContent());
        save(todoPO);
        TodoVO todoVO = new TodoVO();
        BeanUtils.copyProperties(todoPO, todoVO);
        return todoVO;
    }

    @Override
    public Boolean deleteTodo(Integer todoId) {
        return removeById(todoId);
    }
}
