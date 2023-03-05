package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.DriverStation.Alliance;
// import edu.wpi.first.wpilibj.DriverStation;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.StrobeAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;

public class Candle extends SubsystemBase{
    CANdle m_candle = new CANdle(5);
    StrobeAnimation a_strobe = new StrobeAnimation(0, 0, 0);
    //頻閃動畫

    public Candle(){
        m_candle.configFactoryDefault(0);
        m_candle.clearAnimation(0);
        m_candle.setLEDs(0, 0, 0);
        m_candle.configLEDType(LEDStripType.BRG);
        //12V燈條的色號
        m_candle.configBrightnessScalar(0.15);
    }
    public void red(){
        m_candle.clearAnimation(0);
        m_candle.setLEDs(255, 0, 0);
    }
    public void green(){
        m_candle.clearAnimation(0);
        m_candle.setLEDs(0, 255, 0);
    }
    public void blue() {
        m_candle.clearAnimation(0);
        m_candle.setLEDs(0,0,255);
    }
    public void a_strobe(){
        m_candle.animate(a_strobe);
        a_strobe.setNumLed(59);
        a_strobe.setSpeed(0.1);
        a_strobe.setR(85);
        a_strobe.setB(190);
        a_strobe.setG(59);
        //淡紫色
    }
    public void move_light(double y){
        if(y < -0.1){
            m_candle.clearAnimation(0);
            m_candle.setLEDs(0, 255, 0);
        }
        else if(y > 0.15){
            m_candle.animate(a_strobe);
            a_strobe.setR(255);
            a_strobe.setB(0);
            a_strobe.setG(0);
            a_strobe.setNumLed(59);
            a_strobe.setSpeed(y*0.6);
        }
        else{
            m_candle.clearAnimation(0);
            m_candle.setLEDs(0, 0, 0);
        }
    }
}
