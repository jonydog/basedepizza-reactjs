import axios from 'axios';

const URL_PIZZAS = 'http://localhost:8080/pizzas/all';
const URL_INGREDIENTS = 'http://localhost:8080/ingredient/all';
// const URL_BASE_ING_PIZZA = 'http://localhost:8080/ingredient/';

export const RECEIVE_PIZZAS = 'RECEIVE_PIZZAS';
export const FETCHING_PIZZAS = 'PIZZAS_FETCHING';

export const SELECT_PIZZA = 'PIZZA_SELECTED';

export const RECEIVE_INGREDIENTS = 'RECEIVE_INGREDIENTS';
export const FETCHING_INGREDIENTS = 'INGREDIENTS_FETCHING';

// export const FETCHING_PIZZA_INGREDIENTS = 'FETCHING_PIZZA_INGREDIENTS';
// export const RECEIVE_PIZZA_INGREDIENTS = 'RECEIVE_PIZZA_INGREDIENTS';


export function requestPizza(){
  return dispatch => {
    dispatch({type: FETCHING_PIZZAS, payload: {fetching:true}});

    const url = URL_PIZZAS;

    const request = axios.get(url);
    request
      .then(response => response.data)
      .then( receivePizza(dispatch) )
  }
}

// HOF
function receivePizza(dispatch) {
  return data => {
    dispatch({type: FETCHING_PIZZAS, payload: {fetching:false}});
    dispatch({
      type: RECEIVE_PIZZAS,
      payload: {
        data
      }
    });
    data.map(pizza => requestIngredientsPizza(pizza));
  }
}

/* function kkreceivePizza(data) {
  return {
      type: RECEIVE_PIZZAS,
      payload: {
        data
      }
  }
}*/

export function selectPizza(pizza){
 console.log('A pizza has been selected: ', pizza.name);
  return{
    type: SELECT_PIZZA,
    payload: pizza
  };
}

export function requestIngredients(){
  return dispatch => {
    dispatch({type: FETCHING_INGREDIENTS, payload: {fetching:true}});

    const url = URL_INGREDIENTS;

    const request = axios.get(url);
    request
      .then(response => response.data)
      .then( receiveIngredients(dispatch) )
  }
}

function receiveIngredients(dispatch) {
  return data => {
    dispatch({type: FETCHING_INGREDIENTS, payload: {fetching:false}});
    dispatch({
      type: RECEIVE_INGREDIENTS,
      payload: {
        data
      }
    });
  }
}

// export function requestIngredientPizza(pizza){
//   return dispatch => {
//     dispatch({type: FETCHING_PIZZA_INGREDIENTS, payload: {fetch:true}});
//
//     const url = URL_BASE_ING_PIZZA + pizza.id;
//
//     const request = axios.get(url);
//     request
//       .then(response => response.data)
//       .then( receiveIngredients(dispatch, pizza) )
//   }
// }
//
// // HOF
// function receiveIngredientsPizza(dispatch, pizza) {
//   return data => {
//     dispatch({type: FETCHING_PIZZA_INGREDIENTS, payload: {fetching:false}});
//     dispatch({
//       type: RECEIVE_PIZZA_INGREDIENTS,
//       payload: {
//         pizzaId: pizza.id,
//         data
//       }
//     });
//
//     data.map(pizza => requestIngredientsPizza(pizza));
//   }
// }
