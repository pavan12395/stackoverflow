require("dotenv").config()
const SERVER_PORT = process.env.SERVER_PORT || 5000
const WEB_SOCKET_PORT = process.env.WEB_SOCKET_PORT || 4000
const USER_ADDED_ROUTE = "/userAdded"
const USERS_EVENT = "users"
const ERROR_FETCH_LIVE_USERS_MESSAGE = "Error fetching Live Users from the Database"
const SERVER_LISTENING_MESSAGE = "Server listening at Port : "+SERVER_PORT
const WEB_SOCKET_MESSAGE = "Connected Opened for Socket.io";
const INVALID_API_KEY = "Invalid API key"
const API_KEY = process.env.API_KEY
const database = process.env.DATABASE
const username = process.env.DB_USERNAME
const password = process.env.DB_PASSWORD
const host = process.env.DB_HOST
const QUESTION_STATUS = process.env.QUESTION_STATUS || 2
const SUCCESS = "Success";
module.exports = {USER_ADDED_ROUTE,USERS_EVENT,ERROR_FETCH_LIVE_USERS_MESSAGE,SERVER_LISTENING_MESSAGE,WEB_SOCKET_MESSAGE,INVALID_API_KEY,API_KEY,database,username,password,host,WEB_SOCKET_PORT,SERVER_PORT,QUESTION_STATUS,SUCCESS}