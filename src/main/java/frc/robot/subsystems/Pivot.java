// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.PositionVoltage;
// Import TalonFX class
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pivot extends SubsystemBase {
  // Initialize motors, pivot related stuff
  TalonFX pivotMotor;
  Slot0Configs pidConfigs;
  SoftwareLimitSwitchConfigs softLimits;
  TalonFXConfigurator configs;

  public Pivot() {
    pivotMotor = new TalonFX(Constants.PivotConstants.kPivotMotorPort);
    // proportional gain for pid controller
    pidConfigs.withKP(Constants.PivotConstants.kPivotMotorP);
    // soft limits so robot don't break
    softLimits.withForwardSoftLimitEnable(true);
    softLimits.withReverseSoftLimitEnable(true);
    softLimits.withForwardSoftLimitThreshold(Constants.PivotConstants.kPivotMotorForwardSoftLimit);
    softLimits.withReverseSoftLimitThreshold(Constants.PivotConstants.kPivotMotorReverseSoftLimit);
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
