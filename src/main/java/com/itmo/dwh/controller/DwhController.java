package com.itmo.dwh.controller;

import com.itmo.dwh.dto.BookingStatRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/api/dwh")
@RestController
public class DwhController {
    //получение информации о предоставленных услугах и возврат переданных id
    @PostMapping(path = "/booking", produces = "application/json")
    public ResponseEntity<?> GetLastDayServices(@Valid @RequestBody List<BookingStatRequestDTO> bookings){
        if(bookings.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        List<Long> listId = bookings.stream().map(x->x.id()).toList();
        return new ResponseEntity<>(listId,HttpStatus.OK);
    }
}
