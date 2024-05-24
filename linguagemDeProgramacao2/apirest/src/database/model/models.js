const { Sequelize, DataTypes } = require('sequelize');
const sequelize = new Sequelize('postgres://postgres:postgres@postgres:5432/tasks_database');

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