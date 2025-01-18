package br.com.alura.literAlura.controller;

import br.com.alura.literAlura.model.Author;
import br.com.alura.literAlura.model.Book;
import br.com.alura.literAlura.model.DataBook;
import br.com.alura.literAlura.repository.AuthorRepository;
import br.com.alura.literAlura.repository.BookRepository;
import br.com.alura.literAlura.service.ConsumerAPI;
import br.com.alura.literAlura.service.DataConverter;
import br.com.alura.literAlura.service.ResponseAPI;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CommandLine {
    private static final String ADRESS = "https://gutendex.com/books/?search=";
    private ConsumerAPI consumer = new ConsumerAPI();
    private DataConverter converter = new DataConverter();
    private Scanner scan = new Scanner(System.in);
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public CommandLine(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void showMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Encontre o livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um idioma específico
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    findBookByTitle();
                    break;
                case 2:
                    listRegisteredBooks();
                    break;
                case 3:
                    listRegisteredAuthors();
                    break;
                case 4:
                    listLivingAuthorsPerYear();
                    break;
                case 5:
                    listBooksByLanguage();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao inválida");
            }
        }
    }


    private void findBookByTitle() {
        System.out.println("Digite o nome do livro para pesquisar:");
        String bookName = scan.nextLine();

        var bookExistent = bookRepository.findByTitleContainingIgnoreCase(bookName);
        if (bookExistent.isPresent()) {
            System.out.println("Livro encontrado no banco de dados:");
            System.out.println(bookExistent.get());
            return;
        }

        DataBook data = getDadosLivro(bookName);
        if (data == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        saveBook(data);
        System.out.println("Livro salvo no banco de dados.");
        System.out.println(data);
    }

    private DataBook getDadosLivro(String bookName) {
        String adressSearch = ADRESS + bookName.replace(" ", "+");
        System.out.println(adressSearch);

        var json = consumer.obterDados(adressSearch);

        if (json.contains("{\"count\":0,\"next\":null,\"previous\":null,\"results\":[]}")) {
            return null;
        } else {
            ResponseAPI response = converter.getData(json, ResponseAPI.class);
            List<DataBook> books = response.getResults();

            if (!books.isEmpty()) {
                return books.get(0);
            } else {
                return null;
            }
        }
    }

    private void saveBook(DataBook dataBook) {
        Book book = new Book();
        book.setTitle(dataBook.title());
        book.setDownloads(dataBook.downloads());
        book.setLanguage(dataBook.languages().get(0));

        System.out.println(dataBook.authors().get(0).name());
        Author author ;
        var authorDb = authorRepository.findByName(dataBook.authors().get(0).name());

        if (authorDb.isPresent()) {
            author = authorDb.get();

        } else {
            author = new Author();
            author.setName(dataBook.authors().get(0).name());
            author.setYearBirth(dataBook.authors().get(0).birthYear());
            author.setDeathYear(dataBook.authors().get(0).deathYear());
            authorRepository.save(author);

        }
        book.setAuthor(author);
        bookRepository.save(book);
    }

    private void listRegisteredBooks () {
        var books = bookRepository.findAll();
        books.forEach(System.out::println);
    }

    private void listRegisteredAuthors () {
        var authors = authorRepository.findAll();
        authors.forEach(System.out::println);
    }

    private void listLivingAuthorsPerYear() {
        System.out.println("Insira o ano em que você deseja saber se o autor está vivo:");
        var year = scan.nextInt();
        List<Author> livinAuthors =  authorRepository.findByDeathYearGreaterThan(year);
        livinAuthors.forEach(System.out::println);
    }

    private void listBooksByLanguage() {
        System.out.println("Digite o idioma em que deseja listar os livros: Português, Inglês ou Espanhol:");
        var language = scan.nextLine();
        if (language.equals("Português")){
            language = "pt";
        } else if(language.equals("Inglês")) {
            language = "en";
        } else if(language.equals("Espanhol")){
            language = "es";
        } else {
            System.out.println("Idioma não encontrado.");
            return;
        }
        List<Book> bookByLanguage = bookRepository.findBooksByLanguage(language);
        bookByLanguage.forEach(System.out::println);
    }

    }
    
