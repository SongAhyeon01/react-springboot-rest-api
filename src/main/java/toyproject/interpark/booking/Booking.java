package toyproject.interpark.booking;

import jakarta.persistence.*;
import lombok.*;
import toyproject.interpark.show.Show;
import toyproject.interpark.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @JoinColumn(name = "user_num")
    @ManyToOne
    private User bookingUser;

    @JoinColumn(name = "show_id")
    @ManyToOne
    private Show bookingShow;

}
