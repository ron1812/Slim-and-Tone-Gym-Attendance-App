package com.management.attendance.service;

import com.management.attendance.dto.MemberDTO;
import com.management.attendance.entity.Member;
import com.management.attendance.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MemberService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MemberRepository memberRepository;

    public void addMember(MemberDTO memberDTO){
        Member memberEntity = modelMapper.map(memberDTO, Member.class);
        memberRepository.save(memberEntity);
    }

    public  Page<MemberDTO> getMembers(Pageable pageable, String name){
        Page<Member> memberEntity = memberRepository.findByName(name, pageable);
        return memberEntity.map(MemberDTO::new);
    }

    public  MemberDTO getMemberById(Long memberId){
        Optional<Member> memberEntity = memberRepository.findById(memberId);
        if(memberEntity.isPresent())
            return modelMapper.map(memberEntity.get(),MemberDTO.class);
        return null;
    }
}
