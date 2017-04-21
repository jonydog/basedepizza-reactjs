import { RECEIVE_PIZZAS } from '../actions/index';
import {FETCHING_PIZZAS} from '../actions/index';

const initialState = {
  data: [],
  pagination: {},
  fetching: false
}

export default function(state = initialState, action){
    switch(action.type){
      case RECEIVE_PIZZAS:
        return {...state, data: action.payload.data};

      case FETCHING_PIZZAS:
        return {...state, fetching: action.payload.fetching};

    }
    return state;
}

/*
{
  ingredients: {
    data: {
      12312: {...},
      ....
    }

  }
}

{
  pizza: {...},
  pizza_ingredients: {
    data: {
      pizzaId: {}
    }
  }
}

case RECEIVE_INGREDIENTS:
  return {...state
     data: {
    ...state.data,
    [action.payload.pizzaId]: action.payload.data
  }};
  */
