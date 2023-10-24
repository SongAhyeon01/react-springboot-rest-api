package toyproject.interpark.booking;

import toyproject.interpark.show.Show;

import java.time.LocalDateTime;

public interface GetAllBookingsByUserNumProjection {
    int getBookingId();
    LocalDateTime getBookingDate();
    Show getBookingShow();
}
