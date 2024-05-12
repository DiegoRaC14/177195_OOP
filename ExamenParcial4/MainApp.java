package examenFinal;
import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow myWindow = new MainWindow();
            new ShortcutManager(myWindow);
            
            myWindow.setVisible(true);
        });
    }

}

