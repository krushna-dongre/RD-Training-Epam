// Function Cache
// https://www.codewars.com/kata/function-cache

function cache(func) {
    var memory = {};
    return function() {
        var key = JSON.stringify(arguments);
        if (key in memory) return memory[key];
        return memory[key] = func.apply(this, arguments);
    };
}