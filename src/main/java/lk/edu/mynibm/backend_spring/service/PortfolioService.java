package lk.edu.mynibm.backend_spring.service;

import lk.edu.mynibm.backend_spring.dto.PortfolioRequestDTO;
import lk.edu.mynibm.backend_spring.dto.PortfolioResponseDTO;
import lk.edu.mynibm.backend_spring.model.Portfolio;
import lk.edu.mynibm.backend_spring.repo.PortfolioRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class PortfolioService {

    @Autowired
    private PortfolioRepo portfolioRepo;

    @Autowired
    private ModelMapper modelMapper;

    public PortfolioResponseDTO savePortfolio(PortfolioRequestDTO portfolioRequestDTO) {
        Portfolio portfolio = modelMapper.map(portfolioRequestDTO, Portfolio.class);

        portfolio.setCreatedDate(LocalDate.now());
        portfolio.setLastUpdated(LocalDate.now());

        Portfolio savedPortfolio = portfolioRepo.save(portfolio);
        return modelMapper.map(savedPortfolio, PortfolioResponseDTO.class);
    }

    public PortfolioResponseDTO getPortfolioById(Integer userID) {
        Portfolio portfolio = portfolioRepo.findPortfolioById(userID)
                .orElseThrow(() -> new RuntimeException("Portfolio with ID " + userID + " not found"));
        return modelMapper.map(portfolio, PortfolioResponseDTO.class);
    }

    public PortfolioResponseDTO updatePortfolio(Integer userID, PortfolioRequestDTO portfolioRequestDTO) {
        Portfolio portfolio = portfolioRepo.findById(userID)
                .orElseThrow(() -> new RuntimeException("Portfolio with User ID " + userID + " not found"));

        modelMapper.map(portfolioRequestDTO, portfolio);
        portfolio.setLastUpdated(LocalDate.now());

        Portfolio updatedPortfolio = portfolioRepo.save(portfolio);
        return modelMapper.map(updatedPortfolio, PortfolioResponseDTO.class);
    }
}
