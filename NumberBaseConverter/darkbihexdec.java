/**
  darkbihexdec.java

  Author: Steven Pham
  Description:
  A prototype tool for converting between binary, hexadecimal, and decimal numbers.
  Also supports addition and subtraction of numbers across different formats.
  Built using raw Java logic without standard library conversion methods.
  Developed as a personal utility before learning more conventional approaches.
 */

import java.util.Scanner;

public class darkbihexdec {
  public static String[] hexa = {"A", "B", "C", "D", "E", "F"};
  public static int[] dexa = {10, 11, 12, 13, 14, 15};
  public static void main(String args[]) {
    while (true)
    {
      Scanner myScanner = new Scanner(System.in);
      long n1, n2, n3, number = 0, number2 = 0;
      String yes = "0";
      String maybe = "0";
      System.out.println("Starting :0 for binary || 1 for hexadecimal || 2 for decimal || -1 TO STOP: ");
      n1 = myScanner.nextLong();
      System.out.println("Type in the Value:  ");
      if (n1 == -1)
      {
        myScanner.close();
        return;
      }
      else if (n1 == 0 || n1 == 1)
      {
        myScanner.nextLine();
        yes = myScanner.nextLine();
      }
      else if (n1 == 2) number = myScanner.nextLong();
      System.out.println("0 for Conversion || 1 for Add || 2 for Subtract: ");
      n2 = myScanner.nextLong();
      if (n2 == 0)
      {
        System.out.println("End : 0 for binary || 1 for hexadecimal || 2 for decimal:  ");
        n3 = myScanner.nextLong();
        if (n1 == n3) System.out.println("wtf you mean?");
        else if (n1 == 0){
          if (n3 == 1){
            System.out.printf("Hexa: %s\n", decToHex(biToDec(yes)));
          }
          else System.out.printf("Decimal: %d\n", biToDec(yes));
        }
        else if (n1 == 1){
          if (n3 == 0){
            System.out.printf("Binary: %s\n", hexToBi(yes));
          }
          else System.out.printf("Decimal: %d\n", biToDec(hexToBi(yes)));
        }
        else if (n1 == 2){
          if (n3 == 1){
            System.out.printf("Hexa: %s\n", decToHex(number));
          }
          else System.out.printf("Binary: %s\n", hexToBi(decToHex(number)));
        }
      }
      else if (n2 == 1 || n2 == 2)
      {
        System.out.println("Type in the value: ");
        if (n1 == 2)
        {
          number2 = myScanner.nextLong();
          if (n2 == 1) System.out.println(""+(number + number2));
          else System.out.println(""+(number - number2));
        }
        else {
          myScanner.nextLine();
          maybe = myScanner.nextLine();
          if (n1 == 0)
          {
            long temp1 = biToDec(yes);
            long temp2 = biToDec(maybe);
            if (n2 == 1) System.out.printf("Result: %s\n", hexToBi(decToHex(temp1 + temp2)));
            else System.out.printf("Result: %s\n", hexToBi(decToHex(temp1 - temp2)));
          }
          else if (n1 == 1)
          {
            long temp1 = biToDec(hexToBi(yes));
            long temp2 = biToDec(hexToBi(maybe));
            if (n2 == 1) System.out.printf("Result: %s\n", decToHex(temp1 + temp2));
            else System.out.printf("Result: %s\n", hexToBi(decToHex(temp1 - temp2)));
          }
        }
      }
    }
  }
  public static String decToHex(long n){
    long temp = n;
    long temp1 = temp;
    int counter = 0;
    long check = 16;
    Boolean added = false;
    String hex = "";
    while (true)
    {
      counter++;
      temp1 /= 16;
      if (temp1 < 16) break;
      check *= 16;
    }
    for (int i = counter; i > 0; i--)
    {
      if (temp >= check)
      {
        counter = 0;
        while (temp >= check)
        {
          counter++;
          temp -= check;
        }
        if (counter > 9)
        {
          for (int j = 0; j < hexa.length; j++){
            if (dexa[j] == counter){
              hex += hexa[j];
              break;
            }
          }
        }
        else hex += counter;
     
        added = true;
      }
      else if (added) hex += "0";
      check /= 16;
    }
    if (temp > 0)
    {
      if (temp > 9)
      {
        for (int i = 0; i < hexa.length; i++){
          if (dexa[i] == temp){
            hex += hexa[i];
            break;
          }
        }
      }
      else hex += temp;
    }
    else if (added) hex += "0";
    return hex;
  }
  public static long biToDec(String bi){
    long temp;
    long total = 0;
    String check;
    int counter = bi.length();
    for (int j = 0; j < bi.length(); j++)
    {
      temp = 0;
      check = "";
      counter--;
      check += bi.charAt(j);
      temp = Integer.parseInt(check);
      if (temp > 0)
      {
        for (int i = 0; i < counter; i++){
          temp *= 2;
        }
        total += temp;
      }
    }
    return total;
  }
  public static String hexToBi(String hex){
    int temp = 0;
    Boolean isDec;
    String total = "";
    String check;
    Boolean added = false;
    for (int j = 0; j < hex.length(); j++)
    {
      isDec = true;
      check = "";
      check += hex.charAt(j);
      for (int i = 0; i < hexa.length; i++){
        if (check.equals(hexa[i]))
        {
          added = true;
          isDec = false;
          temp = dexa[i];
          break;
        }
      }
      if (isDec)
      {
        added = true;
        temp = Integer.parseInt(check);
      }
      if (!added) continue;
      if (temp >= 8){
        temp -= 8;
        total += "1";
      }
      else total += "0";
      if (temp >= 4){
        temp -= 4;
        total += "1";
      }
      else total += "0";
      if (temp >= 2){
        temp -= 2;
        total += "1";
      }
      else total += "0";
      if (temp >= 1){
        total += "1";
      }
      else total += "0";
    }
    return total;
  }
}