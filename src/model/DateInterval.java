package model;

import java.time.LocalDate;

public class DateInterval {
    private int days;
    private LocalDate startDate;

    public DateInterval(LocalDate startDate, int days){
        this.days=days;
        this.startDate = startDate;
    }


    public boolean isBefore(){
        return LocalDate.now().isBefore(startDate);
    }

    public int getDays() {
        return days;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void set(LocalDate startDate, int days)
    {
        this.days=days;
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        DateInterval other = (DateInterval) obj;
        return other.days == this.days &&
                (other.startDate != null && other.startDate.equals(this.startDate));
    }

    @Override
    public String toString() {
        return "DateInterval{" +
                "days=" + days +
                ", startDate=" + startDate +
                '}';
    }
}
