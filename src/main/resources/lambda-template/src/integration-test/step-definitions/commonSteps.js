'use strict';
const {When, Given} = require('@cucumber/cucumber');
const {setDefaultTimeout} = require('@cucumber/cucumber');
const child_process = require('node:child_process');
setDefaultTimeout(60 * 1000);

Given('event created', () => {
    console.log('event created');
});

When('local lambda invoked', async () => {
    console.log('local lambda invoked');
    await run_script('sam local invoke');
    console.log("Process Finished.");
});

function run_script(command) {

    return new Promise((resolve, reject) => {
        console.log("Starting Process.");
        child_process.exec(command, (error, stdout, stderr) => {
            if (error) {
                console.log(`error: ${error.message}`);
                reject(error);
            }
            if (stderr) {
                console.log(`${stderr}`);
            }
            resolve(stdout);
        });
    });


}
