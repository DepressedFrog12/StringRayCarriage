package frc.robot.subsystems.Intake;

import static edu.wpi.first.units.Units.*;

import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController.ArbFFUnits;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.LinearVelocity;
import frc.robot.Constants;
import static frc.robot.Constants.*;

public class IntakeIOSparkMax implements IntakeIO {
    private final SparkMax roller = new SparkMax(Constants.IntakeConstants.ROLLER_MOTOR_ID, SparkMax.MotorType.kBrushless);
    private final SparkMax iRoller = new SparkMax(Constants.IntakeConstants.IROLLER_MOTOR_ID, SparkMax.MotorType.kBrushless); 

    private final SparkClosedLoopController rollerController = roller.getClosedLoopController();
    private final SparkClosedLoopController iRollerController = iRoller.getClosedLoopController();  


    public IntakeIOSparkMax() {
    SparkMaxConfig rollerConfig = new SparkMaxConfig();
    
    rollerConfig
        .inverted(false);
    rollerConfig.encoder
        .positionConversionFactor(IntakeConstants.rollerPositionConversionFactor)
        .velocityConversionFactor(IntakeConstants.rollerVelocityConversionFactor);
    rollerConfig.closedLoop
        .pid(IntakeConstants.rollerP, IntakeConstants.rollerI, IntakeConstants.rollerD);

    roller.configure(rollerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    rollerConfig
        .inverted(true);

    iRoller.configure(rollerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }


	@Override
	public void processInputs(IntakeIOInputsAutoLogged inputs) {
        inputs.rollerRPM = roller.getEncoder().getVelocity();
        inputs.iRollerRPM = iRoller.getEncoder().getVelocity();
        inputs.rollerAmps = roller.getOutputCurrent();
        inputs.rollersVolts = roller.getAppliedOutput() * roller.getBusVoltage();
        inputs.rollerTemp = roller.getMotorTemperature();
        inputs.iRollerTemp = iRoller.getMotorTemperature();
    }

	@Override
	public void setRollerVolts(double volts) {
        roller.setVoltage(MathUtil.clamp(volts, -12.0, 12.0));
    }


	@Override
	public void setRollerRPM(AngularVelocity rpm, SimpleMotorFeedforward feedforward) {
        rollerController.setReference(rpm.in(Rotations.per(Minute)), ControlType.kVelocity);
    }

	@Override
	public void setRollerPID(double kP, double kI, double kD) {
        SparkMaxConfig rollerConfig = new SparkMaxConfig();
                rollerConfig
            .closedLoop
            .pid(kP, kI, kD);

        roller.configure(rollerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }
}
