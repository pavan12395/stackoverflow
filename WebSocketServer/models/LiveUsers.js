const { DataTypes } = require("sequelize")
const {sequelize} = require("../database/db")

const LiveUser = sequelize.define("live_users",
{
    id:{
        type: DataTypes.NUMBER,
        allowNull: false,
        primaryKey: true
    },
    status:{
        type: DataTypes.INTEGER,
        allowNull: false
    },
    webrtc_secret:{
        type: DataTypes.STRING,
        allowNull: true
    },
    question_details: {
        type: DataTypes.STRING,
        allowNull : false
    }
},
{
    timestamps: false // Disable createdAt and updatedAt columns
})

module.exports = {LiveUser};