package org.alura.literalura.validator;

import java.util.Scanner;

public interface IValidator {
  String getString(Scanner scanner, String message);
  int validInteger(Scanner scanner, String message);
}
