import java.sql.Connection;

public class Controller {
	Connection conn;

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.init();
	}

	private void init() {

		Connection con = ConnectionManager.getConnection("xmlreader/database.xml");
		MainView mainView = new MainView();

		UserDAO userDAO = new UserDAO(conn);

		// mainView.mainMenu()
		int option = mainView.mainMenu();
		// switch option
		// Afegir Usuari
		// Llistar usuaris

		// SWITCH afegir usuari ---> crido a la vista addUserForm
		User user = mainView.addUserForm();
		if (!userDAO.userExists(user.name)) {
			userDAO.add(user);
		}

		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'init'");
	}
}
