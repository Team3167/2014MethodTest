/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package judge.util.sensors;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class MicroSwitch{
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */

	private final DriverStationLCD msg = DriverStationLCD.getInstance();
	private AnalogChannel microswitch = new AnalogChannel(1, 1);


	public double getVoltage(){

		double voltage;
		voltage = microswitch.getVoltage();
		return voltage;

	}


    public boolean switchActivated() {

		if(microswitch.getVoltage() < 2)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
}
