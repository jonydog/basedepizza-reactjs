import { RECEIVE_INGREDIENTS } from '../actions/index';
import {FETCHING_INGREDIENTS} from '../actions/index';

const initialState = {
  data: [],
  pagination: {},
  fetching: false
}

export default function(state = initialState, action){
  console.log(state);
    switch(action.type){
      case RECEIVE_INGREDIENTS:
        return {...state, data: action.payload.data};

      case FETCHING_INGREDIENTS:
        return {...state, fetching: action.payload.fetching};

    }
    return state;
}
