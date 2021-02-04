package remote.interfaces.impl;

import remote.appliances.Light;
import remote.interfaces.Command;

public class LightOnCommand implements Command {

	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}
}
