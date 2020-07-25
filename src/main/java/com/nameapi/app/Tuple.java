package com.nameapi.app;

/** 
 * aceasta clasa este inca o clasa Helper, ce am creat-o
 * pentru a crea o structura de tipul Tuple (mult zis :)) )\
 * Nici aceasta clasa nu poate fi mostenita.
 */

final public class Tuple<X, Y> { 
    private X x; 
    private Y y; 
    public Tuple(X x, Y y) { 
      this.x = x; 
      this.y = y; 
    } 

    public Tuple(Tuple newTuple) {
        this((X) newTuple.getX(),(Y) newTuple.getY());
    }

    public void setX(X newX) {
        this.x = newX;
    }

    public void setY(Y newY) {
        this.y = newY;
    }

    public X getX() {
        return this.x;
    }

    public Y getY() {
        return this.y;
    }

  } 