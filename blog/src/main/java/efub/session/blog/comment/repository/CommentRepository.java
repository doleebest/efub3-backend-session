package efub.session.blog.comment.repository;

import efub.session.blog.comment.domain.Comment;
import efub.session.blog.account.domain.Account;
import efub.session.blog.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 작성자(writer)별 댓글 목록 조회
    List<Comment> findAllByWriter(Account writer);

    // 게시글(post)별 댓글 목록 조회
    List<Comment> findAllByPost(Post post);

    Comment findByCommentIdAndAndWriter_AccountId(Long commentId, Long accountId);
}