const { DataTypes } = require('sequelize');
const sequelize = require('../db/db.config')

const Task = sequelize.define(
    'Task',
    {
        id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
        description: { type: DataTypes.STRING, allowNull: false },
        completed: { type: DataTypes.BOOLEAN, allowNull: false, defaultValue: false },
        completedAt: { type: DataTypes.DATE, allowNull: true, defaultValue: DataTypes.NULL },
        deadlineDate: { type: DataTypes.DATE, allowNull: true, defaultValue: DataTypes.NOW }
    },
    {
        tableName: 'tasks',
        timestamps: true,
        paranoid: true,
    }
);

sequelize.sync(syncOptions = { force: true })

module.exports = { Task }