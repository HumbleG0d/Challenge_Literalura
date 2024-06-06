package org.alura.literalura.validator;

import java.util.Scanner;

public class Validator implements IValidator , IValidApp {
  // Metodo que obtiene un string
  @Override
  public String getString(Scanner scanner, String message) {
    System.out.print(message);
    return scanner.nextLine();
  }

  // Metodo que valida un entero
  @Override
  public int validInteger(Scanner scanner, String message) {
    int i = 0;
    boolean isValid = false;
    while(!isValid){
      System.out.print(message);
      if(scanner.hasNextInt()){
        i = scanner.nextInt();
        isValid = true;
      }
      else{
        System.out.println("Este valor no es valido, intente de nuevo");
      scanner.nextLine();
      }
    }
    return i;
  }

  // Metodo que valida una opcion
  @Override
  public int validOption(Scanner scanner, String message, int min, int max) {
    int i = 0;
    boolean isValid = false;
    while (!isValid){
      i = validInteger(scanner, message);
      if(i >= min && i <= max){
        isValid = true;
      }
      else{
        System.out.println("Esta opcion no es valida, intente de nuevo");
      }
      scanner.nextLine();
    }
    return i;
  }
}
