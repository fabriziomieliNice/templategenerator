'use strict';
const {When, Given} = require('@cucumber/cucumber');
const {setDefaultTimeout} = require('@cucumber/cucumber');
setDefaultTimeout(60 * 1000);

Given('event created',  () => {
    console.log('event created');
});

When('local lambda invoked', () => {
    console.log('local lambda invoked');
    //TODO: insert SAM local invoke
});
