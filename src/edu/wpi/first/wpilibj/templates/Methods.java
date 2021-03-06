/*
 * 
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import judge.util.JoystickButton;
import judge.util.sensors.MicroSwitch;

/**
 *
 * @author Eric Slaweski: Dashie96(github)
 */
public class Methods
{
    //Joystick Stuff
    private Joystick driver;
    private Joystick shooter;
    private JoystickButton driver1;
    private JoystickButton driver2;
    private JoystickButton driver3;
    private JoystickButton driver4;
    private JoystickButton driver5;
    private JoystickButton driver6;
    private JoystickButton driver7;
    private JoystickButton driver8;
    private JoystickButton driver9;
    private JoystickButton driver10;
    private JoystickButton driver11;
    private JoystickButton driver12;
    private JoystickButton shooter1;
    private JoystickButton shooter2;
    private JoystickButton shooter3;
    private JoystickButton shooter4;
    private JoystickButton shooter5;
    private JoystickButton shooter6;
    private JoystickButton shooter7;
    private JoystickButton shooter8;
    private JoystickButton shooter9;
    private JoystickButton shooter10;
    private JoystickButton shooter11;
    private JoystickButton shooter12;
    //Joystick Stuff
    
    //Drive Things
    private Jaguar leftDrive;
    private Jaguar rightDrive;
    private RobotDrive drive;
    private boolean directionToggle;
    //Drive Things
    
    //Grabber
    private Jaguar leftGrabber;
    private Jaguar rightGrabber;
    private Jaguar grabberSpinner;
    private double grabberArmSpeed;
    private boolean grabberPreviouslyUp;
    //Grabber
    
    //Shooter
    private Jaguar shooterBL; //Back left
    private Jaguar shooterBR; //Back right
    private Jaguar shooterMR; //Middle right
    private Jaguar shooterML; //Middle left
    private Jaguar shooterFR; //Front Right
    private Jaguar shooterFL; //Front left
    private double setSpeed;
    private double variance;
    private boolean varianceToggle;
    //Shooter
    
    //Driver Station
    private final DriverStationLCD msg = DriverStationLCD.getInstance();
    //Driver Station
    
    //Ultrasonic Sensor
    private double finalDistance;
    private Ultrasonic distanceSensor;
    //Ultrasonic Sensor
    
    //Microswitch
    private MicroSwitch switch1;
    //Microswitch
    
    //Timers
    private Timer autonomousDriveTimer;
    private boolean startOnce;
    //Timers
 
    public Methods()
    {
        //Joystick Stuff
        driver = new Joystick(2);// the right Joystick
        driver1 = new JoystickButton(driver, 1);
        driver2 = new JoystickButton(driver, 2);
        driver3 = new JoystickButton(driver, 3);
        driver4 = new JoystickButton(driver, 4);
        driver5 = new JoystickButton(driver, 5);
        driver6 = new JoystickButton(driver, 6);
        driver7 = new JoystickButton(driver, 7);
        driver8 = new JoystickButton(driver, 8);
        driver9 = new JoystickButton(driver, 9);
        driver10 = new JoystickButton(driver, 10);
        driver11 = new JoystickButton(driver, 11);
        driver12 = new JoystickButton(driver, 12);
        shooter = new Joystick(1);// the left Joystick
        shooter1 = new JoystickButton(shooter, 1);
        shooter2 = new JoystickButton(shooter, 2);
        shooter3 = new JoystickButton(shooter, 3);
        shooter4 = new JoystickButton(shooter, 4);
        shooter5 = new JoystickButton(shooter, 5);
        shooter6 = new JoystickButton(shooter, 6);
        shooter7 = new JoystickButton(shooter, 7);
        shooter8 = new JoystickButton(shooter, 8);
        shooter9 = new JoystickButton(shooter, 9);
        shooter10 = new JoystickButton(shooter, 10);
        shooter11 = new JoystickButton(shooter, 11);
        shooter12 = new JoystickButton(shooter, 12);
        //Joystick Stuff
        
        //Drive Things
        leftDrive = new Jaguar(1, 1);
        rightDrive = new Jaguar(1, 4);
        drive = new RobotDrive(leftDrive, rightDrive);
        directionToggle = true;
        //Drive Things
        
        //Grabber
        rightGrabber = new Jaguar(1, 2);
        leftGrabber = new Jaguar(1, 3);
        grabberSpinner = new Jaguar(1, 5);
        //Grabber
        
        //Shooter
        shooterBL = new Jaguar(2, 1);
        shooterBR = new Jaguar(2, 2);
        shooterML = new Jaguar(2, 3);
        shooterMR = new Jaguar(2, 4);
        shooterFL = new Jaguar(2, 5);
        shooterFR = new Jaguar(2, 6);
        setSpeed = 0.0;
        variance = 1;
        varianceToggle = false;
        //Shooter
        
        //Ultrasonic Sensor
        startOnce = true;
        distanceSensor = new Ultrasonic(1, 2);
        distanceSensor.setEnabled(true);
        distanceSensor.setAutomaticMode(true);
        //Ultrasonic Sensor
        
        //Microswitch
        switch1 = new MicroSwitch();
        //Microswitch 
                
                
        
        
    }
    
    public void disabledInit()
    {
        System.out.println("The Robot is ready to Rock and Roll!");
        msg.clear();
        msg.println(DriverStationLCD.Line.kUser2, 1, "The Robot Is Ready To");
        msg.println(DriverStationLCD.Line.kUser3, 1, " Rock And Roll!");
        msg.updateLCD();
    }
    
    public void autonomous()
    {
        msg.clear();
        if(startOnce)
        {
            startOnce = false;
            autonomousDriveTimer.start();
        }
        else if(autonomousDriveTimer.get() < 1)
        {
            leftDrive.set(-.8);
            rightDrive.set(.8);
        }
        else
        {
            leftDrive.set(0.0);
            rightDrive.set(0.0);
        }
    }
    
