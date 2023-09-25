const express = require('express');
const app = express();
const {connectDB} = require("./database/db")
const io = require('socket.io')(4000)
const {LiveUser} = require("./models/LiveUsers")
const {USER_ADDED_ROUTE,USERS_EVENT,ERROR_FETCH_LIVE_USERS_MESSAGE,SERVER_LISTENING_MESSAGE,WEB_SOCKET_MESSAGE,INVALID_API_KEY,API_KEY} = require("./constants/constants")
// necessary middlewares
app.use(function(req, res, next) {
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type,authorization');
    res.setHeader('Access-Control-Allow-Credentials', true);
    next();
});
app.use(express.urlencoded({extended:true}));
app.use(express.json());
connectDB();


async function getAllUsers()
{
    let users = await LiveUser.findAll({status:2})
    users = users.map(user=>user.dataValues)
    return users
}
// protected this endpoint using API_KEY
app.post(USER_ADDED_ROUTE,async (req,res,next)=>
{
    const apiKey = req.headers.authorization;
    if(apiKey !== API_KEY)
    {
        return res.status(403).json({message:INVALID_API_KEY});
    }
    try
    {
        const users = await getAllUsers()
        io.emit(USERS_EVENT,users)
        return res.status(200).send("Success");
    }
    catch(e)
    {
        return res.status(500).json({message:ERROR_FETCH_LIVE_USERS_MESSAGE});
    }
});

app.listen(5000,()=>
{
    console.log(SERVER_LISTENING_MESSAGE)
});

io.on("connection",(socket)=>
{
    console.log(WEB_SOCKET_MESSAGE);
});