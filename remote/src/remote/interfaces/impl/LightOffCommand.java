package remote.interfaces.impl;

import remote.appliances.Light;
import remote.interfaces.Command;

public class LightOffCommand implements Command {
	Light light;
	 
	public LightOffCommand(Light light) {
		this.light = light;
	}
 
	public void execute() {
		light.off();
	}
}
