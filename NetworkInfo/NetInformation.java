package com.amlin.netinformation;

import android.content.Context;
import android.util.Log;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;

//other imports
import android.telephony.TelephonyManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


@DesignerComponent(
   version = 1,
   description = "This extension is created by @oseamiya. If you have any problem related to the extension then you can directly message me here, theoseamiya@gmail.com",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = ""
)

@SimpleObject(external = true)
public class NetInformation extends AndroidNonvisibleComponent {
    private ComponentContainer container;
     private final Context context;
  
  
    public NetInformation(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        this.context = container.$context();
    }
  
  @SimpleFunction(description = "To get the IMEI number 1")
    public String Imei1(){
      TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
      return tm.getDeviceId(0);
    }
   @SimpleFunction(description = "To get the IMEI number 2")
    public String Imei2(){
      TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
      return tm.getDeviceId(1);
    }
    @SimpleFunction(description="To get the meid  of the device")
  public String MEID(int slot){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.getMeid(slot);
  }
   @SimpleFunction(description="To get the sim operator name")
  public String SimOperatorName(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.getSimOperatorName ();
  }
  @SimpleFunction(description="Whether the device supports configuring the DTMF tone length.")
  public boolean IsDTFM(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.canChangeDtmfToneLength();
  }
  @SimpleFunction(description="To get the sim country iso")
  public String SimCountryIso(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.getSimCountryIso();
  }
  @SimpleFunction(description="Returns the MCC+MNC (mobile country code + mobile network code) of the provider of the SIM.")
  public String SimOperator(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.getSimOperator();
  }
   @SimpleFunction(description="To get the sim serial number.")
  public String SimSerialNumber(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.getSimSerialNumber();
  }
  @SimpleFunction(description="Returns the unique subscriber ID, for example, the IMSI for a GSM phone")
  public String SubscriberId(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.getSubscriberId();
  }
   @SimpleFunction(description="Returns the phone number string for line 1, for example, the MSISDN for a GSM phone for a particular subscription.")
  public String LineOneNumber(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.getLine1Number();
  }
   @SimpleFunction(description="Returns the serial number of the SIM, if applicable.")
  public String SerialNumber(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.getSimSerialNumber();
  }
  @SimpleFunction(description="To get the country iso.Returns the ISO-3166-1 alpha-2 country code equivalent of the MCC (Mobile Country Code) of the current registered operator or the cell nearby, if available.")
  public String NetworkCountryIso(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.getNetworkCountryIso();
  }
   @SimpleFunction(description="Has the calling application been granted carrier privileges by the carrier")
  public boolean HasCarrierPrivilege(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.hasCarrierPrivileges();
  }
  
   @SimpleFunction(description="Returns whether mobile data is enabled or not per user setting")
  public boolean IsDataEnabled(){
     TelephonyManager tm = (TelephonyManager)this.context.getSystemService("phone");
    return tm.isDataEnabled();
  }
  @SimpleFunction(description="Which one is connected either data or wifi")
  public String IsDataOrWifi(){
	  
	  ConnectivityManager cm = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo info = cm.getActiveNetworkInfo();
    return info.getTypeName();
  }
  
}
