package dev.lptrk.horsefeeding.report;

import dev.lptrk.horsefeeding.horse.HorseDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/missed")
    public ResponseEntity<List<HorseDTO>> getHorsesWithMissedFeedingRange() {
        return ResponseEntity.ok(reportService.getHorsesWithMissedFeedingRange());
    }
}
