package org.alura.literalura.view;

import org.alura.literalura.model.Author;
import org.alura.literalura.model.Books;
import org.alura.literalura.model.DataResultsBooks;
import org.alura.literalura.model.Languages;
import org.alura.literalura.repository.AuthorRepository;
import org.alura.literalura.repository.BookRepository;
import org.alura.literalura.services.BookService;
import org.alura.literalura.services.ConsumeAPI;
import org.alura.literalura.services.DataConversion;
import org.alura.literalura.validator.Validator;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LiteraluraApp implements ILiteraluraApp{

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private BookService bookService ;
  private final Validator validator = new Validator();

  private final Scanner sc = new Scanner(System.in);
  private List<Books> listBooks;

  // Dependency Injection
  public LiteraluraApp(BookRepository bookRepository, AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
    bookService = new BookService(new ConsumeAPI(), new DataConversion());
  }

  // Metodo que muestra el menu de la aplicacion
  public void menu() {
    System.out.println("===== Bienvenido a Literalura =====");
    System.out.println("1. Buscar libro por titulo en la API de Gutendex");
    System.out.println("2. Listar libros registrados en la base de datos");
    System.out.println("3. Listar autores registrados en la base de datos");
    System.out.println("4. Listar autores vivos en un determinado año");
    System.out.println("5. Listar libros por idioma");
    System.out.println("6. Salir");
  }

  // Metodo que inicia la aplicacion
  public void playApp(){
    boolean flag = true;

    while(flag){
      menu();
      var option = validator.validOption(sc, "Ingrese una opcion: ", 1, 6);
      switch (option){
        case 1 -> showBooks();
        case 2 -> listBooksDataBase();
        case 3 -> listRegisterAuthorsDataBase();
        case 4 -> listAuthorsAliveInYear();
        case 5 -> listBooksByLanguage();
        case 6 -> flag = false;
        default -> System.out.println("Opcion no valida");
      }
    }
  }

  // Metodo que busca un libro por su titulo en la API de Gutendex
  @Override
  public void showBooks() {
    DataResultsBooks dataResults = bookService.getDataResults();

    var nombreLibro = validator.getString(sc, "Ingrese el nombre del libro que desea buscar: ");

    // Se mapea la lista de libros de la API a una lista de libros
    listBooks = dataResults.dataBooks().stream().map(dataBook -> new Books(dataBook , dataBook.autores().get(0))).collect(Collectors.toList());

    // Se busca el libro por su titulo
    Optional<Books> book = listBooks.stream().filter(b ->b.getTitulo().toLowerCase().contains(nombreLibro.toLowerCase())).findFirst();

    // Si el libro se encuentra se muestra en consola
    if(book.isPresent()){
      var bookOptional = book.get();

      // Se busca si el autor ya se encuentra registrado en la base de datos
      Optional<Author> authorOptional = authorRepository.findByName(bookOptional.getAutor().getName());

      // Si el autor se encuentra registrado se asigna al libro
      if(authorOptional.isPresent()){
        bookOptional.setAutor(authorOptional.get());
      }else {// Si el autor no se encuentra registrado se guarda en la base de datos
        authorRepository.save(bookOptional.getAutor());
      }

      // Se busca si el libro ya se encuentra registrado en la base de datos
      if(bookRepository.findByTitulo(bookOptional.getTitulo()).isEmpty()){
        System.out.println("===== Libro =====");
        System.out.print(bookOptional);
        System.out.println("==========");
      bookOptional.getAutor().setBooks(List.of(bookOptional));
        bookRepository.save(bookOptional);
      }else{
        System.out.println("El libro ya se encuentra registrado en la base de datos");
      }
    }else{
      System.out.println("Libro no encontrado");
    }
  }

  // Metodos que listan los libros y autores registrados en la base de datos
  @Override
  public void listBooksDataBase(){
    List<Books> books = bookRepository.findAll();
    System.out.println("===== Libros registrados en la base de datos =====");
    books.forEach(System.out::println);
    System.out.println("====================================");
  }

  @Override
  public void listRegisterAuthorsDataBase(){
    List<Author> authors = authorRepository.findAll();
    System.out.println("===== Autores registrados en la base de datos =====");
    authors.forEach(System.out::println);
    System.out.println("====================================");
  }

  @Override
  public void listAuthorsAliveInYear(){
    var year = validator.validInteger(sc, "Ingrese el año que desea buscar: ");
    List<Author> authors = authorRepository.searchAuthorbyYear(year);
    System.out.println("===== Autores vivos en el año "+year+" =====");
    authors.forEach(System.out::println);
    System.out.println("====================================");
  }

  @Override
  public void listBooksByLanguage(){
    sc.nextLine();
    System.out.println("""
            es -> Español
            en -> Ingles
            fr -> Frances
            """);
    var language = validator.getString(sc, "Ingrese el idioma que desea buscar: ");
    List<Books> books = bookRepository.searchBookByLanguage(Languages.getLanguage(language));
    System.out.println("===== Libros en el idioma "+language+" =====");
    books.forEach(System.out::println);
    System.out.println("====================================");
  }
}
