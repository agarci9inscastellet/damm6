import java.sql.Connection;

public class Controller {
	Connection conn;


		public static void main(String[] args) {
			Controller controller = new Controller(); 
			controller.init();
		}
	
		private void init() {
			ReadXML config =  new ReadXML("database.xml");
			Connection conn = config.dbConnect();
			MainView mainView = new MainView();
	
	
			UserDAO userDAO = new UserDAO(conn);
			
			// mainView.mainMenu()
			int option = mainView.mainMenu();
			// switch option
			// Afegir Usuari
			// Llistar usuaris
	
			// SWITCH afegir usuari ---> crido a la vista addUserForm
			User user = mainView.addUserForm();
			if (!userDAO.userExists(user.name)){
				userDAO.add(user);  
			}
	
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'init'");
		}	
	}


