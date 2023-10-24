package toyproject.interpark.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<GetAllBookingsByUserNumProjection> findAllByBookingUser_UserNum(int userNum);
}
