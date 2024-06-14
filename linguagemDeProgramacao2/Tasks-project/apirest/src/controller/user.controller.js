const UserService = require('../services/user.service')
const TasksController = require('../controller/tasks.controller')
const bcrypt = require('bcryptjs')

class UserController {
    constructor() {
        this.userController = new UserService();
        this.tasksController = new TasksController();
    }

    getTask = async (ctx) => {
        console.log("called getTask")
        return await this.tasksController.getTaskByUserIdAndTaskId(ctx);
    }

    getAllTasks = async (ctx) => {
        return await this.tasksController.getAllTasksByUserId(ctx);
    }

    getAll = async (ctx) => {
        const users = await this.userController.getAll();
        ctx.status = users.length ? 200 : 204;
        ctx.body = users;
    }

    getById = async (ctx) => {
        const id = ctx.params.id;
        const user = await this.userController.getById(id);
        ctx.status = user ? 200 : 404;
        ctx.body = user || { error: 'User not found' };
    }

    create = async (ctx) => {
        const password = ctx.request.body.password

        if (!password) {
            ctx.status = 400
            ctx.body = { error: 'Password is required' }
            return
        }

        bcrypt.genSalt(Number(process.env.HASH_ROUND), (err, salt) => {
            bcrypt.hash(password, salt, async (err, hash) => {
                if (err) {
                    ctx.status = 400
                    ctx.body = { error: 'Password hashing failed' }
                    return
                }

                ctx.request.body.password = hash;
                const user = await this.userController.create(ctx.request.body);

                ctx.status = user ? 201 : 400;

                return
            })

            if (err) {
                ctx.status = 400
                ctx.body = { error: 'Password hashing failed' }
                return
            }
        })
    }

    update = async (ctx) => {
        const id = ctx.params.id;
        const user = ctx.request.body;
        const updatedUser = await this.userController.update(id, user);
        ctx.status = updatedUser ? 200 : 404;
        ctx.body = updatedUser || { error: 'User update failed' };
    }

    delete = async (ctx) => {
        const id = ctx.params.id;
        const deleted = await this.userController.delete(id);

        ctx.status = deleted ? 204 : 404;

        if (!deleted) ctx.body = { error: 'User deletion failed' };
    }

    restore = (ctx) => {
        try {
            const id = ctx.params.id;

            this.userController.restore(id);

            ctx.status = 200
        } catch (e) {
            ctx.status = 500
            ctx.body = { error: 'User restore failed' };
        }
    }
}

module.exports = UserController