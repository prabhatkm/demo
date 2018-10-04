module.exports = (app) => {
    const controller = require('../controllers/controller.js');

    // Call a simple API
    app.get('/simple', controller.simple);

    // Call API with IO operations
    app.get('/ioop', controller.iooperation);

    // Call API with CPU operations
    app.get('/cpuop', controller.cpuoperation);
}
