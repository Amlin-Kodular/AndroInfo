package com.amlin.displayinfo;

import android.content.Context;
import android.util.Log;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;
//
import android.util.DisplayMetrics;
import android.content.Context;

@DesignerComponent(
   version = 1,
   description = "This is tool created by amlin. If you have any problem with extension or app compiled then please report at theoseamiya@gmail.com",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = ""
)

@SimpleObject(external = true)
public class DisplayInformation extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context;
    /**
     * @param container container, component will be placed in
     */
    public DisplayInformation(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        this.context = container.$context();
    }
  
   @SimpleFunction(description="To get the x- width of the screen")
    public int GetScreenX() {
      DisplayMetrics dm = this.context.getResources().getDisplayMetrics();
      int xDpi = dm.widthPixels;
      return xDpi;
   }
   //Now for the y height
   
    @SimpleFunction(description = "Screen size y height")
   public int GetScreenY() {
      DisplayMetrics dm = this.context.getResources().getDisplayMetrics();
      int yDpi = dm.heightPixels;
      return yDpi;
   }
   @SimpleFunction(description = "To get the density dpi of the device in dots-per-inch.")
   public int DensityDpi() {
      DisplayMetrics dm = this.context.getResources().getDisplayMetrics();
      int densityDpi = dm.densityDpi;
      return densityDpi;
   }
   @SimpleFunction(description = "To find the font scaling of the device screen")
   public float FontScale() {
   DisplayMetrics dm = this.context.getResources().getDisplayMetrics();
     float fs=dm.density;
     return fs;
   }
   @SimpleProperty(
      category = PropertyCategory.APPEARANCE,
      description = "Get current brightness of user's phone. Minimum value is 0."
   )
   public int Brightness() {
      
         return System.getInt(this.context.getContentResolver(), "screen_brightness", 0);
      
   }
  @SimpleFunction(description="To get the screen physical height")
  public float PhysicalHeight(){
     DisplayMetrics dm = this.context.getResources().getDisplayMetrics();
    
   float a=  dm.widthPixels / dm.xdpi;
    return a;
    
    
  }
  
}
