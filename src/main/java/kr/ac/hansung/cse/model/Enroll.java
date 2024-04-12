package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Enroll {

    @Range(min = 2024, max = 2024, message = "현재 년도는 2024년 입니다")
    private int year;

    @NotEmpty(message = "학기를 입력하세요")
    private String semester;

    @NotEmpty(message = "과목명을 입력하세요")
    private String title;
    @NotEmpty(message = "과목상태를 고르세요")
    private String Status;
    @NotEmpty(message = "교수님성함을 입력하세요")
    private String name;

    @NotNull(message = "학점을 입력하세요")
    @Range(min = 2, max = 3, message = "학점은 2학점 혹은 3학점입니다.")
    private int credit;
}
