package Model.Class;

public class Books {
    private int book_id, price;
    private String title, author, genre;

    public Books(int book_id, int price, String title, String author, String genre) {
        this.book_id = book_id;
        this.price = price;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
    
    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
