'use strict';
const mainModule = require('../app/app');
const myHandler = mainModule.handler;

let env, region;

function setEnvParams() {
    env = process.env.AWS_PROFILE || 'dev';
    region = 'us-west-2';
}

function createEnvMocks() {
    process.env.AWS_PROFILE =  env;
}

const event = { };

setEnvParams();
createEnvMocks();


function callback(err, data) {
    if (err) {
        console.log('error:', err);
    }
    if (data) {
        console.log('policy result:', JSON.stringify(data));
    }
}

myHandler(event, null, callback);