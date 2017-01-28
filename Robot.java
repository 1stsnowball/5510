package org.usfirst.frc.team5510.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot implements PIDOutput{
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	
	
	RobotDrive myRobot;
	
	//speed controllers, find the ports on the roboRIO
	Victor rightFront;
	Victor rightBack;
	Victor leftFront;
	Victor leftBack;
	
	Joystick xboxController;

	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);
		xboxController = new Joystick(0);
		rightFront = new Victor (1); //port 0
		rightBack = new Victor (2); //port 1
		leftFront = new Victor (3); //port 2
		leftBack = new Victor (4); //port 3
		myRobot = new RobotDrive(rightFront, rightBack, leftFront, leftBack); 
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		//autoSelected = chooser.getSelected();
		autoSelected = SmartDashboard.getString("Auto Selector",
		defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	@Override
	public void autonomousPeriodic() {
		switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}
	}

	@Override
	public void teleopPeriodic() {

		xboxDrive();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {

	}
	
	public void pidWrite(double output){
		
	}
	
	/*private void setReverse(){		//sets robot in reverse mode
			   if(xboxController.getRawButton(4)){ // button 4 is left bumper on controller
				   if(!backwards){
					   forward = !forward;
					   backwards = true;}
			   }
			   else {
				   backwards = false;
			   }
		}
	*/
	private void xboxDrive(){
		/*if (forward) {
			myRobot.tankDrive(xboxController.getRawAxis(5) * 0.9, xboxController.getRawAxis(1) * 0.9, true);

		}
		else {
			myRobot.tankDrive(-xboxController.getRawAxis(1) * 0.9, -xboxController.getRawAxis(5) * 0.9, true);
	
		}
		 */
	
		myRobot.arcadeDrive(xboxController);
		}
}

