package com.car.parking.car.parking.application.info.client;

import com.pi4j.system.SystemInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.TreeMap;


@RestController
@RequestMapping("/info")
public class InfoRestController {
    @GetMapping(path = "java", produces = "application/json")
    public Map <String, String>getJavaInfo() {
        Map <String, String> map = new TreeMap<>();

        map.put("Vendor ", SystemInfo.getJavaVendor());
        map.put("VendorURL", SystemInfo.getJavaVendorUrl());
        map.put("Version", SystemInfo.getJavaVersion());
        map.put("VM", SystemInfo.getJavaVirtualMachine());
        map.put("Runtime", SystemInfo.getJavaRuntime());

        return map;
    }

    @GetMapping("/hello")
    public String test() {
        return "Hello World";
    }
}
