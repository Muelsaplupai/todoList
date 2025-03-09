package edu.seu.todo_list_service_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.seu.todo_list_service_springboot.entity.po.TodoPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper extends BaseMapper<TodoPO> {
}