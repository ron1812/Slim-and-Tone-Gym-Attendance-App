package com.management.attendance.service;

import com.management.attendance.dto.MemberDTO;
import com.management.attendance.dto.PaginatedResponse;
import com.management.attendance.dto.Response;
import com.management.attendance.entity.Member;
import com.management.attendance.exception.BadRequestException;
import com.management.attendance.exception.NotFoundException;
import com.management.attendance.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public  PaginatedResponse<List<MemberDTO>> getMembers(Pageable pageable, String name){
        Page<Member> memberEntity = memberRepository.findByName(name, pageable);
        Page<MemberDTO> memberDto = memberEntity.map(MemberDTO::new);

        return new PaginatedResponse<>(memberDto.getContent(), new Response.Pagination(pageable.getPageNumber()
                , pageable.getPageSize(), memberDto.getTotalPages(),memberDto.getTotalElements()));
    }

    public  List<MemberDTO> getMembersV2(Pageable pageable, String name){
        Page<Member> memberEntity = memberRepository.findByName(name, pageable);
        Page<MemberDTO> memberDto = memberEntity.map(MemberDTO::new);
        memberDto.getContent().forEach(System.out::println);
        return memberDto.getContent();
    }

    public  MemberDTO getMemberById(Long memberId){
        Optional<Member> memberEntity = memberRepository.findById(memberId);
        if(memberEntity.isPresent())
            return modelMapper.map(memberEntity.get(),MemberDTO.class);
        throw new NotFoundException();
    }

    public void deleteMemberById(Long memberId){
        if (memberRepository.existsById(memberId)) {
            memberRepository.deleteById(memberId);
        }else{
           throw new NotFoundException();
        }
    }

    public void editMemberById(Long memberId,MemberDTO memberDTO) {
        Optional<Member> memberEntity = memberRepository.findById(memberId);
        if(memberEntity.isPresent()){
            Member memberEntityToEdit = modelMapper.map(memberDTO, Member.class);
            memberEntityToEdit.setId(memberId);
            memberRepository.save(memberEntityToEdit);
        }else{
            throw new BadRequestException("400","There is no entry for the given memberId");
        }
    }


}
