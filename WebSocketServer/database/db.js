require("dotenv").config()
const Sequelize = require("sequelize");
const {database,username,password,host,port} = require("../constants/constants")
console.log("Reading Inside Sequelize");
console.log("Database : "+database);
console.log("Username : "+username);
console.log("Password : "+password);
console.log("host : "+host);
console.log("port : "+port);
console.log("Reading Inside Sequelize");

const sequelize = new Sequelize({
    host: host,
    port: port,
    database: database,
    username: username,
    password: password,
    models: [path.join(__dirname, '../models')],
    dialect: "mysql",
});

function connectDB()
{
    sequelize.authenticate().then(() => {
        console.log('Connection has been established successfully.');
     }).catch((error) => {
        console.error('Unable to connect to the database: ', error);
     });
}

module.exports = {connectDB , sequelize};