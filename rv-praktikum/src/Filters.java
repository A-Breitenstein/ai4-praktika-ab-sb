import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/**
 * Created with IntelliJ IDEA.
 * User: Sven
 * Date: 15.04.13
 * Time: 21:36
 */
public class Filters {

    static boolean isEven(int number) {
        return (number % 2) == 0;
    }
    /***************************************************************************/
  /* Function definition: ----- Median-operator----                          */
    /***************************************************************************/
    public static void Median( Raster sPic, 	// source picture
                       WritableRaster dPic, 	// destination picture
                        final int MaskSizeX,		    // mask size in x-direction
                        final int MaskSizeY		 	// mask size in y-direction
    )
    {


        int PicSizeY = sPic.getHeight();
        int PicSizeX = sPic.getWidth();

        int x,y,mx,my,cx,cy,c_median,median = 0,accu = 0;

        int grauStufenMap[] = new int[256];

        mx = MaskSizeX;
        my = MaskSizeY;

        if(isEven(mx)) {mx++;
            System.out.println( " X musste angepasst werden, mx =" + mx );}
        if(isEven(my)) {my++;
            System.out.println(" Y musste angepasst werden, my =" + my);}

        int offsetX = (int) (mx / 2);
        int offsetY = (int) (my / 2);
        int median_grenze = (int)(mx*my/2);

        PicSizeX = PicSizeX - offsetX;
        PicSizeY = PicSizeY - offsetY;

        int sPicValue, mask_low, mask_high;

        for(y=offsetY; y<PicSizeY; y++)
            for(x=offsetX; x<PicSizeX; x++){

			for(int init = 0; init < 256; init++)
				grauStufenMap[init] = 0;

                //Init Werte fuer Max- und Minimalwerte
                mask_low = 255;
                mask_high = 0;
                for(cy = -offsetY; cy <= offsetY;cy++)
                    for(cx = -offsetX; cx <= offsetX;cx++){
                        // channel 0, bei einem 8bit grayscale bild gibt es nur den einen channel
                        sPicValue = sPic.getSample(x + cx, y + cy, 0);
                        grauStufenMap[sPicValue]+=1;

                        if(sPicValue > mask_high){

                            mask_high = sPicValue;

                        }else if(sPicValue < mask_low){
                            mask_low = sPicValue;
                        }
                    }

                //Init Werte fuer Medianrechner
                accu = 0;
                for(c_median = mask_low;c_median < mask_high;c_median++){
                    accu+=grauStufenMap[c_median];

                    if(accu >= median_grenze){
                        median = c_median;
                        break;
                    }

                }
                dPic.setSample(x,y,0,median);
            }
    }

    public static int convertRGBto8BitGrayscale(int rgbVal) {
        int r, g, b;
        int lum;
        int grayVal;
        /* RGB --> 32 Bit Integer
        * 1 Byte (alpha) | 1 Byte (red) | 1 Byte (green) | 1 Byte (blue)
        */
        r = (rgbVal >> 16) & 0xff; //red
        g = (rgbVal >> 8) & 0xff; //green
        b = rgbVal & 0xff; //blue

        // Convert
        lum = (int) Math.round(0.2126 * r + 0.7152 * g + 0.0722 * b);
        grayVal = (lum << 16) | (lum << 8) | lum;
//        grayVal = grayVal & 0xFF000000;
        return grayVal;

    }
}
