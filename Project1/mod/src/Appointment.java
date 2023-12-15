package org.example;

import java.util.Date;
import java.util.Objects;

public class Appointment {
    private String appointmentId;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        setAppointmentId(appointmentId);
        setAppointmentDate(appointmentDate);
        setDescription(description);
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        if (appointmentId == null || "".equals(appointmentId) || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.appointmentDate = appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || "".equals(description) || description.length() > 50) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return getAppointmentId().equals(that.getAppointmentId()) && getAppointmentDate().equals(that.getAppointmentDate()) && getDescription().equals(that.getDescription());
    }
}
