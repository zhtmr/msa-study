package me.sun.springbootstudy.web.dto.board;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sun.springbootstudy.domain.board.Board;
import me.sun.springbootstudy.domain.board.BoardType;
import me.sun.springbootstudy.domain.member.Member;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class BoardSaveRequestDto {

    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private Integer viewsCount;
    @NotNull
    private BoardType boardType;
    @NotNull
    private String email;


    @Builder
    public BoardSaveRequestDto(String title, String content, int viewsCount, BoardType boardType, String email) {
        this.title = title;
        this.content = content;
        this.viewsCount = viewsCount;
        this.boardType = boardType;
        this.email = email;
    }


    public Board toEntity(Member member) {
        Board board = Board.builder()
                .title(title)
                .content(content)
                .viewsCount(viewsCount)
                .boardType(boardType)
                .member(member)
                .build();
        member.getBoards().add(board);
        return board;
    }

}