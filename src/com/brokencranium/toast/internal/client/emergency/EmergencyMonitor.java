package com.brokencranium.toast.internal.client.emergency;

import com.brokencranium.toast.airbag.IAirBagListener;
import com.brokencranium.toast.airbag.IAirbag;
import com.brokencranium.toast.gps.IGps;

public class EmergencyMonitor implements IAirBagListener{
	 private IAirbag airbag;
	    private IGps gps;

	    @Override
	    public void deployed() {
	        System.out.println("Emergency occurred at lat " + Integer.toString(gps.getLatitude()) +
	                            " lon " + Integer.toString(gps.getLongitude()) +
	                            "lat " + Integer.toString(gps.getLatitude()) +
	                            "heading " + gps.getHeading() +
	                            " speed " + gps.getSpeed() );

	    }

	    public void setAirbag(IAirbag airbag) {
	        this.airbag = airbag;
	    }

	    public void setGps(IGps gps) {
	        this.gps = gps;
	    }

	    public void shutdown(){
	        airbag.removeListener(this);
	    }

	    public void startup(){
	        airbag.addListener(this);
	    }

}
