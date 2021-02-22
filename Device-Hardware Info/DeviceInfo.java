package com.amlin.deviceinfo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;


@DesignerComponent(
   version = 1,
   description = "Extension is made by oseamiya. If you have any problem, message me here:theoseamiya@gmail.com",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = ""
)

@SimpleObject(external = true)



public class DeviceInfo extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context;
    private static final String LOG_TAG = "DeviceInfo";
    private final TelephonyManager tm;
    private final InputMethodManager imm;
    private final PackageManager pm;
    private final Activity activity;
  
  
  
  
  
   
    public DeviceInfo(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        this.context = container.$context();
       Log.d("DeviceInfo", "DeviceInfo Created");
       this.tm = (TelephonyManager)this.context.getSystemService("phone");
       this.imm = (InputMethodManager)this.context.getSystemService("input_method");
       InputMethodManager imm = (InputMethodManager)container.$context().getSystemService("input_method");
       this.pm = this.context.getApplicationContext().getPackageManager();
       this.activity = container.$context();
    }
  
   @SimpleProperty(description = "To get the device name")
   public String DeviceName() {
      String a = Build.DEVICE;
      return a;
   }
  @SimpleProperty(description="To get the manafacturer name")
  public String ManufacturName() {
      String a = Build.MANUFACTURER;
      return a;
   }
  @SimpleProperty(description="To get the Model Name")
  public String ModelName() {
      String a = Build.MODEL;
      return a;
   }
  @SimpleProperty(description="To get the Board Name")
  public String BoardName() {
      String a = Build.BOARD;
      return a;
   }
   @SimpleProperty(description="To get the finger print")
  public String FingerPrint() {
      String a = Build.FINGERPRINT;
      return a;
   }
   @SimpleProperty(description="To get the hardware info")
  public String Hardware() {
      String a = Build.HARDWARE;
      return a;
   }
   @SimpleProperty(description="To get the brand name")
  public String Brand() {
      String a = Build.BRAND;
      return a;
   }
   @SimpleProperty(description="To get the device id")
  public String ID() {
      String a = Build.ID;
      return a;
   }
    @SimpleProperty(description="To get the radio info")
  public String Radio() {
      String a = Build.RADIO;
      return a;
   }
   @SimpleProperty(description="To get the device type")
  public String DeviceType() {
      String a = Build.TYPE;
      return a;
   }
   @SimpleProperty(description="To get the device tags separated by commas")
  public String DeviceTags() {
      String a = Build.TAGS;
      return a;
   }
   @SimpleProperty(description="To get the time at which the build was produced, given in milliseconds since the UNIX epoch.")
  public long Time() {
      long a = Build.TIME;
      return a;
  }
  
  
    @SimpleProperty(description="To get the device product name ")
  public String Product() {
      String a = Build.PRODUCT;
      return a;
  }
   @SimpleProperty(description="To get the display ")
  public String Display() {
      String a = Build.DISPLAY;
      return a;
  }

}
