package java8.streams.sorting;

import java.util.Comparator;
import java.util.stream.Stream;

public class Java8StreamsSortingDemo {
    public static void main(String[] args) {


        Comparator<Book> sortByName = (b1, b2) -> b1.getName().compareToIgnoreCase(b2.getName());
        Comparator<Book> sortByCost = (b1, b2) -> b1.getCost().compareTo(b2.getCost());
        Comparator<Book> sortByRating = (b1, b2) -> b1.getRating().compareTo(b2.getRating());

        Book book1 = new Book(1001, "AAA", 1000F, 4.4F);

        Book book2 = new Book(1783, "BBB", 1200F, 4.5F);

        Stream.of(book1, book2)
                .sorted(sortByName)
                .sorted(sortByCost)
                .sorted(sortByRating)
                .forEach(System.out::println);

    }
}


class Book {
    Integer isbn;
    String name;
    Float cost;
    Float Rating;

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Book(Integer isbn, String name, Float cost, Float rating) {
        this.isbn = isbn;
        this.name = name;
        this.cost = cost;
        Rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getRating() {
        return Rating;
    }

    public void setRating(Float rating) {
        Rating = rating;
    }
}
