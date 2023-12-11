package reduction.collect;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DemoToList {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1001, "title1", 100F, 4.8F));
        books.add(new Book(1002, "title2", 1050F, 4.8F));
        books.add(new Book(1001, "title3", 50F, 4.0F));
        books.add(new Book(1004, "title4", 100F, 3.5F));
        books.add(new Book(1005, "title5", 90F, 4.8F));

        solve(books);
    }

    private static void solve (List<Book> books) {

        //demo1 toList() using collect2
        /*
        List<Book> list1 = books.stream()
                .filter(b -> b.getRating() >= 4.5)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("list1.size() : "+list1.size());

        */

        //demo2 toList() using collect1
        /*
        List<Book> list2 = books.stream()
                .filter(b -> b.getRating() >= 4.5)
                .distinct()
                .collect(() -> new ArrayList(), // ArrayList::new,
                        (a, t) -> a.add(t),     // ArrayList::add,
                        (a1, a2) -> a1.addAll(a2));//ArrayList::addAll
        System.out.println("list2.size() : "+list2.size());

         */

        //demo3 toSet()

        /*
        Set<Book> set1 = books.stream()
                .filter(b -> b.getRating() >= 4.5)
                //.distinct()
                .collect(Collectors.toSet());
        System.out.println("set1.size() : "+set1.size());

         */

        //demo4 toSet()
        /*
        Set<Book> treeSet = books.stream()
                .filter(b -> b.getRating() >= 4.5)
                //.distinct()
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeSet.size() : "+treeSet.size());

         */

        ///////////////////////////////////////////////////////////////////////////////
        //demo1 of toMap()1 which uses only keyMapper, valueMapper : causing DuplicateKey exception

        /*
        Map<Integer, Book> map = books.stream()
                .collect(Collectors.toMap(
                        b -> b.getIsbn(),
                        b -> b
                ));
        System.out.println();
        */

        //demo2 of toMap()2 which uses also mergeFunction with keyMapper, valueMapper  : causing DuplicateKey exception
        /*
        Map<Integer, Book> map = books.stream()
                .collect(Collectors.toMap(
                        b -> b.getIsbn(),
                        b -> b,
                        (b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2
                ));
        for (Map.Entry<Integer, Book> entry : map.entrySet()) {

            System.out.println("isbn : "+entry.getKey() + " Book is : "+entry.getValue());
        }
        */

        //demo3 of toMap()3 to create a specific type Map instance "TreeMap"
        // which uses also supplier with mergeFunction with keyMapper, valueMapper  : causing DuplicateKey exception
        Map<Integer, Book> treeMap = books.stream()
                .collect(Collectors.toMap(
                        b -> b.getIsbn(),
                        Function.identity(),
                        (b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2,
                        () -> new TreeMap()
                ));
        for (Map.Entry<Integer, Book> entry : treeMap.entrySet()) {
            System.out.println("isbn : "+entry.getKey() + " Book is : "+entry.getValue());
        }

        //creating map of value of list types using toMap() 2, this is very complicated.
        /*
        Map<Float, List<Book>> ratings1 = treeMap
                .values()
                .stream()
                .collect(Collectors.toMap(
                        Book::getRating,
                        b -> Collections.singletonList(b),
                        (l1, l2) -> {
                            ArrayList<Book> l = new ArrayList<>(l1);
                            l.addAll(l2);
                            return l;
                        }
                                        )
                        );

         */

        //creating map of value of list types using groupingBy() method, this is more elegant code.
        Map<Float, List<Book>> ratings1 = treeMap
                .values()
                .stream()
                .collect(Collectors.groupingBy(Book::getRating));

        for (Map.Entry<Float, List<Book>> entry : ratings1.entrySet()) {
            System.out.println("Ratings : "+entry.getKey());
            for (Book b : entry.getValue()) {
                System.out.println(b);
            }
        }



    }
}
class Book implements Comparable {

    Integer isbn;
    String title;
    Float price;

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    Float rating;

    public Book(Integer isbn, String title, Float price, Float rating) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public int compareTo(Object o) {
        return isbn.compareTo(((Book)o).getIsbn());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(price, book.price) && Objects.equals(rating, book.rating);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (isbn ^ (isbn >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
