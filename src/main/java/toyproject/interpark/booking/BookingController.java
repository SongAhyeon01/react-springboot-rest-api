package toyproject.interpark.booking;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.interpark.booking.dto.CreateBookingRequest;

import java.net.URI;
import java.util.List;

import static org.springframework.web.util.UriComponentsBuilder.fromPath;

@Tag(name = "books", description = "공연 예매 api")
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @Operation(summary = "공연 예매")
    @PostMapping("")
    public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingRequest bookingRequest) {
        int bookingId = bookingService.createBooking(bookingRequest);
        URI uri = fromPath("api/books/{id}")
                .buildAndExpand(bookingId)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "회원 번호로 예매한 공연 조회")
    @GetMapping("/{id}")
    public ResponseEntity<List<GetAllBookingsByUserNumProjection>> getAllBookingsByUserNum(@PathVariable int id) {
        List<GetAllBookingsByUserNumProjection> getBookings = bookingService.getAllBookingsByUserNum(id);
        return ResponseEntity.ok(getBookings);
    }

    @Operation(summary = "예매 번호로 예매 취소")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("예매 취소됨");
    }
}
