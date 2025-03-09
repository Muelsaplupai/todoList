from flask import Blueprint, request

from app.services.todo_service import TodoService

todo_bp = Blueprint('todos', __name__)
todo_service = TodoService()


@todo_bp.route('/todos', methods=['GET'])
def get_todos():
    return todo_service.get_all_todos()


@todo_bp.route('/todos', methods=['POST'])
def add_todo():
    data = request.get_json()
    return todo_service.create_todo(data)


@todo_bp.route('/todos/<int:id>', methods=['DELETE'])
def delete_todo(id):
    return todo_service.delete_todo(id)
