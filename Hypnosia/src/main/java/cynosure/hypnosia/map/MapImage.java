package cynosure.hypnosia.map;

import java.awt.*;

// class MapImage contains the map image,
// image read and write methods
// and image meta-data

public class MapImage {

   String m_sMapFile; // map image file
   Image m_image;
   int m_nMapImageWidth;
   int m_nMapImageHeight;

   // constructor
   MapImage(String _sMapFile)
   {
      m_sMapFile = _sMapFile;
      m_image = Toolkit.getDefaultToolkit().getImage(m_sMapFile);
   }

   public Image returnImage()
   {
      return m_image;
   }
}
