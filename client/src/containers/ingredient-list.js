import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as actionsIngredients from '../actions';


class IngredientList extends Component {
  componentDidMount(){
    this.props.requestIngredients();
  }


  renderIngredient(){
        return this.props.ingredients.map((ingredient) => {
      return (
        <li
            key={ingredient.name}
            className="list-group-item">
            {ingredient.name}
        </li>
      );
    });
  }

  render(){
    return(
      <div>
       {this.renderIngredient()}
       </div>
     );
  }
}

function mapStateToProps(state){
  return {
    ingredients: state.ingredients.data
  };
}

function mapDispatchToProps(dispatch){
  return bindActionCreators(actionsIngredients, dispatch);
}

export default connect (mapStateToProps, mapDispatchToProps)(IngredientList);
