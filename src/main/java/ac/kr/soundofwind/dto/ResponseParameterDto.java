package ac.kr.soundofwind.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//응답 DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseParameterDto {
    Object[] params;
}
