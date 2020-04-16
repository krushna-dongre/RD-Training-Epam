// Array Helpers
// http://www.codewars.com/kata/array-helpers

if(Array.prototype.square){
    Array.prototype.square = function() {
        return this.map(function(x) {
            return (x * x);
        });
    }
}
if(Array.prototype.cube){
    Array.prototype.cube = function() {
        return this.map(function(x) {
            return (x * x * x);
        });
    }
}
if(Array.prototype.sum){
    Array.prototype.sum = function() {
        return this.reduce(function(s, v) {
            return s + v;
        }, 0);
    }
}
if(Array.prototype.average){
    Array.prototype.average = function() {
        return this.reduce(function(s, v) {
            return (s + v);
        }, 0) / this.length;
    }
}
if(Array.prototype.even){
    Array.prototype.even = function() {
        return this.filter(function(x) {
            return x % 2 === 0;
        });
    }
}
if(Array.prototype.odd){
    Array.prototype.odd = function() {
        return this.filter(function(x) {
            return x % 2 !== 0;
        });
    }
}