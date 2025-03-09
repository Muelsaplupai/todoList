from flask import Flask
from flask_cors import CORS
from app.models import db
from app.routes.todo_routes import todo_bp


def create_app(config_object=None):
    app = Flask(__name__)

    # 配置
    app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///todos.db'
    app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

    # 初始化扩展
    CORS(app)
    db.init_app(app)

    # 注册蓝图
    app.register_blueprint(todo_bp)

    # 创建数据库表
    with app.app_context():
        db.create_all()

    return app
