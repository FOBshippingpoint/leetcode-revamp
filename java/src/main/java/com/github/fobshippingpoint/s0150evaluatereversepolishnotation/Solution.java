package com.github.fobshippingpoint.s0150evaluatereversepolishnotation;

import java.util.ArrayDeque;
import java.util.Stack;

public class Solution {

    public int evalRPNV1(String[] tokens) {
        var stack = new Stack<Integer>();

        for (var token : tokens) {
            switch (token) {
                case "+", "-", "*", "/":
                    var right = stack.pop();
                    var left = stack.peek();
                    var last = stack.size() - 1;
                    switch (token) {
                        case "+":
                            stack.set(last, left + right);
                            break;
                        case "-":
                            stack.set(last, left - right);
                            break;
                        case "*":
                            stack.set(last, left * right);
                            break;
                        case "/":
                            stack.set(last, left / right);
                            break;
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.peek();
    }

    /**
     * Today I learned {@code Stack} is not preferred.
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Stack.html">Stack (Java SE 21 & JDK 21)</a>
     */
    public int evalRPNV2(String[] tokens) {
        var stack = new Stack<Integer>();

        int a, b, last;
        for (var token : tokens) {
            switch (token) {
                case "+":
                    b = stack.pop();
                    a = stack.peek();
                    last = stack.size() - 1;
                    stack.set(last, a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.peek();
                    last = stack.size() - 1;
                    stack.set(last, a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.peek();
                    last = stack.size() - 1;
                    stack.set(last, a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.peek();
                    last = stack.size() - 1;
                    stack.set(last, a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.peek();
    }

    public int evalRPNV3(String[] tokens) {
        var deque = new ArrayDeque<Integer>(tokens.length / 2 + 1);

        int a, b;
        for (var token : tokens) {
            switch (token) {
                case "+":
                    b = deque.pop();
                    a = deque.pop();
                    deque.push(a + b);
                    break;
                case "-":
                    b = deque.pop();
                    a = deque.pop();
                    deque.push(a - b);
                    break;
                case "*":
                    b = deque.pop();
                    a = deque.pop();
                    deque.push(a * b);
                    break;
                case "/":
                    b = deque.pop();
                    a = deque.pop();
                    deque.push(a / b);
                    break;
                default:
                    deque.push(Integer.parseInt(token));
                    break;
            }
        }

        return deque.peek();
    }

    public int evalRPNV4(String[] tokens) {
        var stack = new int[tokens.length / 2 + 1];
        var head = 0; // aka size

        for (var token : tokens) {
            switch (token) {
                case "+" -> {
                    stack[head - 2] += stack[head - 1];
                    head--;
                }
                case "-" -> {
                    stack[head - 2] -= stack[head - 1];
                    head--;
                }
                case "*" -> {
                    stack[head - 2] *= stack[head - 1];
                    head--;
                }
                case "/" -> {
                    stack[head - 2] /= stack[head - 1];
                    head--;
                }
                default -> {
                    stack[head] = Integer.parseInt(token);
                    head++;
                }
            }
        }
        return stack[0];
    }
}
