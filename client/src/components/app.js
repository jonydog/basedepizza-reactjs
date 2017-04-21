import React, { Component } from 'react';

import PizzaList from '../containers/pizza-list';
import PizzaDetail from '../containers/pizza-detail';
import IngredientList from '../containers/ingredient-list';

export default class App extends Component {
  render() {
    return (
      <div>
        <PizzaList />
        <PizzaDetail />
        <IngredientList />
      </div>
    );
  }
}
