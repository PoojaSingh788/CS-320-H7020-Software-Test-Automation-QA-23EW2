import org.example.Appointment;
import org.example.AppointmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    @Test
    void TestSetAppointment() {
        Date date = AppointmentTest.addTimeToNow(100);
        Appointment appointment = new Appointment("1234567890", date, "testing");

        AppointmentService appointmentService = new AppointmentService();
        Assertions.assertTrue(appointmentService.getAppointment(appointment) == null);
        Assertions.assertTrue(appointmentService.setAppointment(appointment) == null);

        Appointment appointment1 = appointmentService.getAppointment(appointment);
        Assertions.assertTrue(appointment.equals(appointment1));
    }

    @Test
    void TestDeleteAppointment() {
        Date date = AppointmentTest.addTimeToNow(100);
        Appointment appointment = new Appointment("1234567890", date, "testing");

        AppointmentService appointmentService = new AppointmentService();
        Assertions.assertTrue(appointmentService.deleteAppointment(appointment) == null);
        Assertions.assertTrue(appointmentService.setAppointment(appointment) == null);

        Appointment appointment1 = appointmentService.deleteAppointment(appointment);
        Assertions.assertTrue(appointment.equals(appointment1));
        Assertions.assertTrue( appointmentService.getAppointment(appointment) == null);

    }
}