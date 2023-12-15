package org.example;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, Appointment> appointmentMap;

    public AppointmentService() {
        this.appointmentMap = new HashMap<>();
    }

    public Appointment setAppointment(Appointment appointment) {
        return appointmentMap.put(appointment.getAppointmentId(), appointment);
    }

    public Appointment deleteAppointment(Appointment appointment) {
        return appointmentMap.remove(appointment.getAppointmentId());
    }

    public Appointment getAppointment(Appointment appointment) {
        return appointmentMap.get(appointment.getAppointmentId());
    }
}
