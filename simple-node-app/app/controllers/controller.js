var fs = require('fs');
function getCount() {
    // Check to see if the counter has been initialized
    if (typeof count == 'undefined') {
        // It has not... perform the initialization
        count = 0;
    } else count++;

    return count;
}
function getCount1() {
    // Check to see if the counter has been initialized
    if (typeof count1 == 'undefined') {
        // It has not... perform the initialization
        count1 = 0;
    } else count1++;

    return count1;
}
// Call a simple API
exports.simple = (req, res) => {
    console.log('simple api called!');
    res.json({ "message": "Simple API is working." });
};

// Call API with IO operations
exports.iooperation = (req, res) => {
    const count = getCount1();
    console.time(`io-${count}`);
    // Read text file Asynchronously
    fs.readFile('data/text.txt', 'utf8', function (err, contents) {
        console.timeEnd(`io-${count}`);
        res.json({ "message": "IO operations API is working." });
    });
};

// Call API with CPU operations
exports.cpuoperation = (req, res) => {
    const count = getCount();
    console.time(`cpu-${count}`);
    // console.log(count, ' started at ', now);
    for (let i = 0; i < 10000; i++)
        for (let j = 0; j < 10000; j++);    
    console.timeEnd(`cpu-${count}`)
    res.json({ "message": "CPU operations API is working." });
};
