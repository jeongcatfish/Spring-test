package com.jm.blog.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jm.blog.dto.ResponseDto;
import com.jm.blog.model.Beacon;
import com.jm.blog.model.Board;
import com.jm.blog.model.RoleType;
import com.jm.blog.model.pUser;
import com.jm.blog.service.BeaconService;
import com.jm.blog.service.BoardService;
import com.jm.blog.service.UserService;

@RestController
public class BeaconeApiController {

	@Autowired
	private BeaconService beaconService;

	@PostMapping("/api/beacon/save")
	public ResponseDto<Integer> save(@RequestBody Beacon beacon) {
		beaconService.save(beacon);
		return new ResponseDto<Integer>(HttpStatus.OK, 1); // 일단 테스트로 1 보냄
	}

	@PostMapping("/api/beacon/revise/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Beacon beacon) {
		beaconService.reviseById(id, beacon);
		return new ResponseDto<Integer>(HttpStatus.OK, 1); // 일단 테스트로 1 보냄
	}

	// TEST
	@GetMapping("/api/getBeacons")
	public ResponseDto<List> getUsers() {
		List<Beacon> list = beaconService.ListOfBeacon();
		return new ResponseDto<List>(HttpStatus.OK, list);
	}
}
