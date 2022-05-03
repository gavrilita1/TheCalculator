package com.example.TheCalculator;

import java.util.ArrayList;
import java.util.Stack;

public class Algoritm {

    public static double generateSolution(final String input) {
        System.out.println(input +"=");
        return new Object() {
            int position = -1;
            int ch;
            int toAdd=0;
            int toDim=0;
            String equation =input;
            int curentPosition;
            ArrayList<Double> numbers = new ArrayList<>();

            void nextChar() {
                if (++position < equation.length())
                    ch = equation.charAt(position);
                else
                    ch = -1;
            }

            boolean findChar(int charToFind) {
                if (ch == charToFind) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double run() {
                nextChar();
                double x = additionSubtraction();
                return x;
            }

            void step(Integer startPosition, double x, Integer sizeNumber, Integer sizeSecondNumber){
                toAdd=0;
                toDim=0;
                if(equation.charAt(startPosition-sizeNumber-2)=='(' && equation.charAt(startPosition +sizeSecondNumber)==')'){toDim=1; toAdd=1;}

                String toReplace= equation.substring((startPosition-sizeNumber-1-toDim), (startPosition +sizeSecondNumber+ toAdd));
                equation = equation.replace(toReplace,String.valueOf(x));

                this.position= startPosition;
                System.out.println(equation+"=");
            }

            double additionSubtraction() {
                double x = multiplicationDivision();
                while(true) {
                    if (findChar('+')) {

                        Integer sizeOfNumber = String.valueOf(x).length();
                        double term = multiplicationDivision();
                        x = x + term;
                        Integer sizeOfSecondNumber = String.valueOf(term).length();
                        step(curentPosition,x,sizeOfNumber,sizeOfSecondNumber);
                    }
                    else if (findChar('-')){
                        x = x - multiplicationDivision();
                    }
                    else return x;
                }
            }

            double multiplicationDivision() {
                double x = ProcessingFunctions();
                while(true) {
                    if      (findChar('*')) x = x * ProcessingFunctions();
                    else if (findChar('/')) x = x / ProcessingFunctions();
                    else return x;
                }
            }

            double ProcessingFunctions() {
                if (findChar('+')) return +ProcessingFunctions();
                if (findChar('-')) return -ProcessingFunctions();

                double number;
                curentPosition = this.position;
                if (findChar('(')) {
                    number = additionSubtraction();
                    if (!findChar(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    number =Double.parseDouble(equation.substring(curentPosition, this.position));
                    numbers.add(number);

                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = equation.substring(curentPosition, this.position);
                    if (findChar('(')) {
                        number = additionSubtraction();
                        if (!findChar(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        number = ProcessingFunctions();
                    }
                    if (func.equals("sqrt")) number = Math.sqrt(number);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (findChar('^')) number = Math.pow(number, ProcessingFunctions());

                return number;
            }
        }.run();
    }

    public static double generateSolutionWithoutSteps(final String input) {
        return new Object() {
            int position = -1;
            int ch;
            String equation =input;
            int startPosition;
            ArrayList<Double> numbers = new ArrayList<>();

            void nextChar() {
                if (++position < equation.length())
                    ch = input.charAt(position);
                else
                    ch = -1;
            }

            boolean findChar(int charToFind) {
                if (ch == charToFind) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double run() {
                nextChar();
                double x = additionSubtraction();
                if (position < input.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double additionSubtraction() {
                double x = multiplicationDivision();
                while(true) {
                    if      (findChar('+')) x = x + multiplicationDivision();
                    else if (findChar('-')) x = x - multiplicationDivision();
                    else return x;
                }
            }

            double multiplicationDivision() {
                double x = ProcessingFunctions();
                while(true) {
                    if      (findChar('*')) x = x * ProcessingFunctions();
                    else if (findChar('/')) x = x / ProcessingFunctions();
                    else return x;
                }
            }

            double ProcessingFunctions() {
                if (findChar('+')) return +ProcessingFunctions();
                if (findChar('-')) return -ProcessingFunctions();

                double number;
                startPosition = this.position;
                //System.out.println(startPosition);
                if (findChar('(')) {
                    number = additionSubtraction();
                    if (!findChar(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    number =Double.parseDouble(input.substring(startPosition, this.position));
                    numbers.add(number);

                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = input.substring(startPosition, this.position);
                    if (findChar('(')) {
                        number = additionSubtraction();
                        if (!findChar(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        number = ProcessingFunctions();
                    }
                    if (func.equals("sqrt")) number = Math.sqrt(number);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (findChar('^')) number = Math.pow(number, ProcessingFunctions());

                return number;
            }
        }.run();
    }

}