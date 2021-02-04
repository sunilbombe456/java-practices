package remote.interfaces.impl;

import remote.appliances.Stereo;
import remote.interfaces.Command;

public class StereoOffCommand implements Command {
	Stereo stereo;
	 
	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}
 
	public void execute() {
		stereo.off();
	}
}
