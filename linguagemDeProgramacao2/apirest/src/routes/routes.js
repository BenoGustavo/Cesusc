const Router = require('koa-router')
const TasksController = require('../controller/tasks.controller')

const router = new Router();
const controller = new TasksController();

router.get('/tasks', controller.getAll);
router.get('/tasks/:id', controller.getById);
router.get('/tasks/deadline/:date', controller.getByDeadlineDate);
router.post('/tasks', controller.create);
router.put('/tasks/:id', controller.update);
router.delete('/tasks/:id', controller.delete);
router.post('/tasks/restore/:id', controller.restore);

module.exports = router;