const {USER_ADDED_ROUTE,USERS_EVENT,ERROR_FETCH_LIVE_USERS_MESSAGE,SERVER_LISTENING_MESSAGE,WEB_SOCKET_MESSAGE,INVALID_API_KEY,API_KEY,QUESTION_STATUS,WEB_SOCKET_PORT,SERVER_PORT,SUCCESS,WEB_SOCKET_LISTENING_MESSAGE} = require("./constants/constants")
const express = require('express');
const app = express();
const {connectDB} = require("./database/db")
const io = require('socket.io')(WEB_SOCKET_PORT)
const {LiveUser} = require("./models/LiveUsers")
const cors = require('cors');
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
app.use(cors());
connectDB();


async function getAllUsers()
{
    let users = await LiveUser.findAll({
        where: {
          status: QUESTION_STATUS
        }
      })
    users = users.map(user=>user.dataValues)
    return users
}
// protected this endpoint using API_KEY
app.post(USER_ADDED_ROUTE,async (req,res,next)=>
{
    const apiKey = req.headers.authorization;
    if(apiKey !== API_KEY)
    {
        console.log(INVALID_API_KEY);
        return res.status(403).json({message:INVALID_API_KEY});
    }
    try
    {
        const users = await getAllUsers()
        io.emit(USERS_EVENT,users)
        return res.status(200).send(SUCCESS);
    }
    catch(e)
    {
        console.log(e)
        return res.status(500).json({message:ERROR_FETCH_LIVE_USERS_MESSAGE});
    }
});

app.listen(SERVER_PORT,()=>
{
    console.log(SERVER_LISTENING_MESSAGE)
    console.log(WEB_SOCKET_LISTENING_MESSAGE)
});

io.on("connection",async (socket)=>
{
    console.log(WEB_SOCKET_MESSAGE);
    const users = await getAllUsers();
    console.log("Fetched Users : ",users);
    console.log("Emitting WElcome EVent : ",users);
    socket.emit("welcome",users);
});