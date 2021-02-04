package remote.interfaces.impl;

import remote.appliances.Stereo;
import remote.interfaces.Command;

public class StereoOnWithCDCommand implements Command {
	Stereo stereo;
	 
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
 
	public void execute() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
	}
}
