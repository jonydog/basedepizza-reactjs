import { SELECT_PIZZA } from '../actions/index';

export default function(state = null, action){
    switch(action.type){
      case SELECT_PIZZA:
        return action.payload;
    }
    return state;
}
