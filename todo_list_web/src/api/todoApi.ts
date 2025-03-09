import type { Todo } from '@/types/todo'
import { apiClient } from './index'

export const todoApi = {
  async fetchTodos(): Promise<Todo[]> {
    const { data } = await apiClient.get('/todos')
    return data
  },

  async addTodo(content: string): Promise<void> {
    await apiClient.post('/todos', { content })
  },

  async deleteTodo(id: number): Promise<void> {
    await apiClient.delete(`/todos/${id}`)
  }
} 