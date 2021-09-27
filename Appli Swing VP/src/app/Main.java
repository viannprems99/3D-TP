package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.vecmath.Vector2d;

import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.Context;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.GradientVertexRenderer;
import edu.uci.ics.jung.visualization.renderers.VertexLabelAsShapeRenderer;

public class Main {

    // CONSTANTS
    public static final int FRAME_WIDTH = 1168;
    public static final int FRAME_HEIGHT = 800;
    public static final int MENU_HEIGHT = 500;
    public static final int MENU_WIDTH = 200;

    // ATTRIBUTS
    private JFrame frame; // The window
    private JMenuBar menuBar; // Bar Menu
    private JMenuItem fermer, aide;
    private JButton addImage;
    private Image imgFond; // Background image

    // CONSTRUCTOR
    public Main() {
        Graphics g;
        createView();
        placeComponents();
        createController();
    }

    // COMMANDS
    public void display() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    private void createView() {
        frame = new JFrame("Reconstruction urbaine - Vianney-Premier NANDA");
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        fermer = new JMenuItem("Fermer", new ImageIcon("images/fermer.jpg"));
        aide = new JMenuItem("Aide", new ImageIcon("images/aide.jpg"));

        
    }

    private void placeComponents() {
        JPanel menu1 = new JPanel();
        {
            menu1.setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));
            menu1.setBorder(BorderFactory.createEtchedBorder());

            
        }
        frame.add(menu1, BorderLayout.EAST);
        
        menuBar = new JMenuBar();
        {
            JMenu menuFile = new JMenu("File");
            {
                menuFile.add(fermer);
            }
            menuBar.add(menuFile);
            JMenu menuEdit = new JMenu("About us");
            {
                menuEdit.add(aide);
            }
            menuBar.add(menuEdit);
        }
        frame.setJMenuBar(menuBar);

        Graphics g = null;
        try {
            imgFond = ImageIO.read(new File("images/fond.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(imgFond, 500, 600, frame);   
        
    }

    private void createController() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fermer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        aide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Contact :\n" + "Vianney-Premier NANDA : nandanv@3il.fr");
            }
        });           
    }
    
    
    // POINT D'ENTREE
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().display();
            }
        });
    }
}
