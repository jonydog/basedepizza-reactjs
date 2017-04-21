import React, { Component } from 'react';
import { connect } from 'react-redux';
import { selectPizza } from '../actions';
import { bindActionCreators } from 'redux';
import * as actionsPizza from '../actions';


class PizzaList extends Component {
  componentDidMount(){
    this.props.requestPizza();
  }


  renderPizza(){
    return this.props.pizzas.map((pizza) => {
      return (
        <li
            key={pizza.name}
            onClick={() => this.props.selectPizza(pizza)}
            className="list-group-item">
            {pizza.name}

        </li>
      );
    });
  }

  render(){
    return(
      <div>
       {this.renderPizza()}
       </div>
     );
  }
}

function mapStateToProps(state){
  return {
    pizzas: state.pizzas.data

  };
}

function mapDispatchToProps(dispatch){
  return bindActionCreators(actionsPizza, dispatch);
}

export default connect (mapStateToProps, mapDispatchToProps)(PizzaList);
