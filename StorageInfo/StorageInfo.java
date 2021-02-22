package com.amlin.StorageInfo;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;

@DesignerComponent(
   version = 1,
   description = "Storage Info, this extension is made by @oseamiya . If you are ever getting problems related to the blocks then mail at theoseamiya@gmail.com",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = ""
)
@UsesPermissions(
   permissionNames = "android.permission.READ_EXTERNAL_STORAGE,android.permission.READ_PHONE_STATE,android.permission.ACCESS_NETWORK_STATE,android.permission.ACCESS_WIFI_STATE,android.permission.INTERNET,android.permission.CHANGE_WIFI_STATE,android.permission.ACCESS_COARSE_LOCATION"
)
@SimpleObject(
   external = true
)
public class StorageInfo extends AndroidNonvisibleComponent {
   private ComponentContainer container;
   private static final String LOG_TAG = "DeviceInfo";
   private final Context context;

   public StorageInfo(ComponentContainer container) {
      super(container.$form());
      this.container = container;
      this.context = container.$context();
   }

   @SimpleFunction(
      description = "Total free RAM size in Gigabytes"
   )
   public long MemoryFree() {
      MemoryInfo mi = new MemoryInfo();
      ((ActivityManager)this.context.getSystemService("activity")).getMemoryInfo(mi);
      return mi.availMem / 1048576L;
   }

   @SimpleFunction(
      description = "Total RAM size in Gigabytes"
   )
   public long MemoryTotal() {
      MemoryInfo mi = new MemoryInfo();
      ((ActivityManager)this.context.getSystemService("activity")).getMemoryInfo(mi);
      return mi.totalMem / 1048576L;
   }

   @SimpleFunction(
      description = "Returns size of used-memory in Gigabytes"
   )
   public long MemoryUsed() {
      return this.MemoryTotal() - this.MemoryFree();
   }

   @SimpleFunction(
      description = "Returns size of available internal storage in Gigabytes"
   )
   public long InternalStorageAvailable() {
      StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
      return (long)stat.getAvailableBlocks() * (long)stat.getBlockSize() / 1048576L;
   }

   @SimpleFunction(
      description = "Returns total size of internal storage in Gigabytes"
   )
   public long InternalStorageTotal() {
      StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
      return (long)stat.getBlockCount() * (long)stat.getBlockSize() / 1048576L;
   }

   @SimpleFunction(
      description = "Returns size of used-internal-storage in Gigabytes"
   )
   public long InternalStorageUsed() {
      return this.InternalStorageTotal() - this.InternalStorageAvailable();
   }

   @SimpleFunction(
      description = "Returns available size of external storage in Gigabytes"
   )
   public long ExternalStorageAvailable() {
      if (!this.externalStorageAvailable()) {
         return 0L;
      } else {
         StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
         return (long)stat.getAvailableBlocks() * (long)stat.getBlockSize() / 1048576L;
      }
   }

   @SimpleFunction(
      description = "Returns total external storage size in Gigabytes"
   )
   public long ExternalStorageTotal() {
      if (!this.externalStorageAvailable()) {
         return 0L;
      } else {
         StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
         return (long)stat.getBlockCount() * (long)stat.getBlockSize() / 1048576L;
      }
   }

   @SimpleFunction(
      description = "Returns size of used-external-storage in Gigabytes"
   )
   public long ExternalStorageUsed() {
      return this.ExternalStorageTotal() - this.ExternalStorageAvailable();
   }

   public boolean externalStorageAvailable() {
      return Environment.getExternalStorageState().equals("mounted");
   }
}
