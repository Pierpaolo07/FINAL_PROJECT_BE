package com.ElvanoSablone.workshop.configurations;


import com.ElvanoSablone.workshop.persistence.entities.Order;
import com.ElvanoSablone.workshop.presentation.dto.OrderDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkshopConfiguration {


   @Bean
    public ModelMapper modelMapper() {


        return new ModelMapper();
    }





}


//usare gestione normale, quella che in musicfy utilizziamo con songs, quindi senza i convert dei Date