package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class makerobotdrive extends OpMode {
    private DcMotor rF,rB,lF,lB;




    @Override
    public void init() {
        rF = hardwareMap.dcMotor.get("RF");
        rB = hardwareMap.dcMotor.get("RB");
        lF = hardwareMap.dcMotor.get("LF");
        lB = hardwareMap.dcMotor.get("LB");

        rF.setDirection(DcMotorSimple.Direction.REVERSE);
        rB.setDirection(DcMotorSimple.Direction.REVERSE);

        rF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        telemetry.addLine("Initialized");

    }

    @Override
    public void loop() {
        if (Math.abs(gamepad1.left_stick_y) > 0.05 || Math.abs(gamepad1.left_stick_x) > 0.05) {
            if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                lF.setPower(gamepad1.left_stick_x);
                lB.setPower(-gamepad1.left_stick_x);
                rF.setPower(-gamepad1.left_stick_x);
                rB.setPower(gamepad1.left_stick_x);
            } else if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x)) {
                lF.setPower(-gamepad1.left_stick_y);
                lB.setPower(-gamepad1.left_stick_y);
                rF.setPower(-gamepad1.left_stick_y);
                rB.setPower(-gamepad1.left_stick_y);
            } else {
                if (!gamepad1.right_bumper && !gamepad1.left_bumper && Math.abs(gamepad1.right_stick_x) <= 0.05 && Math.abs(gamepad1.right_stick_y) <= 0.05 && Math.abs(gamepad1.left_stick_x) <= 0.05 && Math.abs(gamepad1.left_stick_y) <= 0.05) {
                    lF.setPower(0);
                lB.setPower(0);
                rB.setPower(0);
                rF.setPower(0);
            }
            }
            telemetry.addData("RF Power",rF.getPower());
            telemetry.addData("RB Power",rB.getPower());
            telemetry.addData("LF Power",lF.getPower());
            telemetry.addData("LB Power",lB.getPower());
            telemetry.addData("Left Stick Y Pos", gamepad1.left_stick_y);
            telemetry.update();
        } else {
            if (!gamepad1.right_bumper && !gamepad1.left_bumper && Math.abs(gamepad1.right_stick_x) <= 0.05 && Math.abs(gamepad1.right_stick_y) <= 0.05 && Math.abs(gamepad1.left_stick_x) <= 0.05 && Math.abs(gamepad1.left_stick_y) <= 0.05) {
                lF.setPower(0);
                lB.setPower(0);
                rB.setPower(0);
                rF.setPower(0);
            }
        }
        if (Math.abs(gamepad1.right_stick_x) > 0.05 || Math.abs(gamepad1.right_stick_y) > 0.05) {
            if (gamepad1.right_stick_x > 0) {
                lF.setPower(gamepad1.right_stick_x);
                lB.setPower(gamepad1.right_stick_x);
                rF.setPower(-gamepad1.right_stick_x);
                rB.setPower(-gamepad1.right_stick_x);
            } else if (gamepad1.right_stick_x < 0) {
                lF.setPower(gamepad1.right_stick_x);
                lB.setPower(gamepad1.right_stick_x);
                rF.setPower(-gamepad1.right_stick_x);
                rB.setPower(-gamepad1.right_stick_x);
            }
            telemetry.addData("RF Power",rF.getPower());
            telemetry.addData("RB Power",rB.getPower());
            telemetry.addData("LF Power",lF.getPower());
            telemetry.addData("LB Power",lB.getPower());
            telemetry.addData("Left Stick Y Pos", gamepad1.left_stick_y);
            telemetry.update();
        }
        if (gamepad1.right_bumper) {
            lF.setPower(1);
            lB.setPower(-1);
            rF.setPower(-1);
            rB.setPower(1);
        } else if (gamepad1.left_bumper) {
            lF.setPower(-1);
            lB.setPower(1);
            rF.setPower(1);
            rB.setPower(-1);
        } else {
            if (!gamepad1.right_bumper && !gamepad1.left_bumper && Math.abs(gamepad1.right_stick_x) <= 0.05 && Math.abs(gamepad1.right_stick_y) <= 0.05 && Math.abs(gamepad1.left_stick_x) <= 0.05 && Math.abs(gamepad1.left_stick_y) <= 0.05) {
                lF.setPower(0);
                lB.setPower(0);
                rB.setPower(0);
                rF.setPower(0);
            }
        }


    }
}