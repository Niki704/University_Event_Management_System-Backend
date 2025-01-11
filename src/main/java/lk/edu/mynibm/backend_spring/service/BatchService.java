package lk.edu.mynibm.backend_spring.service;

import lk.edu.mynibm.backend_spring.dto.BatchDTO;
import lk.edu.mynibm.backend_spring.model.Batch;
import lk.edu.mynibm.backend_spring.repo.BatchRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BatchService {

    @Autowired
    private BatchRepo batchRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<BatchDTO> getAllBatches() {
        List<Batch> batchList = batchRepo.findAll();
        return modelMapper.map(batchList, new TypeToken<List<BatchDTO>>() {}.getType());
    }

    public void saveBatch(BatchDTO batchDTO) {
        batchRepo.save(modelMapper.map(batchDTO, Batch.class));
//        return "Batch Created Successfully!";
    }

    public List<Batch> addBulkBatches(List<Batch> batches) {
        return batchRepo.saveAll(batches);
    }

    public void updateBatch(String id, BatchDTO batchDTO) {
        Batch batch = batchRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch with ID " + id + " not found"));

        modelMapper.map(batchDTO, batch);
        batchRepo.save(batch);
//        return "Batch Updated Successfully!";
    }

    public void deleteBatchById(String id) {
        batchRepo.deleteById(id);
//        return "Batch Deleted Successfully!";
    }
}
