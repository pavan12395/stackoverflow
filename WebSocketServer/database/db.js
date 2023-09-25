require("dotenv").config()
const Sequelize = require("sequelize");
const {database,username,password,host} = require("../constants/constants")
const sequelize = new Sequelize(
 database,
 username,
 password,
  {
    host: host,
    dialect: 'mysql'
  }
);

function connectDB()
{
    sequelize.authenticate().then(() => {
        console.log('Connection has been established successfully.');
     }).catch((error) => {
        console.error('Unable to connect to the database: ', error);
     });
}

module.exports = {connectDB , sequelize};