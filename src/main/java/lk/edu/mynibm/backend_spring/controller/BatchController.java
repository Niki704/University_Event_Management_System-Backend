package lk.edu.mynibm.backend_spring.controller;

import lk.edu.mynibm.backend_spring.dto.BatchDTO;
import lk.edu.mynibm.backend_spring.model.Batch;
import lk.edu.mynibm.backend_spring.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v4/")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @GetMapping("/batches/get")
    public List<BatchDTO> getAllBatches() {
        return batchService.getAllBatches();
    }

    @PostMapping("/batches/add")
    public ResponseEntity<String> saveBatch(@RequestBody BatchDTO batchDTO) {
        batchService.saveBatch(batchDTO);
        return ResponseEntity.status(201).body("Batch created successfully");
    }

    @PostMapping("/batches/bulk")
    public ResponseEntity<List<Batch>> addBulk(@RequestBody List<Batch> batches) {
        List<Batch> savedBatches = batchService.addBulkBatches(batches);
        return ResponseEntity.ok(savedBatches);
    }

    @PutMapping("/batches/update/{id}")
    public ResponseEntity<String> updateBatch(@PathVariable String id, @RequestBody BatchDTO batchDTO) {
        batchService.updateBatch(id, batchDTO);
        return ResponseEntity.ok("Batch updated successfully");
    }

    @DeleteMapping("batches/delete/{id}")
    public ResponseEntity<String> deleteBatchById(@PathVariable String id) {
        batchService.deleteBatchById(id);
        return ResponseEntity.ok("Batch deleted successfully");
    }
}
