var reporter = require('cucumber-html-reporter');

var options = {
    theme: 'bootstrap',
    jsonFile: 'integration-test/reports/cucumber_report.json',
    output: 'integration-test/reports/cucumber_report.html',
    reportSuiteAsScenarios: true,
    scenarioTimestamp: true,
    launchReport: false,
    metadata: {
        "Test Environment": process.env.AWS_PROFILE,
    }
};
reporter.generate(options);
