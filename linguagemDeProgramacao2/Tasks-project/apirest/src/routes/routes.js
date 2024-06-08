const Router = require('koa-router')
const TasksController = require('../controller/tasks.controller')
const UserController = require('../controller/user.controller')

const router = new Router();
const controller_task = new TasksController();
const controller_user = new UserController();

router.get('/tasks', controller_task.getAll);
router.get('/tasks/:id', controller_task.getById);
router.get('/tasks/deadline/:date', controller_task.getByDeadlineDate);
router.post('/tasks', controller_task.create);
router.put('/tasks/:id', controller_task.update);
router.delete('/tasks/:id', controller_task.delete);
router.post('/tasks/restore/:id', controller_task.restore);

router.get('/users', controller_user.getAll);
router.get('/users/tasks/:userId', controller_user.getAllTasks);
router.get('/users/task/:taskId/:userId', controller_user.getTask);
router.get('/users/:id', controller_user.getById);
router.post('/users', controller_user.create);
router.put('/users/:id', controller_user.update);
router.delete('/users/:id', controller_user.delete);
router.post('/users/restore/:id', controller_user.restore);

module.exports = router;