package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  private final WPI_TalonSRX m_leftMotor = new WPI_TalonSRX(2);
  private final WPI_TalonSRX m_rightMotor = new WPI_TalonSRX(4);
  private final WPI_TalonSRX s_rightMotor = new WPI_TalonSRX(1);
  private final WPI_TalonSRX s_leftMotor = new WPI_TalonSRX(5);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  private final XboxController m_stick = new XboxController(1);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightMotor.setInverted(true);
    s_rightMotor.setInverted(true);
    m_leftMotor.setInverted(false);
    s_leftMotor.setInverted(false);
    m_leftMotor.configFactoryDefault();
    m_rightMotor.configFactoryDefault();
    s_leftMotor.configFactoryDefault();
    s_rightMotor.configFactoryDefault();
    s_leftMotor.follow(m_leftMotor);
    s_rightMotor.follow(m_rightMotor);
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    m_robotDrive.curvatureDrive(-m_stick.getLeftY()*0.4, -m_stick.getRightX()*0.3, true);
  }
}
