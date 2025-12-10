// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.PositionVoltage;
// Import TalonFX class
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pivot extends SubsystemBase {
  // Initialize motors, pivot related stuff
  TalonFX pivotMotor;
  TalonFXConfiguration config;
  TalonFXConfigurator configurator;

  public Pivot() {
    pivotMotor = new TalonFX(Constants.PivotConstants.kPivotMotorPort);
    // proportional gain for pid controller
    config.Slot0.withKP(Constants.PivotConstants.kPivotMotorP);
    // soft limit so robot don't break
    config.SoftwareLimitSwitch.withForwardSoftLimitEnable(true);
    config.SoftwareLimitSwitch.withReverseSoftLimitEnable(true);
    config.SoftwareLimitSwitch.withForwardSoftLimitThreshold(Constants.PivotConstants.kPivotMotorForwardSoftLimit);
    config.SoftwareLimitSwitch.withReverseSoftLimitThreshold(Constants.PivotConstants.kPivotMotorReverseSoftLimit);
    // motor brakes when doing nothing, also inverted
    config.MotorOutput.withInverted(InvertedValue.CounterClockwise_Positive);
    config.MotorOutput.withNeutralMode(NeutralModeValue.Brake);

    pivotMotor.getConfigurator().apply(config);
    /* also don't remember this
    configs.apply(pidConfigs);
    configs.apply(softLimits);
    */
    

  }
/*  I don't remember how to do ts
  public Command pivotTo(double pos) {
    pivotMotor.setControl();
  }
*/
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
