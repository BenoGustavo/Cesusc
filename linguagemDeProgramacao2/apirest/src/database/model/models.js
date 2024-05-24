const { Sequelize, DataTypes } = require('sequelize');
const sequelize = new Sequelize('postgres://postgres:postgres@localhost:5432/tasks_databases');

const Task = sequelize.define(
    'Task', {
    id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
    description: { type: DataTypes.STRING, allowNull: false },
    createdAt: { type: DataTypes.DATE, allowNull: false },
    updatedAt: { type: DataTypes.DATE, allowNull: false },
    completed: { type: DataTypes.BOOLEAN, allowNull: false },
    completedAt: { type: DataTypes.DATE, allowNull: true }
}
);

sequelize.sync({ force: true });