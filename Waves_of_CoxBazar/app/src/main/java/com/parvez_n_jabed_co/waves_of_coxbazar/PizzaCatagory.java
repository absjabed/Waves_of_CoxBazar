
package com.parvez_n_jabed_co.waves_of_coxbazar;

class PizzaCatagory {

    final String name;

    final PizzaTopping[] toppings;

    public PizzaCatagory(
            final String name,
            final PizzaTopping... toppings) {
        
        this.name = name;
        this.toppings = toppings;
    }

}
