package com.namng.controller;

import com.namng.object.DeviceInforRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/iot/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DeviceController {

    @GetMapping("getAllDevice")
    public ResponseEntity<DeviceInforRequest> GetAllDeviceInfor(){
        List<DeviceInforRequest> response = new ArrayList<>();

        return ResponseEntity.ok((DeviceInforRequest) response);
    }

    @PutMapping("/changeDeviceState")
    public ResponseEntity<?> ChangeDeviceState(@RequestBody DeviceInforRequest deviceInforRequest){

        return ResponseEntity.ok("change oke");
    }

    @PostMapping("/addDevice")
    public ResponseEntity<?> AddDevice(@RequestBody DeviceInforRequest deviceInforRequest){

        return ResponseEntity.ok("add success!");
    }
}
