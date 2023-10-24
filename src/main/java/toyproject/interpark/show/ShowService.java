package toyproject.interpark.show;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toyproject.interpark.show.dto.CreateShowRequest;
import toyproject.interpark.show.dto.UpdateShowRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    // 공연 등록
    public int createShow(CreateShowRequest showRequest) {

        // String 형을 LocalDateTime 형으로 파싱
        String requestShowDate = showRequest.getShowDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime showDate = LocalDateTime.parse(requestShowDate, formatter);

        Show newShow = new Show();

        newShow.setShowName(showRequest.getShowName());
        newShow.setShowDate(showDate);
        newShow.setShowPrice(showRequest.getShowPrice());
        newShow.setShowPoster(showRequest.getShowPoster());

        return showRepository.save(newShow).getShowId();
    }

    // 공연 전체 조회
    public List<Show> getAllShows() {
        System.out.println(showRepository.findAll().get(0));
        return showRepository.findAll();
    }

    // 공연 개별 조회
    public Optional<Show> getShowById(int showId) {
        return showRepository.findById(showId);
    }

    // 공연 정보 수정
    public Show updateShow(int showId, UpdateShowRequest showRequest) {

        String requestShowDate = showRequest.getShowDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime showDate = LocalDateTime.parse(requestShowDate, formatter);

        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isPresent()) {
            Show existingShow = optionalShow.get();

            existingShow.setShowName(showRequest.getShowName());
            existingShow.setShowDate(showDate);
            existingShow.setShowPrice(showRequest.getShowPrice());
            existingShow.setShowPoster(showRequest.getShowPoster());

            return showRepository.save(existingShow);
        } else {
            throw new EntityNotFoundException();
        }
    }

    // 공연 삭제
    public void deleteShow(int showId) {
        showRepository.deleteById(showId);
    }

}
