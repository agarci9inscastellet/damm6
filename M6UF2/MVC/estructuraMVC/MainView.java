import java.util.Scanner;

public class MainView {

    /**
     * @return
     */
    public int mainMenu() {
        // TODO Auto-generated method stub
        System.out.println("1. Llistat usuaris\n2 Afegir Usuari\n....\n...\n0 Sortir --> conn.close()");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        return option;
        //throw new UnsupportedOperationException("Unimplemented method 'mainMenu'");
    }

    public User addUserForm(){
        // Formulari usuari,
        System.out.println("FORMULARI USUARI....nom, pass, etc");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = "1234";

        return new User(username,password);
    }

}
