import controller.CompteController;

public class Main {

    public static void main(String[] args) {
        CompteController compte = CompteController.askAccountType();
        compte.fstMenu();

    }
}