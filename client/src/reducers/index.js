import { combineReducers } from 'redux';
import PizzasReducer from './reducer_pizzas';
import ActivePizza from './reducer_active_pizza';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import IngredientsReducer from './reducer_ingredients';
// import IngredientsPizzaReducer from './reducer_ingredients_pizza';


const rootReducer = combineReducers({
  pizzas: PizzasReducer,
  ingredients: IngredientsReducer,
  // ingredientsPizza: IngredientsPizzaReducer,
  activePizza: ActivePizza
});

export default rootReducer;
