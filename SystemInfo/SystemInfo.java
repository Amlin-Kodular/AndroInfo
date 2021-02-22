package com.amlin.systeminfo;

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
import android.content.Context;
import android.util.Log;
import android.os.Bundle;


import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;


//
@DesignerComponent(
   version = 1,
   description = "The tool is build by @oseamiya. If you have problem in any blocks then contact me here theoseamiya@gmail.com",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = ""
)

//


@SimpleObject(external = true)


public class SystemInfo extends AndroidNonvisibleComponent {
    private ComponentContainer container;
     private Context context;
     private final PackageManager pm;
    
    
  
  //
  
    public SystemInfo(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        this.context = container.$context();
        this.pm = this.context.getApplicationContext().getPackageManager();
    }
  
  //
  @SimpleProperty(description = "To get the android version of your device")
  public String AndroidVersion() {
      String a = "" + android.os.Build.VERSION.RELEASE;
      return a;
   }
  
   @SimpleProperty(description = "To get the api version of your device")
   public String ApiLevel() {
      String a = "" + android.os.Build.VERSION.SDK_INT;
      return a;
   }
  @SimpleProperty(description="To check bootloader version of the device")
  public String BootLoaderVersion() {
      String a = Build.BOOTLOADER;
      return a;
   }
  @SimpleProperty(description="To get the baseband version of the device, may return 0")
   public String BasebandVersion() {
      String a = Build.getRadioVersion();
      return a;
   }
  @SimpleProperty(description="To get the build number of the device")
   public String BuildNumber() {
      String a = Build.DISPLAY;
      return a;
   }
  @SimpleProperty(description="Get Kernal Version of the device")
   public String KernelVersion() {
      String a = System.getProperty("os.version");
      return a;
   }
  
  @SimpleProperty(description="To get the country code of the device ")
  public String CountryCode() {
      return this.context.getResources().getConfiguration().locale.getCountry();
   }
  
  @SimpleProperty(description="To get the language code  of the device")
  public String LanguageCode() {
      return this.context.getResources().getConfiguration().locale.getLanguage();
   }
 
  
  
}
