package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * This is the code for the 2014 Crusader Robot "Fido" it uses 2 digital
 * sidecars this year. All of this code is available from
 * github.com/Team3167/CrusaderRobot2014 there is also a wiki page on the github
 * so that people can find the controls.
 *
 * @author Eric Slaweski: Dashie96(github)
 */
public class RobotTemplate extends IterativeRobot
{
    private Methods methods;
    public void robotInit()
    {    
        methods = new Methods();
    }

    public void disabledInit()
    {
        methods.disabledInit();
    }

    public void disabledContinuous()
    {
        //nothing goes here!
    }

    public void disabledPeriodic()
    {
        //nothing goes here!
    }

    public void autonomousPeriodic()
    {        
        methods.autonomous();
    }

    public void teleopPeriodic()
    {
        methods.clear();
        methods.drive();
        methods.distance();
        methods.grabber();
        methods.shooter();
    }
}
