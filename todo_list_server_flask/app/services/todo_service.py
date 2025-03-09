from flask import jsonify
from app.models import db
from app.models.todo import Todo


class TodoService:
    @staticmethod
    def get_all_todos():
        todos = TodoService._get_all()
        return jsonify([{'id': t.id, 'content': t.content} for t in todos])

    @staticmethod
    def create_todo(data):
        todo = TodoService._create(data['content'])
        return jsonify({'id': todo.id}), 201

    @staticmethod
    def delete_todo(id):
        todo = TodoService._get_by_id(id)
        if todo:
            TodoService._delete(todo)
            return '', 204
        return jsonify({'error': 'Todo not found'}), 404

    # 私有数据访问方法
    # 当项目规模变大、业务逻辑变复杂时, 需要将这部分代码从service层中分离出来, 放入数据库访问层中
    @staticmethod
    def _get_all():
        return Todo.query.all()

    @staticmethod
    def _create(content):
        todo = Todo(content=content)
        db.session.add(todo)
        db.session.commit()
        return todo

    @staticmethod
    def _get_by_id(id):
        return Todo.query.get(id)

    @staticmethod
    def _delete(todo):
        db.session.delete(todo)
        db.session.commit()
