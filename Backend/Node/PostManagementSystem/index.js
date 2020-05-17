const express = require('express');

const app = express();
const dbCalls = require('./databasecallbacks');
const url = 'mongodb://localhost:27017/';
app.use(express.json());

app.post('/savePost',function(req,res){
    console.log("inside request");
    let item = {
        postedby:req.body.postedname,
        content:req.body.content,
        postedtime:req.body.time
    };
    dbCalls.addPost(url,item,(result)=>{
        return res.send("The given post is insterted");
    });
   console.log("dave postnpm star"+req.body.hello); 
  
});

app.get('/getPosts',function(req,res){
    console.log('getting posts for user');
    let userId=req.query.user;
    let sortType=req.params.sortType;
    let numberOfPostsLimit= req.params.limit;
    let data = {
        postedby:userId
    };
    dbCalls.queryPosts(url,data,(result)=>{
        return res.send(result);
    });
   
})
app.listen(3000);