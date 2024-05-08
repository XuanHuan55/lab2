/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.q1;

/**
 *
 * @author ASUS
 */
public class Q1 {
    public static void main(String[] args) {
        complexNumber num1 = new complexNumber();
        complexNumber num2 = new complexNumber();
        num1.inputQ1();
        num1.outputQ1();
        num2.inputQ1();
        num2.outputQ1();
        num1.addition(num2).outputQ1();
        num1.subtraction(num2).outputQ1();
        num1.multiplication(num2).outputQ1();
        num1.division(num2).outputQ1();

    }
}
