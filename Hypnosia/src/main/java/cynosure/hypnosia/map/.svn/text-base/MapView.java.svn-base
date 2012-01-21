package cynosure.hypnosia.map;

import java.awt.*;

import javax.swing.JFrame;

public class MapView extends JFrame {

   private static final long serialVersionUID = 1L;

   Toolkit toolkit;
   MapImage m_mapImage;

   // constructor
   public MapView()
   {
      // window size width by height
      setSize(1000, 700);
      // window title
      setTitle("Hypnosia");
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      toolkit = getToolkit();
      Dimension screenSize = toolkit.getScreenSize();
      // center window on screen
      setLocation(screenSize.width / 2 - getWidth() / 2,
         screenSize.height / 2 - getHeight() / 2);

      // how to specify the path to the resource dir?
      m_mapImage = new MapImage("/Users/fillmore/Games/Maps/DragonPerch.jpg");
   }

   // paint
   public void paint(Graphics _graphics)
   {
      _graphics.drawImage( m_mapImage.returnImage(),
                          0, 0, this);
   }

   // entrance
   public static void main(String[] args)
   {
      MapView m_mapView = new MapView();
      m_mapView.setVisible(true);
   }

}

