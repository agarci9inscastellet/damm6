public class MainView {
    public User addUserForm(){
        // Formulari usuari,
        // valida dades
        String username = "pepe";
        String password = "1234";

        return new User(username,password);
    }
}
