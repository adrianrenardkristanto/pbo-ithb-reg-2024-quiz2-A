package Model.Class;

public class Users {
    private int user_id, password;
    private String name, email;

    public Users(int user_id, int password, String name, String email) {
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.email = email;
    }
    
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
