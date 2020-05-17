const mongo = require('mongodb').MongoClient;
saveNewPost = function saveNewPosts(url,post,sendResponse){
    mongo.connect(url, (err, client) => {
        let db = client.db('posts');
        if (err) { console.log(err); }
        db.collection('userpost').insertOne(post,function(err,result){
            console.log("data inserted in sep function");
            db.close();
            sendResponse(result);
        });
      });
}
function queryPosts(url,queryData,sendResponse){
 mongo.connect(url,(err,client)=>{
     if(err){
         console.log(err);
     }
     let db = client.db('posts');
     db.collection('userpost').find(queryData).toArray(function(err, result) {
        if (err) throw err;
        console.log(result);
        client.close();
        sendResponse(result);
      });
    });

}
function queryPost(url,queryData,sendResponse){
    mongo.connect(url,(err,client)=>{
        if(err){
            console.log(err);
        }
        let db = client.db('posts');
        db.collection('userpost').findOne(queryData,(err,result) =>{
            if(err)
                throw err;
            console.log(result);
            client.close();
            sendResponse(result);    
        });
    });
}

module.exports ={
    addPost : saveNewPost,
    queryPosts : queryPosts,
    queryPost :queryPost
};