    public void clear()
    {
        msg.clear();
    }
    
    public void drive()
    {
        if(driver12.HasJustBeenPressed())
        {
            directionToggle = !directionToggle;
        }
        if(directionToggle)
        {
            drive.arcadeDrive(-driver.getY(), -driver.getTwist()); // makin it easer to drive
            msg.println(DriverStationLCD.Line.kUser1, 1, "Driving Forward");
        }
        else
        {
            drive.arcadeDrive(driver.getY(), -driver.getTwist());
            msg.println(DriverStationLCD.Line.kUser1, 1, "Driving in reverse");
        }
    }
    
    public void distance()
    {
        double distance = distanceSensor.getRangeInches();
        msg.println(DriverStationLCD.Line.kUser5, 1, "Distance is " + distance);
    }
    
    public void grabber()
    {
        grabberUpDown();
        grabberPushPull();
    }
    
    public void shooter()
    {
        if (shooter8.IsPressed())
        {
            varianceToggle = true;
        }
        else
        {
            varianceToggle = false;
        }
        
        if (varianceToggle)// are we changeing the variance
        {
            variance = ((shooter.getThrottle() * -1 / 2) + .5);
            if (variance > 1)
            {
                variance = 1;
            }
            else if (variance < 0)
            {
                variance = 0;
            }
            printSpeed(variance);
        }
        else
        {
            setSpeed = ((shooter.getThrottle() * -1 / 2) + .5);
            if (setSpeed > 1)
            {
                setSpeed = 1;
            }
            else if (setSpeed < 0)
            {
                setSpeed = 0;
            }
            printSpeed(setSpeed);
        }

        if (driver4.IsPressed() || shooter4.IsPressed())
        {
            setAllMotors(setSpeed, variance);
        }
        else if (driver6.IsPressed() || shooter6.IsPressed())
        {
            setAllMotors(setSpeed * -1, variance);
            printSpeed(setSpeed);
        }
        else
        {
            setAllMotors(0.0, variance);
        }
    }
    
    private void setAllMotors(double speed)
    {
         if (speed <= 0)
        {
            shooterFL.set(-speed);
            shooterFR.set(speed);
            shooterML.set(-speed);
            shooterMR.set(speed);
            shooterBL.set(-speed);
            shooterBR.set(speed);
        }
        else
        {
            shooterFL.set(-speed);
            shooterFR.set(speed);
            shooterML.set(-speed);
            shooterMR.set(speed);
            shooterBL.set(-speed);
            shooterBR.set(speed);
        }
    }
    
    private void setAllMotors(double speed, double variance)
    {
        if (speed <= 0)
        {
            shooterFL.set(-speed);
            shooterFR.set(speed);
            shooterML.set(-speed);
            shooterMR.set(speed);
            shooterBL.set(-speed);
            shooterBR.set(speed);
        }
        else
        {
            shooterFL.set(-speed);
            shooterFR.set(speed);
            shooterML.set(-speed * variance);
            shooterMR.set(speed * variance);
            shooterBL.set(-speed * (variance * variance));
            shooterBR.set(speed * (variance * variance));
        }
    }
    
    private void printSpeed(double speed)
    {
        int number = (int) (speed * 100);
        if (varianceToggle)
        {
            msg.println(DriverStationLCD.Line.kUser3, 1, "Varaince is: "
                    + number);
        }
        else
        {
            msg.println(DriverStationLCD.Line.kUser3, 1, "Speed is: "
                    + number);
        }
    }
    
    private void grabberUpDown()
    {
        //Marks code
        double grabberSpeedIncrement = 60.0 * 0.3;//Cycle rate in Hertz times speed up time in sec
        double upSpeed = .7;//fightin against gravity
        double downSpeed = -.30;//usin gravity
        double speedLimitUp = 0, speedLimitDown = 0;
        if (driver.getRawAxis(6) == -1 || shooter.getRawAxis(6) == -1)
        {
            grabberArmSpeed += grabberSpeedIncrement;
            speedLimitUp = upSpeed;
            grabberPreviouslyUp = true;
        }
        else if (driver.getRawAxis(6) == 1 || shooter.getRawAxis(6) == 1)
        {
            grabberArmSpeed -= grabberSpeedIncrement;
            speedLimitDown = downSpeed;
            grabberPreviouslyUp = false;
        }
        else if (grabberPreviouslyUp = true && grabberArmSpeed > 0)
        {
            grabberArmSpeed -= grabberSpeedIncrement;
        }
        else if (grabberPreviouslyUp = false && grabberArmSpeed < 0)
        {
            grabberArmSpeed += grabberSpeedIncrement;
        }

        if (grabberArmSpeed > speedLimitUp)
        {
            grabberArmSpeed = speedLimitUp;
        }
        else if (grabberArmSpeed < speedLimitDown)
        {
            grabberArmSpeed = speedLimitDown;
        }

        if (switch1.switchActivated() == false)
        {
            rightGrabber.set(grabberArmSpeed);
            leftGrabber.set(grabberArmSpeed);
        }
        else if (grabberArmSpeed <= 0)
        {
            rightGrabber.set(grabberArmSpeed);
            leftGrabber.set(grabberArmSpeed);
        }
    }
    
    private void grabberPushPull()
    {
        if (driver3.IsPressed() || shooter3.IsPressed())
        {
            grabberSpinner.set(1.0);
        }
        else if (driver5.IsPressed() || shooter5.IsPressed())
        {
            grabberSpinner.set(-1.0);
        }
        else
        {
            grabberSpinner.set(0.0);
        }
    }
}
