package com.jm.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jm.blog.model.Beacon;
import com.jm.blog.model.Board;
import com.jm.blog.model.pUser;
import com.jm.blog.repository.BeaconRepository;
import com.jm.blog.repository.BoardRepository;
import com.jm.blog.repository.UserRepository;

@Service // 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. Ioc 를 해준다. -> 메모리에 대신 띄어준다?
public class BeaconService {

	@Autowired
	private BeaconRepository beaconRepository;

	@Transactional
	public void save(Beacon beacon) {
		beaconRepository.save(beacon);
	}
	
	@Transactional
	public void reviseById(int id, Beacon beacon) {
		Beacon savedBeacon = beaconRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("fail");
		});
		if(beacon.getName() != null) savedBeacon.setName(beacon.getName());
		if(beacon.getSection() != null) savedBeacon.setSection(beacon.getSection());
		if(beacon.getStatus() != null) savedBeacon.setStatus(beacon.getStatus());
	}
	
	public List<Beacon> ListOfBeacon(){
		return beaconRepository.findAll();
	}
}
