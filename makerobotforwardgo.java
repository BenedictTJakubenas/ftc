package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class makerobotforwardgo extends OpMode {
    private DcMotor RF,LF,RB,LB;




    @Override
    public void init() {
        RF = hardwareMap.dcMotor.get("RF");
        RB = hardwareMap.dcMotor.get("RB");
        LF = hardwareMap.dcMotor.get("LF");
        LB = hardwareMap.dcMotor.get("LB");

        RF.setDirection(DcMotorSimple.Direction.REVERSE);
        RB.setDirection(DcMotorSimple.Direction.REVERSE);

        RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        telemetry.addLine("Initialized");

    }

    @Override
    public void loop() {
        if (Math.abs(gamepad1.left_stick_y) > 0.05 || Math.abs(gamepad1.left_stick_x) > 0.05) {
            if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                LF.setPower(gamepad1.left_stick_x);
                LB.setPower(-gamepad1.left_stick_x);
                RF.setPower(-gamepad1.left_stick_x);
                RB.setPower(gamepad1.left_stick_x);
            } else if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x)) {
                LF.setPower(-gamepad1.left_stick_y);
                LB.setPower(-gamepad1.left_stick_y);
                RF.setPower(-gamepad1.left_stick_y);
                RB.setPower(-gamepad1.left_stick_y);
            } else {
                LF.setPower(0);
                LB.setPower(0);
                RB.setPower(0);
                RF.setPower(0);
            }
        } else {
            LF.setPower(0);
            LB.setPower(0);
            RB.setPower(0);
            RF.setPower(0);
        }
        if (Math.abs(gamepad1.right_stick_x) > 0.05 || Math.abs(gamepad1.right_stick_y) > 0.05) {
            if (gamepad1.right_stick_x > 0) {
                LF.setPower(gamepad1.right_stick_x);
                LB.setPower(gamepad1.right_stick_x);
                RF.setPower(-gamepad1.right_stick_x);
                RB.setPower(-gamepad1.right_stick_x);
            } else if (gamepad1.right_stick_x < 0) {
                LF.setPower(gamepad1.right_stick_x);
                LB.setPower(gamepad1.right_stick_x);
                RF.setPower(-gamepad1.right_stick_x);
                RB.setPower(-gamepad1.right_stick_x);
            }
        }
        if (gamepad1.right_bumper) {
            LF.setPower(1);
            LB.setPower(-1);
            RF.setPower(-1);
            RB.setPower(1);
        } else if (gamepad1.left_bumper) {
            LF.setPower(-1);
            LB.setPower(1);
            RF.setPower(1);
            RB.setPower(-1);
        } else {
            LF.setPower(0);
            LB.setPower(0);
            RF.setPower(0);
            RB.setPower(0);
        }

        telemetry.addData("RF Power",RF.getPower());
        telemetry.addData("RB Power",RB.getPower());
        telemetry.addData("LF Power",LF.getPower());
        telemetry.addData("LB Power",LB.getPower());
        telemetry.update();
    }
}
