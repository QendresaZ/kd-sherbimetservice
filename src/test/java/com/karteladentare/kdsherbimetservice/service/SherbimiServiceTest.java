package com.karteladentare.kdsherbimetservice.service;


import com.karteladentare.kdsherbimetservice.domain.Sherbimi;
import com.karteladentare.kdsherbimetservice.exceptions.SherbimiNotFoundException;
import com.karteladentare.kdsherbimetservice.repository.SherbimiRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SherbimiServiceTest {

    @Autowired
    private SherbimiService sherbimiService;

    @MockBean
    private SherbimiRepository sherbimiRepository;

    @Test
    @DisplayName("Test ktheSherbimin Success")
    public void testKtheSherbiminSuccess() throws SherbimiNotFoundException {
        //Setup Mock
        Sherbimi sherbimi = new Sherbimi();
        sherbimi.setId(1L);
        doReturn(Optional.of(sherbimi)).when(sherbimiRepository).findById(1L);

        //Execute the service call
        Sherbimi returnedSherbimi = sherbimiService.ktheSherbimin(1L);

        //Assert
        assertThat(returnedSherbimi).isSameAs(sherbimi);
    }

    @Test(expected = SherbimiNotFoundException.class)
    @DisplayName("Test ktheSherbimin Not Found")
    public void testKtheSherbiminNotFound() throws SherbimiNotFoundException {
        Sherbimi sherbimi = new Sherbimi();
        sherbimi.setId(1L);
        doReturn(Optional.empty()).when(sherbimiRepository).findById(1L);

        Sherbimi returnedSherbimi = sherbimiService.ktheSherbimin(1L);
    }

    @Test
    @DisplayName("Test ktheTeGjitheSherbimet Success")
    public void testKtheTeGjitheSherbimetSuccess() {
        List<Sherbimi> sherbimiList = Arrays.asList(new Sherbimi(), new Sherbimi(), new Sherbimi());
        doReturn(sherbimiList).when(sherbimiRepository).findAll();

        List<Sherbimi> returnedSherbimiList = sherbimiService.ktheTeGjithaSherbimet();

        assertThat(returnedSherbimiList).isEqualTo(sherbimiList);

    }

}
