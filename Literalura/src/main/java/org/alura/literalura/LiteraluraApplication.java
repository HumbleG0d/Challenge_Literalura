package org.alura.literalura;

import org.alura.literalura.repository.AuthorRepository;
import org.alura.literalura.repository.BookRepository;
import org.alura.literalura.view.LiteraluraApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private AuthorRepository authorRepository;

  public static void main(String[] args) {
    SpringApplication.run(LiteraluraApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    LiteraluraApp literaluraApp = new LiteraluraApp(bookRepository , authorRepository);
    literaluraApp.playApp();
  }
}
