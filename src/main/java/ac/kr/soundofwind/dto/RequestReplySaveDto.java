package ac.kr.soundofwind.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//댓글 저장이 완료 되면 전달
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestReplySaveDto {
    private int userId;
    private int boardId;
    private String content;
}
