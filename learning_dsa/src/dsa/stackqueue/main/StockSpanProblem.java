package dsa.stackqueue.main;

import java.util.Stack;

/*
  Brut force :
      have a list, and scan from back for every call and count value till less than current price
 */
public class StockSpanProblem {

    int index;
    Stack<Pair> stack;

    public StockSpanProblem() {
        this.index = -1;
        this.stack = new Stack<>();
    }

    public int getStockSpan(int price) {
        this.index++;
        while (!this.stack.isEmpty() && this.stack.peek().value <= price) {
            this.stack.pop();
        }
        int pge = this.stack.isEmpty() ? -1 : this.stack.peek().index;

        this.stack.push(new Pair(this.index, price));
        return this.index - pge;
    }
}


class Pair {
    int index;
    int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}