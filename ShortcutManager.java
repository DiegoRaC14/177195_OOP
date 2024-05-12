package examenFinal;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class ShortcutManager {
    private KeyStroke saveShortcut = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK, false);
    private KeyStroke loadShortcut = KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK, false);
    private KeyStroke clearShortcut = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK, false);
    private KeyStroke eraseShortcut = KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK, false);

    public ShortcutManager(MainWindow myShortcuts) {
        // Agrega escuchadores de eventos de teclado para los atajos definidos
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            
        	@Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (saveShortcut.equals(KeyStroke.getKeyStrokeForEvent(e))) {
                    myShortcuts.saveCanvasImage();
                    System.out.println("Save");
                    return true;
                } else if (loadShortcut.equals(KeyStroke.getKeyStrokeForEvent(e))) {
                    myShortcuts.loadCanvasImage();
                    System.out.println("Load");
                    return true;
                } else if (clearShortcut.equals(KeyStroke.getKeyStrokeForEvent(e))) {
                    myShortcuts.clearCanvas();
                    System.out.println("Clear");
                    return true;
                } else if (eraseShortcut.equals(KeyStroke.getKeyStrokeForEvent(e))) {
                    myShortcuts.erasePixel();
                    System.out.println("Erase Pixel");
                    return true;
                }
                return false;
            }
        });
    }
}



