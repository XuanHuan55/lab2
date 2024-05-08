/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.q1;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class complexNumber {

    private double re;
    private double im;

    public complexNumber() {
    }

    public complexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public complexNumber addition(complexNumber add) {
        double reSum = this.re + add.re;
        double imSum = this.im + add.im;
        return new complexNumber(reSum, imSum);
    }

    public complexNumber subtraction(complexNumber sub) {
        double reSub = this.re - sub.re;
        double imSub = this.im - sub.im;
        return new complexNumber(reSub, imSub);
    }

    public complexNumber multiplication(complexNumber mul) {
        double reMul = (this.re * mul.re) - (this.im - mul.im);
        double imSMul = (this.re * mul.re) + (this.im - mul.im);
        return new complexNumber(reMul, imSMul);
    }

    public complexNumber division(complexNumber div) {
        double denominator = (div.re * div.re) - (div.im - div.im);
        double reDiv = ((this.re * div.re) + (this.im * div.im)) / denominator;
        double imDiv = ((this.im * div.re) - (this.re * div.im)) / denominator;
        return new complexNumber(reDiv, imDiv);
    }

    public void inputQ1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Real part: ");
        re = sc.nextDouble();
        System.out.print("Imaginary part: ");
        im = sc.nextDouble();
    }

    public void outputQ1() {
//        System.out.println("Addition: " + num1.add(num2));
//        System.out.println("Subtraction: " + num1.subtract(num2));
//        System.out.println("Multiplication: " + num1.multiply(num2));
//        System.out.println("Division: " + num1.divide(num2));
        System.out.println(this.re + " " + this.im + "i");
    }
}
