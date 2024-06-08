const { DataTypes } = require('sequelize');
const sequelize = require('../db/db.config')

const User = sequelize.define(
    'User',
    {
        id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
        firstName: { type: DataTypes.STRING, allowNull: false },
        lastName: { type: DataTypes.STRING, allowNull: false },
        email: { type: DataTypes.STRING, allowNull: false },
        password: { type: DataTypes.STRING, allowNull: false },
    },
    {
        tableName: 'users',
        timestamps: true,
        paranoid: true,
    }
);

sequelize.sync()

module.exports = { User }