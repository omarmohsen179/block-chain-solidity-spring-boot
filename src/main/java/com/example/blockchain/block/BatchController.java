package com.example.blockchain.block;

import com.example.blockchain.batch.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/batches")
public class BatchController {
    @Autowired
    private BatchService batchService;

    @PostMapping("/transfer")
    public ResponseEntity<?> transferBatch(@RequestBody TransferRequest request) {
        batchService.transferBatch(request.getBatchId(), request.getFrom(), request.getTo());
        return ResponseEntity.ok().build();
    }

    // Other endpoints
}
