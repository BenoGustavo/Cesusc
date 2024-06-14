const { User } = require("../model/user.model")
const { Task } = require("../model/task.model")

class UserService {
    getTask(id) {
        return User.findByPk(id, {
            include: [{
                model: Task,
                as: 'tasks'
            }]
        })
    }

    getAllTasks() {
        return User.findAll({
            include: [{
                model: Task,
                as: 'tasks'
            }]
        })
    }

    getAll() {
        return User.findAll({
            attributes: { exclude: ['password'] }
        })
    }

    getById(id) {
        return User.findByPk(id, {
            attributes: { exclude: ['password'] }
        })
    }

    create(user) {
        return User.create(user)
    }

    update(id, user) {
        return User.update(user, {
            where: {
                id: id
            }
        })
    }

    delete(id) {
        return User.destroy({
            where: {
                id: id
            }
        })
    }

    restore(id) {
        try {
            return User.restore({
                where: {
                    id: id
                }
            })
        } catch (e) {
            console.log(e)
        }
    }
}

module.exports = UserService