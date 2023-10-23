package toyproject.interpark.show;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.interpark.show.dto.CreateShowRequest;
import toyproject.interpark.show.dto.UpdateShowRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    // 공연 등록
    @PostMapping("/shows")
    public ResponseEntity<Show> createShow(@RequestBody CreateShowRequest showRequest) {
        showService.createShow(showRequest);
        return null;
    }

    // 공연 전체 조회
    @GetMapping("/shows")
    public ResponseEntity<Show> getShows() {
        showService.getShows();
        return null;
    }

    // 공연 개별 조회
    @GetMapping("/shows/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable int showId) {
        showService.getShowById(showId);
        return null;
    }

    // 공연 정보 수정
    @PatchMapping("/shows/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable int showId, @RequestBody UpdateShowRequest showRequest) {
        showService.updateShow(showId, showRequest);
        return null;
    }

    // 공연 삭제
    @DeleteMapping("/shows/{id}")
    public ResponseEntity<Show> deleteShow(@PathVariable int showId) {
        showService.deleteShow(showId);
        return null;
    }


}
