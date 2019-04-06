
package com.parvez_n_jabed_co.waves_of_coxbazar;


class PizzaTopping {

    static final int STATE_OFF = 0;

    static final int STATE_ON = 1;

    static final int STATE_EXTRA = 2;

    final String name;

    int state = STATE_OFF;

    PizzaTopping(final String name) {
        this.name = name;
    }

    void nextState() {
        state++;
        if(state > STATE_EXTRA) {
            state = STATE_OFF;
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
