let food = {foodName : "피자"};
function getFoodName(food) {
    return food.foodName;
}

console.log(getFoodName(food));

food  =  null;

console.log(getFoodName(food));

function getFoodName(food) {
    if(!food) return "아무거나";
    return food.foodName;
}

function getFoodName(food) {
    return food && food.foodName;
}

console.log(true && 'hello');
console.log(false && 'hello');

