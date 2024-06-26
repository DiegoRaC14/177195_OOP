package examenFinal;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class MainWindow extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;
    private CanvasPanel canvasPanel;
    private ColorPickerPanel colorPickerPanel;
    //private ImageModel imageModel;


    public MainWindow() {
        setTitle("Pixel Art Creator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //imageModel = new ImageModel(50, 50);

        setupLayout();
        initializeComponents();
        registerListeners();
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JToolBar toolBar = new JToolBar();
        JButton saveButton = new JButton("Guardar Imagen");
        saveButton.addActionListener(e -> saveCanvasImage());
        toolBar.add(saveButton);

        JButton loadButton = new JButton("Cargar Imagen");
        loadButton.addActionListener(e -> loadCanvasImage());
        toolBar.add(loadButton);

        JButton clearButton = new JButton("Limpiar Canvas");
        clearButton.addActionListener(e -> clearCanvas());
        toolBar.add(clearButton);
        
        JButton eraseButton = new JButton("Borrar Pixel");
        eraseButton.addActionListener(e -> erasePixel());
        toolBar.add(eraseButton);

        add(toolBar, BorderLayout.NORTH);

        canvasPanel = new CanvasPanel();
        add(canvasPanel, BorderLayout.CENTER);

        colorPickerPanel = new ColorPickerPanel();
        add(colorPickerPanel, BorderLayout.EAST);
    }

    private void initializeComponents() {
        // Initialize any additional components if necessary
    }

    private void registerListeners() {
        colorPickerPanel.addColorSelectionListener(new ColorPickerPanel.ColorSelectionListener() {
            @Override
            public void colorSelected(Color color) {
                // Update the currently selected color on the canvas panel
                canvasPanel.setCurrentColor(color);
            }
        }
      );
    }

    public void saveCanvasImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Image");
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                FileHandler.saveImage(canvasPanel.getCanvasImage(), fileToSave);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving image", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void loadCanvasImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load Image");
        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            try {
                BufferedImage loadedImage = FileHandler.loadImage(fileToLoad);
                canvasPanel.setCanvasImage(loadedImage);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error loading image", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void clearCanvas() {
        canvasPanel.clearCanvas();
    }
    
    // Agregado
   public void erasePixel() {
	   canvasPanel.setCurrentColor(Color.WHITE);
	}
}
