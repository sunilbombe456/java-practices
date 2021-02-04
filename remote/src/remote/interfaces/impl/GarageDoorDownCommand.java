package remote.interfaces.impl;

import remote.appliances.GarageDoor;
import remote.interfaces.Command;

public class GarageDoorDownCommand implements Command {

	GarageDoor garageDoor;

	public GarageDoorDownCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public void execute() {
		garageDoor.up();
	}
}
