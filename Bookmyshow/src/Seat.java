public class Seat {
    int seatId;
    String seatNumber;
    SeatType type;
    SeatStatus status;
    long lockTimeStamp;

    public Seat(int seatId) {
        this.seatId = seatId;
        this.seatNumber = Integer.toString(seatId);
        this.type = SeatType.Normal;
        this.status = SeatStatus.AVAILABLE;

    }

    public synchronized boolean lock(){
        if(status == SeatStatus.AVAILABLE){
            status = SeatStatus.LOCKED;
            lockTimeStamp = System.currentTimeMillis();
            return true;
        }
        return  false;
    }

    public synchronized void unlock(){
        if(status == SeatStatus.LOCKED){
            status = SeatStatus.AVAILABLE;
            lockTimeStamp = 0;
        }
    }

    public synchronized void unlockIfExpired(long locktimeoutMilliSec){
        if(status == SeatStatus.LOCKED && System.currentTimeMillis()-lockTimeStamp > locktimeoutMilliSec){
            unlock();
        }
    }

    public  synchronized  boolean book(){
        if(status == SeatStatus.LOCKED){
            status = SeatStatus.BOOKED;
            return  true;
        }
        return false;
    }



    public Integer getSeatId() {
        return seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatType getType() {
        return type;
    }

    public SeatStatus getStatus() {
        return status;
    }


}
