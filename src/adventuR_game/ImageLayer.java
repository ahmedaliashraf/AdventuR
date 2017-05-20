package adventuR_game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ImageLayer
{
   Image image;

   double x;
   double y;
   double z;

   int w;
   
   int count;



   public ImageLayer(String filename, double x, double y, double z, int w, int count)
   {
      image = Toolkit.getDefaultToolkit().getImage(filename);

      this.x = x;
      this.y = y;
      this.z = z;

      this.w = w;
      
      this.count  = count;

   }


   public void draw(Graphics g)
   {
      for(int i = 0; i < count; i++)

         g.drawImage(image, (int)(x - Camera2D.x/z) + w*i, (int)(y - Camera2D.y), null);
   }


}
