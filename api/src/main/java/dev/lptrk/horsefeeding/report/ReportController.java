package dev.lptrk.horsefeeding.report;

import dev.lptrk.horsefeeding.horse.HorseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller class provides endpoints for generating reports related to horse feedings.
 */
@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * Retrieves a list of HorseDTOs whose feeding times fall outside of their scheduled feeding ranges.
     *
     * @return A list of HorseDTOs with missed feeding ranges.
     */
    @GetMapping("/missed")
    public ResponseEntity<List<HorseDTO>> getHorsesWithMissedFeedingRange() {
        return ResponseEntity.ok(reportService.getHorsesWithMissedFeedingRange());
    }
}
