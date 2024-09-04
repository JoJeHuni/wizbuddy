package com.intbyte.wizbuddy.like.service;

import com.intbyte.wizbuddy.like.domain.entity.NoticeBoardLiked;
import com.intbyte.wizbuddy.like.dto.NoticeBoardLikedDTO;
import com.intbyte.wizbuddy.like.repository.NoticeBoardLikedRepository;
import com.intbyte.wizbuddy.like.vo.response.ResponseInsertNoticeBoardLikeVO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NoticeBoardLikedService {

    private final NoticeBoardLikedRepository noticeBoardLikedRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public ResponseInsertNoticeBoardLikeVO registerNoticeBoardLike(NoticeBoardLikedDTO noticeBoardLikedInfo) {

        NoticeBoardLiked noticeBoardLiked = NoticeBoardLiked.builder()
                                           .noticeLikedCode(noticeBoardLikedInfo.getNoticeCode())
                                           .createdAt(LocalDateTime.now())
                                           .employeeCode(noticeBoardLikedInfo.getEmployeeCode())
                                           .shopCode(noticeBoardLikedInfo.getShopCode())
                                           .noticeCode(noticeBoardLikedInfo.getNoticeCode())
                                           .build();

        noticeBoardLikedRepository.save(noticeBoardLiked);
        return modelMapper.map(noticeBoardLiked, ResponseInsertNoticeBoardLikeVO.class);
    }
}