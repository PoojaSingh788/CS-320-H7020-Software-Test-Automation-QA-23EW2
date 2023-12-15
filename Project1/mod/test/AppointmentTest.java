import org.example.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
    static Date addTimeToNow(long secToAdd) {
        Date date = new Date();
        long milliSecs = date.getTime();
        date.setTime(date.getTime() + secToAdd*1000);
        return date;
    }

    @Test
    void TestAppointmentId() {
        Date date = addTimeToNow(100);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("", date, "testing");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("12345678901", date, "testing");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment(null, date, "testing");
        });

        Appointment appointment = new Appointment("1234567890", date, "testing");

        Assertions.assertTrue(appointment.getAppointmentId() == "1234567890");
        Assertions.assertTrue(appointment.getAppointmentDate().getTime() == date.getTime());
        Assertions.assertTrue(appointment.getDescription() == "testing");
    }

    @Test
    void TestAppointmentDate() {
        Date date = addTimeToNow(-100);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("1234567890", null, "testing");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("1234567890", date, "testing");
        });

        Date date1 = addTimeToNow(100);
        Appointment appointment = new Appointment("1234567890", date1, "testing");

        Assertions.assertTrue(appointment.getAppointmentId() == "1234567890");
        Assertions.assertTrue(appointment.getAppointmentDate().getTime() == date1.getTime());
        Assertions.assertTrue(appointment.getDescription() == "testing");
    }

    @Test
    void TestDescription() {
        Date date = addTimeToNow(100);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("1234567890", date, null);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("1234567890", date, "");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("1234567890", date, "testingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtesting");
        });

        Appointment appointment = new Appointment("1234567890", date, "testing");

        Assertions.assertTrue(appointment.getAppointmentId() == "1234567890");
        Assertions.assertTrue(appointment.getAppointmentDate().getTime() == date.getTime());
        Assertions.assertTrue(appointment.getDescription() == "testing");

        appointment.setDescription("newDescription");
        Assertions.assertTrue(appointment.getDescription() == "newDescription");
    }
}