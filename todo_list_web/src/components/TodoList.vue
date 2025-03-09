<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { todoApi } from '@/api/todoApi'
import type { Todo } from '@/types/todo'

const todos = ref<Todo[]>([])
const newTodo = ref('')

// 获取数据
const fetchTodos = async () => {
  todos.value = await todoApi.fetchTodos()
}

// 添加Todo
const addTodo = async () => {
  if (!newTodo.value.trim()) return
  await todoApi.addTodo(newTodo.value)
  newTodo.value = ''
  await fetchTodos()
}

// 删除Todo
const deleteTodo = async (id: number) => {
  await todoApi.deleteTodo(id)
  await fetchTodos()
}

onMounted(() => fetchTodos())
</script>

<template>
  <div class="container">
    <input v-model="newTodo" @keyup.enter="addTodo" placeholder="输入任务...">
    <ul>
      <li v-for="todo in todos" :key="todo.id">
        {{ todo.content }}
        <button @click="deleteTodo(todo.id)">×</button>
      </li>
    </ul>
  </div>
</template>

<style>
.container { max-width: 400px; margin: 20px auto; }
ul { list-style: none; padding: 0; }
li { display: flex; justify-content: space-between; margin: 5px 0; }
</style>