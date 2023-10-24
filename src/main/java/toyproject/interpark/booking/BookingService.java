package toyproject.interpark.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toyproject.interpark.booking.dto.CreateBookingRequest;
import toyproject.interpark.show.Show;
import toyproject.interpark.show.ShowRepository;
import toyproject.interpark.user.User;
import toyproject.interpark.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;

    // 공연 예매
    public int createBooking(CreateBookingRequest createBookingRequest) {
        Optional<User> user = userRepository.findById(createBookingRequest.getUserNum());
        Optional<Show> show = showRepository.findById(createBookingRequest.getShowId());

        if (user.isEmpty() || show.isEmpty()) {
            throw new RuntimeException("해당 id의 user 나 show 가 없음");
        }

        Booking newBooking = new Booking();
        newBooking.setBookingUser(user.get());
        newBooking.setBookingShow(show.get());
        newBooking.setBookingDate(LocalDateTime.now());

        return bookingRepository.save(newBooking).getBookingId();
    }

    // 공연 조회
    public List<GetAllBookingsByUserNumProjection> getAllBookingsByUserNum(int userNum) {
        return bookingRepository.findAllByBookingUser_UserNum(userNum);
    }

    // 예매 취소
    public void deleteBooking(int bookId) {
        bookingRepository.deleteById(bookId);
    }
}
