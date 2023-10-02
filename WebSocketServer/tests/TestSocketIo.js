const {io} = require("socket.io-client")

const socket = io("ws://localhost:4000")

socket.on("users",(users)=>
{
    console.log("Recieved Users : ",users)
});

socket.on("welcome",(data)=>
{
    console.log(data);
})