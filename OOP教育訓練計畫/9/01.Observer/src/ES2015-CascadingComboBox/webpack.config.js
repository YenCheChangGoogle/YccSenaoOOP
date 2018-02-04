var path = require('path');
module.exports = {
    entry: {
        'v1': "./01.Observer/src/ES2015-CascadingComboBox/src/v1/Test.js",
        'v2': "./01.Observer/src/ES2015-CascadingComboBox/src/v2/Test.js",
        'v3': "./01.Observer/src/ES2015-CascadingComboBox/src/v3/Test.js",
        'v4': "./01.Observer/src/ES2015-CascadingComboBox/src/v4/Test.js"
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