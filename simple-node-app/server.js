const express = require('express');
const bodyParser = require('body-parser');

// create express app
const app = express();
let port = process.env.PORT || 3017;
// parse requests of content-type - application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: true }))

// parse requests of content-type - application/json
app.use(bodyParser.json())

// define a simple route
app.get('/', (req, res) => {
    res.json({"message": "Simple Node App is working." + port});
});

// New routes from routes.js 

require('./app/routes/routes.js')(app);


// listen for requests
app.listen(port, () => {
    console.log("Server is listening on port ", port);
});