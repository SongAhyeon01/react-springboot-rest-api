package toyproject.interpark.show;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toyproject.interpark.show.dto.CreateShowRequest;
import toyproject.interpark.show.dto.UpdateShowRequest;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    // 공연 등록
    public Show createShow(CreateShowRequest showRequest) {
        Show newShow = new Show();
        newShow.setShowName(showRequest.getShowName());
        newShow.setShowDate(showRequest.getShowDate());
        newShow.setShowPrice(showRequest.getShowPrice());
        newShow.setTheaterID(showRequest.getTheaterId());
        newShow.setShowPoster(showRequest.getShowPoster());
        return showRepository.save(newShow);
    }

    // 공연 전체 조회
    public List<Show> getShows() {
        return showRepository.findAll();
    }

    // 공연 개별 조회
    public Optional<Show> getShowById(int showId) {
        return showRepository.findById(showId);
    }

    // 공연 정보 수정
    public Show updateShow(int showId, UpdateShowRequest showRequest) {
        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isPresent()) {
            Show existingShow = optionalShow.get();

            existingShow.setShowName(showRequest.getShowName());
            existingShow.setShowDate(showRequest.getShowDate());
            existingShow.setShowPrice(showRequest.getShowPrice());
            existingShow.setTheaterID(showRequest.getTheaterId());
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
