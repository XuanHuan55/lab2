/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.q2;

import com.mycompany.Q2.Bank;
import java.util.*;


/**
 *
 * @author ASUS
 */
public class Q2 {

    public static void main(String[] args) {
        Bank b = new Bank();
       List<Bank> accounts = b.inputAccounts();

        System.out.println("\nAccount List:");
        b.outputAccounts(accounts);
        b.performOperations(accounts);

    }
}
