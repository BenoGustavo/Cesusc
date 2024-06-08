const { DataTypes } = require('sequelize');
const sequelize = require('../db/db.config')

const Task = sequelize.define(
    'Task',
    {
        id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
        description: { type: DataTypes.STRING, allowNull: false },
        completed: { type: DataTypes.BOOLEAN, allowNull: false, defaultValue: false },
        completedAt: { type: DataTypes.DATE, allowNull: true, defaultValue: DataTypes.NULL },
        deadlineDate: { type: DataTypes.DATE, allowNull: true, defaultValue: DataTypes.NOW },
        userId: {
            type: DataTypes.INTEGER,
            allowNull: false,
            references: {
                model: 'users',
                key: 'id'
            },
            validate: {
                notNull: {
                    msg: 'userId is required'
                }
            }
        }
    },
    {
        tableName: 'tasks',
        timestamps: true,
        paranoid: true,
    }
);

sequelize.sync()

module.exports = { Task }