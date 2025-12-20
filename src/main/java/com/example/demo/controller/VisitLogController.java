@RestController
@RequestMapping("/api/visit-logs")
@Tag(name = "VisitLog")
public class VisitLogController {
    private final VisitLogService service;

    public VisitLogController(VisitLogService service) {
        this.service = service;
    }

    @PostMapping("/{visitorId}")
    public ResponseEntity<VisitLog> create(@PathVariable Long visitorId, @RequestBody VisitLog log) {
        return new ResponseEntity<>(service.createVisitLog(visitorId, log), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLog(id));
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<VisitLog>> listByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(service.getLogsByVisitor(visitorId));
    }
}