package remote.interfaces.impl;

import remote.appliances.CeilingFan;
import remote.interfaces.Command;

public class CeilingFanOnCommand implements Command {

	CeilingFan ceilingFan;

	public CeilingFanOnCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
	public void execute() {
		ceilingFan.high();
	}
}
