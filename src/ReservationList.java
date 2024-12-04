import java.util.ArrayList;

public class ReservationList {

    private ArrayList<Reservation> reservations;

    public ReservationList() {
        reservations = new ArrayList<>();
    }

    public boolean addReservation(DateInterval dateInterval,
                                  Customer customer, OwnedAnimal ownedAnimal) {
        if (dateInterval == null || customer == null || ownedAnimal == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        Reservation newReservation = new Reservation(dateInterval, customer, ownedAnimal);
        return reservations.add(newReservation);
    }

    public void removeReservation(int index) {
        if (index >= 0 && index < reservations.size()) {
            this.reservations.remove(index);
        } else {
            System.out.println("Indeks er ugyldigt.");
        }
    }

    public Reservation getReservation(int index){
        if (index >= 0 && index < reservations.size()) {
            return getReservation(index);
        } else {
             return null;
        }
    }

    public int getNumberOfReservations(){
        return reservations.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ReservationList other = (ReservationList) obj;
        return other.reservations == this.reservations;
    }

    public Reservation getReservationByNumber(int number) {
        for (Reservation res : reservations) {
        if (res.getCustomer().getPhoneNumber() == number) { // Assumes Reservation has getReservationNumber()
            return res;
        }
    }

        return null;
    }

    public Reservation getReservationByName(String name) {
        for (Reservation res : reservations) {
            if (res.getCustomer().getName().equals(name)) { // Assumes Reservation has getReservationNumber()
                return res;
            }
        }
        return null;
    }

    // COMEBACK

    public Reservation extendReservation(Reservation reservation, int extraDays){
        for(Reservation r : reservations)
        {
            if(r.equals(reservation))
            {
                DateInterval newInterval = r.getDateInterval()
                r.setDateInterval(DateInterval newInterval)
            }
        }
    }

    // Tilføj senere: Check "are you sure" besked eller sådan noget

    // HØR STEFFEN
    public Reservation stopReservation(Reservation reservation){
        for(Reservation r : reservations)
        {
            if (r.equals(reservation))
            {
                r.getAnimals()
                reservations.remove(r);

            }
        }

    }

    public void addReservation(Reservation reservation){
      this.reservations.add(reservation);
    }
}
