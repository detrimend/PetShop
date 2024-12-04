import java.util.ArrayList;

public class ReservationList {

    private ArrayList<Reservation> reservation;

    public ReservationList() {
        reservation = new ArrayList<>();
    }

    public boolean addReservation(DateInterval dateInterval,
                                  Customer customer, OwnedAnimal ownedAnimal) {
        if (dateInterval == null || customer == null || ownedAnimal == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        Reservation newReservation = new Reservation(dateInterval, customer, ownedAnimal);
        return reservation.add(newReservation);
    }

    public void removeReservation(int index) {
        if (index >= 0 && index < reservation.size()) {
            this.reservation.remove(index);
        } else {
            System.out.println("Indeks er ugyldigt.");
        }
    }

    public Reservation getReservation(int index){
        if (index >= 0 && index < reservation.size()) {
            return getReservation(index);
        } else {
             return null;
        }
    }

    public int getNumberOfReservations(){
        return reservation.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ReservationList other = (ReservationList) obj;
        return other.reservation == this.reservation;
    }

    public Reservation getReservationByNumber(int number) {
        for (Reservation res : reservation) {
        if (res.getCustomer().getPhoneNumber() == number) { // Assumes Reservation has getReservationNumber()
            return res;
        }
    }

        return null;
    }

    public Reservation getReservationByName(String name) {
        for (Reservation res : reservation) {
            if (res.getCustomer().getName().equals(name)) { // Assumes Reservation has getReservationNumber()
                return res;
            }
        }
        return null;
    }

    public Reservation extendReservation(int lenght){
        return ??
    }

    public Reservation stopReservation()
    {

    }

    public void addReservation(Reservation reservation){
      this.reservation.add(reservation);
    }
}
