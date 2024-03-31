package com.example.blockchain.batch;

import com.example.blockchain.block.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BatchService {
    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private BlockchainService blockchainService;

    public void transferBatch(String batchId, String from, String to) {
        Batch batch = batchRepository.findBatchByBatchId(batchId);
        batch.setCurrentOwner(to);
        batchRepository.save(batch);
        blockchainService.recordTransaction(batchId, from, to);
    }
}
