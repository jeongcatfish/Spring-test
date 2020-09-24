package com.jm.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jm.blog.service.BeaconService;

@Controller
public class BeaconController {

	@Autowired
	private BeaconService beaconService;
	
	@GetMapping("/beacon")
	public String getBeacone(Model model) {
		System.out.println("DDDDDDDDD");
		model.addAttribute("beacons",beaconService.ListOfBeacon());
		return "beacon/beacon";
	}
}
