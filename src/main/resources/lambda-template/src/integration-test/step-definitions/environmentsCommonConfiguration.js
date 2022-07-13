'use strict';
if(process.env.IT_PROFILE !== 'local'){
    process.env.AWS_SDK_LOAD_CONFIG = true;
}

const envConfig = {
    env: process.env.AWS_PROFILE || 'dev'
};

module.exports = envConfig;
