package springboot.service.posts;
import java.util.List;
import java.util.stream.Collectors;

import springboot.domain.posts.PostsRepository;
import springboot.web.dto.PostsListResponseDto;
import springboot.web.dto.PostsResponseDto;
import springboot.web.dto.PostsSaveRequestDto;
import springboot.domain.posts.Posts;

import lombok.RequiredArgsConstructor;
import springboot.web.dto.PostsUpdateRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                                     .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() { // 조회하는 애.
        return postsRepository.findAllDesc().stream() // findAllDesc 메소드의 트랜잭션 어노테이션에 옵션이 하나 추가: readOnly = true -> 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선되기 때문에 등록, 수정, 삭제 기능이 전혀 없는 서비스 메소드에서 사용하는 것을 추천!
                              .map(PostsListResponseDto::new) // postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto로 변환해 List로 반환하는 메소드!
                              .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id) // 해당 아이디에 대응하는 게시글 찾고
                                     .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)); // 예외 케이스 처리

        postsRepository.delete(posts); // 그 게시글을 삭제한다.
    }
}
