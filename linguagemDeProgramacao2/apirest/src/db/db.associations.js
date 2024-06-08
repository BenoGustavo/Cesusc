const { User } = require('../model/user.model');
const { Task } = require('../model/task.model');

// Correct the foreignKey to match in case
Task.belongsTo(User, { foreignKey: 'userId', as: 'user' });
User.hasMany(Task, { foreignKey: 'userId', as: 'tasks' });