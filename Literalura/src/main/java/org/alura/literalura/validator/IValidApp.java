package org.alura.literalura.validator;

import java.util.Scanner;

public interface IValidApp {
  int validOption(Scanner scanner , String message, int min, int max);
}
