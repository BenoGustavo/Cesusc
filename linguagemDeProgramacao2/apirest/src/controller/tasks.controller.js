const TasksService = require('../services/tasks.service')

class TasksController {
    constructor() {
        this.tasksService = new TasksService();
    }

    getTaskByUserIdAndTaskId = async (ctx) => {
        const taskId = ctx.params.taskId;
        const userId = ctx.params.userId;

        console.log("taskid" + taskId + "userId" + userId)
        const task = await this.tasksService.getTaskByUserIdAndTaskId(userId, taskId);
        ctx.status = task ? 200 : 404;
        ctx.body = task || { error: 'Task not found' };
    }

    getAllTasksByUserId = async (ctx) => {
        const userId = ctx.params.userId;
        const tasks = await this.tasksService.getAllTasksByUserId(userId);
        ctx.status = tasks.length ? 200 : 204;
        ctx.body = tasks.length ? tasks : { message: 'No tasks found' };
    }

    getAll = async (ctx) => {
        const tasks = await this.tasksService.getAll();
        ctx.status = tasks.length ? 200 : 204;
        ctx.body = tasks;
    }

    getById = async (ctx) => {
        const id = ctx.params.id;
        const task = await this.tasksService.getById(id);
        ctx.status = task ? 200 : 404;
        ctx.body = task || { error: 'Task not found' };
    }

    getByDeadlineDate = async (ctx) => {
        const date = ctx.params.date;
        const tasks = await this.tasksService.getByDeadlineDate(date);
        ctx.status = tasks.length ? 200 : 204;
        ctx.body = tasks;
    }

    create = async (ctx) => {
        const newTask = ctx.request.body;
        const createdTask = await this.tasksService.create(newTask);
        ctx.status = createdTask ? 201 : 400;
        ctx.body = createdTask || { error: 'Task creation failed' };
    }

    update = async (ctx) => {
        const id = ctx.params.id;
        const task = ctx.request.body;
        const updatedTask = await this.tasksService.update(id, task);
        ctx.status = updatedTask ? 200 : 404;
        ctx.body = updatedTask || { error: 'Task update failed' };
    }

    delete = async (ctx) => {
        const id = ctx.params.id;
        const deleted = await this.tasksService.delete(id);
        ctx.status = deleted ? 204 : 404;
        if (!deleted) ctx.body = { error: 'Task deletion failed' };
    }

    restore = (ctx) => {
        try {
            const id = ctx.params.id;

            this.tasksService.restore(id);

            ctx.status = 200
        } catch (e) {
            ctx.status = 500
            ctx.body = { error: 'Task restore failed' };
        }
    }
}

module.exports = TasksController