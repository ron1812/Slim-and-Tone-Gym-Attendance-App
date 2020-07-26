package com.management.attendance.controller;

import com.management.attendance.dto.MemberDTO;
import com.management.attendance.dto.PaginatedResponse;
import com.management.attendance.service.MemberService;
import com.management.attendance.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping(path="/member",produces = {"application/json; charset=utf-8"}, consumes = {"application/json; charset=utf-8"})
    public ResponseEntity addMembers(@RequestBody @Valid MemberDTO memberDTO){
        memberService.addMember(memberDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/member")
    public ResponseEntity<PaginatedResponse<List<MemberDTO>>> getMembers(
            @RequestParam(name = "pageIndex", required = false, defaultValue = "-1") int pageIndex,
            @RequestParam(name = "pageSize", required = false, defaultValue = "-1") int pageSize,
            @RequestParam(name = "name",defaultValue = "_", required = false) String name
    ){
           return new ResponseEntity<>(memberService.getMembers(PaginationUtils.processPagination(pageIndex,pageSize),name.toLowerCase()),HttpStatus.OK);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<MemberDTO> getMembers(
            @PathVariable(name = "memberId",required = false) Long memberId
    ){
        return new ResponseEntity<>(memberService.getMemberById(memberId),HttpStatus.OK);
    }

}
