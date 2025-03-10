package efub.session.blog.heart.domain;

import efub.session.blog.account.domain.Account;
import efub.session.blog.post.domain.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostHeart {
    // 게시글 좋아요 id 작성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_heart_id")
    private Long id;

    // 게시글 - Post 참조
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "게시글은 필수로 입력되어야 합니다.")
    @JoinColumn(name = "post_id",updatable = false) // 업데이트 안됨
    private Post post;

    // 작성자 - writer 참조
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "작성자는 필수로 입력되어야 합니다.")
    @JoinColumn(name = "account_id", updatable = false) // account_id 를 참조함
    private Account writer;

    // Builder 패턴을 통해 post, account 자동 생성
    @Builder
    public PostHeart(Post post, Account account){ // builder로 post와 account 자동 생성
        this.post = post;
        this.writer = account;
    }
}
