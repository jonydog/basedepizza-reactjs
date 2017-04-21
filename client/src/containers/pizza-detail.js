import React, { Component } from 'react';
import { connect } from 'react-redux';

class PizzaDetail extends Component {


  render(){
    if(!this.props.pizza){
      return <div>Select a pizza to get started.</div>;
    }
    return(
      <div>
        <div>
          <h3> Details of Pizza: </h3>
        </div>
        <div>
          <h5> Pizza name: {this.props.pizza.name}</h5>
        </div>
        <div>
          <h5> Pizza description: {this.props.pizza.description}</h5>
        </div>
        <div>
          <h5> Pizza price: {this.props.pizza.priceInEuros}</h5>
        </div>
      </div>
    );
  }
}

function mapStateToProps(state){
  return{
    pizza: state.activePizza
    // ingredientsPizza: state.ingredientsPizza.data;
  };
}

// function mapDispatchToProps(dispatch){
//   return bindActionCreators(actionsIngredients, dispatch);
// }

export default connect (mapStateToProps)(PizzaDetail);
