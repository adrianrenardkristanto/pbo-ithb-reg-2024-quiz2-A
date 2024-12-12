package Model.Class;

public class Transactions {
    private int transaction_id;
    private Users users;
    private Books books;
    public Transactions(int transaction_id, Users users, Books books) {
        this.transaction_id = transaction_id;
        this.users = users;
        this.books = books;
    }
    public int getTransaction_id() {
        return transaction_id;
    }
    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
    public Books getBooks() {
        return books;
    }
    public void setBooks(Books books) {
        this.books = books;
    }
    
}