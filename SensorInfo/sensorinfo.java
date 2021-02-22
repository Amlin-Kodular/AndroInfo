import android.content.Context;
import android.util.Log;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.EventDispatcher;


//Other imports
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.app.Activity;
import android.app.ActivityManager;

//For arrays import
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.io.File;

import java.util.Map;


//Some other imports




@DesignerComponent(
   version = 1,
   description = "This is tool created by amlin.If you have any bugs to be fixed or any function to add then please PM me at Kodular , @amlin",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = ""
)

@SimpleObject(external = true)
public class SensorInformation extends AndroidNonvisibleComponent {
    private ComponentContainer container;
	private Context context;
	 private final Activity activity;
    /**
     * @param container container, component will be placed in
     */
    public SensorInformation(ComponentContainer container) {
        super(container.$form());
        this.container = container;
		this.context = container.$context();
		this.activity = container.$context();
    }
  
      @SimpleFunction(
      description = "It will return all the sensors that are available in your device in the list."
   )
   public Object SensorsList() {
      SensorManager sensorManager = (SensorManager)this.activity.getSystemService("sensor");
      List<Sensor> sensorList = sensorManager.getSensorList(-1);
      List<Map<String, String>> sensorData = new ArrayList();
      Iterator var4 = sensorList.iterator();

      while(var4.hasNext()) {
         Sensor sensor = (Sensor)var4.next();
         Map<String, String> data = new HashMap();
         data.put("name", sensor.getName());
         data.put("vendor", sensor.getVendor());
          data.put("power", String.valueOf(sensor.getPower()));
		 data.put("type", String.valueOf(sensor.getType()));
		 
         sensorData.add(data);
      }

      return sensorData;
   }
  //To return this data, i am now parsing
   @SimpleFunction(
      description = "You can use this block to decode the sensor json to text . Use dictionary , getValueForKey block to decode the json"
   )
  
  public Object Decoder(String sensorData) {
      try {
         return JsonUtil.getObjectFromJson(sensorData);
      } catch (Exception var3) {
         
         return "";
      }
   }
  
}
