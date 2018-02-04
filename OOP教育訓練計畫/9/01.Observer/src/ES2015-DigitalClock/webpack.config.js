var path = require('path');
module.exports = {
    entry: {
        'v1': "./01.Observer/src/ES2015-DigitalClock/src/v1/Test.js"
    },
    output: {
        path: path.resolve(__dirname, './tests'),
        filename: "[name]/[name].bundle.js"
    },
    module: {
        loaders: [
            {
                test: path.join(__dirname, 'es6'),
                loader: 'babel-loader',
                query: {
                    presets: ['env']
                }
            }
        ]
    }
};