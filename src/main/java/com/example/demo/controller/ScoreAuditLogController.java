@RestController
@RequestMapping("/api/score-logs")
@Tag(name = "ScoreAuditLog")
public class ScoreAuditLogController {
    private final ScoreAuditLogService service;

    public ScoreAuditLogController(ScoreAuditLogService service) {
        this.service = service;
    }

    @PostMapping("/{visitorId}/{ruleId}")
    public ResponseEntity<ScoreAuditLog> create(@PathVariable Long visitorId, @PathVariable Long ruleId, @RequestBody ScoreAuditLog log) {
        return new ResponseEntity<>(service.logScoreChange(visitorId, ruleId, log), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreAuditLog> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLog(id));
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<ScoreAuditLog>> logsByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(service.getLogsByVisitor(visitorId));
    }
}