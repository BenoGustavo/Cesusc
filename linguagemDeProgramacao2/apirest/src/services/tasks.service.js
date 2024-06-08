const { Task } = require('../model/task.model');

class TasksService {
    getAll() {
        return Task.findAll();
    }

    getById(id) {
        return Task.findByPk(id);
    }

    getTaskByUserIdAndTaskId(userId, taskId) {
        return Task.findOne({
            where: {
                userId: userId,
                id: taskId
            }
        });
    }

    getAllTasksByUserId(userId) {
        return Task.findAll({
            where: {
                userId: userId
            }
        });
    }

    getByDeadlineDate(deadlineDate) {
        return Task.findAll({
            where: {
                deadlineDate: deadlineDate
            }
        });
    }

    create(task) {
        return Task.create(task);
    }

    update(id, task) {
        return Task.update(task, {
            where: {
                id: id
            }
        });
    }

    delete(id) {
        return Task.destroy({
            where: {
                id: id
            }
        })
    }

    restore(id) {
        try {
            return Task.restore({
                where: {
                    id: id
                }
            });
        } catch (e) {
            console.log(e);
        }
    }
}

module.exports = TasksService;